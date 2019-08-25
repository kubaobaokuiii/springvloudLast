# spring-cloud-part2
- springcloud的路由网关(zuul)

在微服务架构中,很多服务需要相互调用,那么调用的路由自然需要进行一个统一的管理,这个时候就用到Zuul的功能了.

zuul的主要功能是**路由转发**和**过滤请求**,
- 路由转发:
比如将/zgd/service/** 开头的,都代表业务接口,都分配给service-a服务,把/zgd/ignore/** 开头的,代表不需要校验登录的分配给公共服务 service-common之类
- 过滤请求:
过滤请求,处理请求参数
