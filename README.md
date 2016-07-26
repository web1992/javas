:rocket:搬砖必备，常用工具:rocket:
--

1. 项目结构
	
	> java_note       
	> 所有项目的父项目

	> app	
	> webapp 存放静态文件&jsp 等页面

	> app_tools	    
	> 工具类项目，提供各种快捷开发的工具
	
	> app_assembly    
	> 打包项目为zip等格式的压缩包，具体方法可查看 app_assembly/pom.xml
	
	> app_client      
	> 前端controller 层代码
	
	> app_jetty       
	> 集成jetty，可使用jetty 运行项目

2. 项目运行

        cd java_note
    
        mvn -DskipTests=true clean install -P dev
    
        cd  app_jetty
        
        mvn clean install jetty:run
        
        在浏览器输入： http://127.0.0.1:8081/
    
        出现如下：
    
        Hello World! jetty

3. 
 
4.   