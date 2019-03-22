
## 用户表

|           字段名           |   字段类型    |   字段说明   |
| :------------------------: | :-----------: | :----------: |
|           PK_ID            |    BIGINT     |    主键ID    |
|      MEMBER_USER_CODE      | VARCHAR2(30)  |   用户编号   |
|      MEMBER_USER_NAME      | VARCHAR2(100) |   用户名称   |
| MEMBER_USER_LOGIN_ACCOUNT  | VARCHAR2(30)  | 用户登录账号 |
| MEMBER_USER_LOGIN_PASSWORD | VARCHAR2(200) | 用户登录密码 |
|    MEMBER_USER_TOKEN_ID    | VARCHAR2(200) | 用户TOKENID  |
|   MEMBER_USER_ROLE_CODE    | VARCHAR2(30)  | 用户角色编号 |
|  MEMBER_USER_PHONE_NUMBER  | VARCHAR2(30)  | 用户手机号码 |
|     MEMBER_USER_EMAIL      | VARCHAR2(100) | 用户电子邮箱 |
|  MEMBER_USER_CREATE_DATE   |     DATE      | 记录创建时间 |
|    MEMBER_USER_ORDER_BY    | VARCHAR2(30)  |  记录排序号  |



## 角色表

|         字段名          |   字段类型    |   字段说明   |
| :---------------------: | :-----------: | :----------: |
|          PK_ID          |    BIGINT     |    主键ID    |
|    MEMBER_ROLE_CODE     | VARCHAR2(30)  |   角色编号   |
|    MEMBER_ROLE_NAME     | VARCHAR2(100) |   角色名称   |
| MEMBER_ROLE_CREATE_DATE |     DATE      | 记录创建时间 |
|  MEMBER_ROLE_ORDER_BY   | VARCHAR2(30)  |  记录排序号  |



## 权限表

|             字段名             |   字段类型   |   字段说明   |
| :----------------------------: | :----------: | :----------: |
|             PK_ID              |    BIGINT    |    主键ID    |
|     MEMBER_AUTHORITY_CODE      | VARCHAR2(30) | 权限对照编号 |
|   MEMBER_AUTHORITY_ROLE_CODE   | VARCHAR2(30) |   角色编号   |
| MEMBER_AUTHORITY_RESOURCE_CODE | VARCHAR2(30) |   资源编号   |
| MEMBER_AUTHORITY_RESOURCE_CODE | VARCHAR2(30) |   资源编号   |
|   MEMBER_AUTHORITY_ORDER_BY    | VARCHAR2(30) |  记录排序号  |

##资源表

|           字段名            |   字段类型    |   字段说明   |
| :-------------------------: | :-----------: | :----------: |
|            PK_ID            |    BIGINT     |    主键ID    |
|    MEMBER_RESOURCE_CODE     | VARCHAR2(30)  |   资源编号   |
|    MEMBER_RESOURCE_NAME     | VARCHAR2(100) |   资源名称   |
|    MEMBER_RESOURCE_TYPE     | VARCHAR2(30)  |   资源类型   |
|   MEMBER_RESOURCE_ROUTER    | VARCHAR2(100) |   资源路由   |
|   MEMBER_RESOURCE_REMARK    | VARCHAR2(100) |   资源备注   |
| MEMBER_RESOURCE_CREATE_DATE |     DATE      | 记录创建时间 |
|  MEMBER_RESOURCE_ORDER_BY   | VARCHAR2(30)  |  记录排序号  |

