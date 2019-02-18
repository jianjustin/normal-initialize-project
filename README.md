### normal-initialize-project
![normal-initialize-project](https://img.shields.io/badge/normal.initialize.project-1.0.0-orange.svg)
[![MIT Licence](https://badges.frapsoft.com/os/mit/mit.svg?v=103)](https://opensource.org/licenses/mit-license.php)

#### 概述

springboot标准化脚手架，用于项目初始化以及技术栈植入测试

#### 技术结构


* [X] Spring Boot
* [X] Spring Data
* [X] Spring MVC
* [X] Swagger 2.0
* [X] springfox
* [X] Spring Security
* [ ] redis
* [ ] mybatis
* [ ] ActiveMQ
* [ ] Spring Statemachine
* [ ] Spring Web Flow



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

* 初始化表结构

>根据`src/main/resources/sql`目录下表结构说明创建表结构

* 初始化表数据

>根据`src/main/resources/sql`目录下`data`结尾`.sql`文件初始化数据

* 启动应用

通过启动springboot项目的方式启动应用,并访问`http://localhost:8080`进行测试

#### 目前工作

* [X] 数据库持久化操作--基于Spring Data
* [X] token权限管理
* [X] swagger API管理
* [ ] 标准化OAuth2实现
* [ ] 增加日志输出和标准化生成
* [ ] 标准化事务处理机制
* [ ] 添加状态机模型和工作流机制
* [ ] 增加消息队列服务API
* [ ] 单元测试覆盖
* [ ] 应用状态监控 
* [ ] 持久化框架引入MyBatis
* [ ] 引入Spring WebFlux替换Spring MVC
* [ ] 引入Spring Cloud重构项目主体代码

#### 联系方式

> 如果你希望共同维护该项目，可以通过提交issues或发送邮件的方式进行沟通

* 邮箱地址：janine.jian.chen@gmail.com
* QQ：717266257
* 微信：CJRMYH
