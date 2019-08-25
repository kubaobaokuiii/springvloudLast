### 1.增加gateway网关和路由尝试
2019年1月9日

### 2.增加限流器 
2019年1月10日17:41:54

SpringCloud的限流器本质是令牌桶.除此之外还有漏桶算法.

令牌桶是在一个固定容量的"桶",按固定速率往其中补充令牌,请求需要拿到令牌才能通过.可以允许短时间的突发请求.
漏桶是把请求都先放到"桶"中,按固定速率取出执行,取出的时间是固定的,但是无法应对短时间的突发流量


有两种限流方式,第一种是SpringCloud-gateway的,利用redis来实现令牌桶.只要我们实现`KeyResolve`这个类,然后配置
令牌桶总容量和令牌每秒填充速率就可以了,测试成功

还有一种是github上写一个过滤器:`bucket4j`,[https://github.com/vladimir-bukhtoyarov/bucket4j][],
实现`GatewayFilter`这个过滤器,然后在`GateWayConfig`
中加入这个过滤器,测试成功

当前使用的是第一种限流方式,如果要使用第二种,将`RateLimitByIpGatewayFilter`和`GateWayConfig`的注释去掉,




