
### 架构介绍
1. 本项目的安装的maven是 '/usr/local/Cellar/maven/3.8.1/libexec'，响应的项目的maven版本是3.8.1；
2. 本项目使用的tomcat的配置目录为'/Users/rickhuang/Library/apache-tomcat-8.5.68'，相应的使用版本为8.5.68，其中端口号是8080；
3. 作为web应用，使用的servlet版本为3.1.0，需要与maven的设置版本一致；
4. 开启tomcat后相应的网址上下文为'/rick_oa'；
5. 该项目的数据库采用mysql，并且该数据库存储于linux centos7中，需要远程登录访问，并且对数据的处理使用Mybatis框架；
6. 该项目采用MVC架构模式，webapp文件夹作为View，Model作为数据处理的数据库相关类，Controller作为View和Model的桥梁，用Servlet连接Model和View，这样便于分层开发，显示与数据解耦便于维护；
7. 针对该Maven项目采用：
   ```HTML(视图层View) - 
      Servlet(控制层Conttroller) -
      Service(业务逻辑层Model) - 
      Mapper(数据持久层Model) - 
      MySQL(Database)
   ```
8. 该项目使用的依赖包括： mybatis@3.5.3，mysql-connector-java@8.0.25，junit@4.12，logback-classic@1.2.3；
9. 为让mybatis生效，需要创建并且配置'mybatis-config.xml'文件；
10. 在test/文件夹中创建测试用例，查看是否连接收据库；

### 架构介绍
