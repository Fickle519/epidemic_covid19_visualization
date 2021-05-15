## readme
[toc]
作者：尔宣赫 成都信息工程大学 数据可视化 大作业

### 运行所需
0. 互联网(有些前端所用框架可能使用到了互联网上的包)
1. JDK1.8
2. tomcat9以上版本(最好使用9.0.34)
3. IntelIJIDEA编辑器
4. MAVEN(自动化构建工具 下面会写如何安装)
5. 调试最好使用谷歌Chrome浏览器
6. MySQL数据库


### 准备工作
0. 获取数据
第一种方式:
    使用python爬取数据 使用模块
    requests
    json
    jsonpath
    time
    此方法爬取下来的数据需要添加列名
第二种方式：
也可以跳过此步骤（因为已经有爬取好的数据了），直接将数据导入MySQL数据库中[后面有步骤]
[默认爬取了国内34个省份及地区 230个国家和地区的数据(不包含中国)]

1. 部署tomcat9服务器(需要先下载 附带的工具文件夹也有) project structure---->左上角+号---->Tomcat ----->local-----配置tomcat Deployment一定要把Application Context设置成 /epidemic (如果要是使用项目本来就存在的Tomcat服务器(9.0.34版本) 只需要配置tomcat的根目录即可)
2. 部署maven (安装步骤在下面)
3. 工程中pom.xml 右键----->maven---->Reimport
4. 在MySQL数据库中执行SQL语句
    create database epidemic_covid_19 default character set = 'utf8';
    use epidemic_covid_19;
    create table province_epidemic_table(  pname varchar(6),     exactDate date,     totalNum int,     healedNum int,     deadNum int,     increasedNum int );
    create table cosmopolitan_epidemic_table(  pname varchar(15),     exactDate date,     totalNum int,     healedNum int,     deadNum int,     increasedNum int );
5. 右键表格选择import 导入爬取的数据到表中(.csv文件)
6. 工程内修改数据库配置文件 jdbc.properties   
    jdbc.username=你电脑MySQL数据库用户名
    jdbc.password=你电脑MySQL数据库密码

7. 打开浏览器访问 http://localhost:8080/epidemic/index.html
运行成功

### MAVEN安装步骤
maven的下载和配置
   官网地址: https://maven.apache.org/download.cgi  
   下载  apache-maven-3.6.1-bin.zip  (windows系统) 

      settings.xml是maven软件自身的配置文件

   1）解压缩 ->  存放在英文路径下 ->  进入到bin文件夹 
      ->  copy路径配置环境变量 (我的电脑右键)   配置环境变量： https://www.cnblogs.com/greamrod/p/10323520.html
   2）验证安装成功  ->  命令提示符 -> 输入mvn -v (查看版本号)
   3）关联idea  -> File -> settings -> 搜索maven 
      ->  更改maven home directory为自己下载的maven目录
      ->  设置好settings.xml以及本地仓库(刚才下载的setting.xml和repository)
   4）设置conf目录下的settings.xml
       a) 更改本地仓库的配置
        <localRepository>C:\Users\你电脑的用户名\.m2\repository</localRepository>
       b) 通过镜像的方式更好的从中央仓库下载jar包 
        （通常使用阿里云提供的镜像 https://yq.aliyun.com/articles/703623）
    <mirror>
      <id>alimaven</id>
      <name>aliyun maven</name>
  　　<url>http://maven.aliyun.com/nexus/content/groups/public/</url>
      <mirrorOf>central</mirrorOf>        
    </mirror>
       c) 把上述地址copy到settings文件的<mirrors>标签下

    5）在idea的user settings file选项中 找到刚才配置的文件。  
* 其实就是下载好文件然后配置环境变量 然后在IDEA设置里关联MAVEN 然后去修改你关联的setting.xml文件



### 正式运行

见运行截图（搜索支持and搜索）


### 项目亮点

1. 使用python Requests+JSON进行数据爬取
2. 使用MySQL数据库进行数据的导入
3. 使用Java以及Spring、SpringMVC、Mybatis框架(以及Druid连接池,Jackson解析器等)进行后端搭建
4. 前端使用HTML+CSS+JavaScript语言以及JQuery和BootStrap4框架，具有响应式布局等特点(用鼠标拉动浏览器页面会产生相应的变化来帮助用户观看页面)
5. 前端使用Ajax请求技术在不刷新页面的情况下更新页面，用户体验极好