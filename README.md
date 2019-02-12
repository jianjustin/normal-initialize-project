### normal-initialize-project

![springboot-learning-demo](https://img.shields.io/badge/springboot--learning--demo-1.0.0-lightgrey.svg)

[![MIT Licence](https://badges.frapsoft.com/os/mit/mit.svg?v=103)](https://opensource.org/licenses/mit-license.php)

#### 概述

springboot基础实现，用于项目初始化以及技术栈植入测试

#### 技术结构



#### 如何使用

* 项目导入

  ```
  git clone git@github.com:jianjustin/normal-initialize-project.git
  ```

  > 并通过导入maven项目的方式导入到工作IDE中

* 创建数据库

  ```sql
   CREATE SCHEMA `normal-database` DEFAULT CHARACTER SET utf8 ;
  ```

* 修改数据库连接

  ```java
   spring.datasource.url=jdbc:mysql://127.0.0.1:3306/normal-database
   spring.datasource.username=root
   spring.datasource.password=123456
   spring.datasource.driver-class-name=com.mysql.jdbc.Driver
  ```

* 创建用户表进行功能测试


  ```sql
   create table member_user(
      PK_ID                  bigint auto_increment comment '自增列',
      MEMBER_USER_CODE       varchar(30)  not null comment '用户编号',
      MEMBER_USER_NAME       varchar(100) null comment '用户名称',
      MEMBER_USER_ACCOUNT    varchar(100) null comment '用户账号',
      MEMBER_USER_PHONE      varchar(100) null comment '用户手机号',
      MEMBER_USER_EMAIL      varchar(100) null comment '用户邮箱',
      MEMBER_USER_PASSWORD   varchar(100) null comment '用户登录密码',
      MEMBER_USER_TOKENID    varchar(100) null comment '用户token',
      MEMBER_USER_LAST_DATE  datetime     null comment '用户最后登录时间',
      MEMBER_USER_ROLE_CODE  varchar(10)  null comment '用户角色编号',
      MEMBER_USER_LIST_ORDER varchar(10)  null comment '用户排序编号',
      constraint member_user_PK_ID_uindex unique (PK_ID)
    )comment '用户';
  ```

  ```sql
    alter table member_user add primary key (PK_ID);
  ```

* 启动应用

通过启动springboot项目的方式启动应用,并访问`http://localhost:8080`进行测试

#### 联系方式

> 如果你希望共同维护该项目，可以通过提交issues或发送邮件的方式进行沟通

* 邮箱地址：janine.jian.chen@gmail.com
* QQ：717266257
* 微信：CJRMYH
