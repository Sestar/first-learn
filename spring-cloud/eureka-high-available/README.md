# 简述spring-eureka-server创建两个服务端

> spring-eureka-server 通过修改 Args 启动两次  
>
> 第一次启动:    Args: --spring.profiles.active=peer1;  Run一次  
> 加载 application.properties 和 application-peer1.properties 配置文件  
>
> 第二次启动:   Args: --spring.profiles.active=peer2;  再Run一次  
> 加载 application.properites 和 application-pee2.properties 配置文件  
>  
> 访问 http://127.0.0.1:3771/spring-eureka-server  的 Eureka页面,   
> &emsp;Instance currently registered with Eureka 可以看到三个实例, spring-eureka-server-application-1, *.application-2, spring-eureka-client  
>   
> 同样访问 http://127.0.0.1:3772/spring-eureka-server 的Eureka页面, 也能看到上述三个实例