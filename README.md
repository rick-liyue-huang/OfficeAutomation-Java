
## Office Automation By Maven Frameworks

Here, I create one Office Automation online application by Maven, whose target is to know about the process of building one Maven project. This project will express how to use Tomcat, Mybatis and Vue3 to connect MySQL database and show the vue3 based html page through Tomcat server.

### Project Frameworks Introduction

1. The project is build on maven, here I use maven 3.8.1 come from '/usr/local/Cellar/maven/3.8.1/libexec', which is only convenient to me;
2. The project use Tomcat 8.5.68, same as Maven edition, I need to record the location in '/Users/rickhuang/Library/apache-tomcat-8.5.68', and Tomcat port set as 8080;
3. As web application, I use servlet 3.1.0 edition, and match with the maven setting;
4. The application on under context of '/rick_oa';
5. This project connect with MySQL that based on the Linux Centos 7, I will set MySQL configuration in 'mybatis-config.xml';
6. 该项目采用MVC架构模式，webapp文件夹作为View，Model作为数据处理的数据库相关类，Controller作为View和Model的桥梁，用Servlet连接Model和View，这样便于分层开发，显示与数据解耦便于维护；The whole project is based on the current known MVC module, which means the following project developing structure:
   ```HTML(视图层View) - 
      Servlet(控制层Conttroller) -
      Service(业务逻辑层Model) - 
      Mapper(数据持久层Model) - 
      MySQL(Database)
   ```;
7. The main dependencies includes mybatis@3.5.3, mysql-connector-java@8.0.25, junit@4.12, logback-classic@1.2.3 and com.alibaba;
8. In order to make mybatis works, I create the configuration file of 'mybatis-config.xml';
9. Try to test its working by create some test files (maybe delete them lately);
10. Add more configuration on 'mybatis-config.xml' to link the 'DruidDataSourceFactory.java';
