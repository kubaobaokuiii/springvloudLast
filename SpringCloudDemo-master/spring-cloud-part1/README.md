# spring-cloud-demo
学习springcloud自己敲的demo
1. 启动eurekaServer,相当于注册中心,其他的client的注册url都是eurekaServer的url
2. 在idea中,启动配置edit Configurations...中的右上角,有一个Single instance only,把它的勾去掉,就可以一个工程启动多个实例了
3. 启动eureka-client-01,再更改端口后再启动eureka-client-01,这就相当于是一个集群
4. 启动service-ribbon,访问http://localhost[service-ribbon的端口]/getHello?name=[任意值],多次访问就可以看到显示在页面上的端口是不同的切换,这就达到了负载均衡