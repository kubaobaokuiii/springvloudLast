package com.guo.fiter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * 创建过滤器
 * @Slf4j  是lombok包下面的注解
 * @Component 这样过滤器才能被发现
 */
@Slf4j
@Component
public class PreRequestFilter extends ZuulFilter {

    //定义过滤器的类型
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    //定义过滤器的类型
    @Override
    public int filterOrder() {
        return 0;  //值越小越先被调用
    }


    //定义此过滤器是否应该执行（验证）
    public boolean shouldFilter() {
        //return false;
        return true;
    }


    public Object run() throws ZuulException {

        //记录当前时间戳,请求上下文
        RequestContext ctx = RequestContext.getCurrentContext();//表示这次请求，请求上下文

        ctx.set("startTime",System.currentTimeMillis()); //获取当前时间戳

        return null;
    }
}
