## 阶段二：SpringBoot框架应用

#### 数据库

使用MySQL数据库，数据库名为myData,表user的结构：

create table user

(

id int auto_increment primary key not null,

user_name varchar(20) null,

user_password varchar(20) null

);

#### 集成Druid、logback

配置application.yaml文件，配置Druid

新建DruidConfiguration配置类，实现数据源监视，监控页面为http://localhost:8080/druid/index.html.

配置logback依赖，新建配置logback-spring.xml

#### CRUD

使用JDBC实现数据表操作，代码写在UserController类中

新增一个用户：http://localhost:8080/saveUser?userName=aaa&userPassword=123456

删除一个用户id为1的用户：http://localhost:8080/deleteUser?id=1

修改id为1的用户信息：http://localhost:8080/updateUser?id=1&userNmae=bbb&userPassword=654321

查找id为1的用户：http://localhost:8080/getUser?id=1



