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
    
        cd  app_jetty_dubbo_provider
        
        jetty:run
        
        在浏览器输入： http://127.0.0.1:8082/
    
        出现如下：
    
        200
        说明 `dubbo` 服务提供者启动成功
        
        cd app_jetty
        
        jetty:run
        
        在浏览器输入： http://127.0.0.1:8081/
        
        出现如下：
            
        Hello World! jetty
        
        Hi i from session.
        
        说明 `dubbo` 服务消费者启动成功
        
        

3. 发布的版本

    > [1.0.0][v1.0.0]
    > 集成简单的项目骨架，maven + spring mvc + jetty + velocity
    
     > [2.0.0][v2.0.0]
     > 此版本集成 dubbo, maven + dubbo + spring mvc + jetty + velocity
     >
     > [这里可以找到dubbo][dubbo]
     
    
4.   


[v1.0.0]:https://github.com/web1992/java_note/releases/tag/1.0.0
[v2.0.0]:https://github.com/web1992/java_note/releases/tag/1.0.0
[dubbo]:https://github.com/alibaba/dubbo