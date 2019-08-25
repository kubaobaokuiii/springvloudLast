package com.imooc.ad.advice;

import com.imooc.ad.annotation.IgnoreResponseAdvice;
import com.imooc.ad.vo.CommonResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 进行响应的统一拦截
 */
@RestControllerAdvice
public class CommonResponseDataAdvice implements ResponseBodyAdvice<Object> {


    /**
     * 根据方法判断
     * @param methodParameter
     * @param aClass
     * @return
     */
    @Override
    @SuppressWarnings("all")  //将警告隐藏掉
    public boolean supports(MethodParameter methodParameter,
                            Class<? extends HttpMessageConverter<?>> aClass) {
        //拿到类的声明被注解标识，被IgnoreResponseAdvice.class标识，不想受到影响，则为false
        if(methodParameter.getDeclaringClass().isAnnotationPresent(

                IgnoreResponseAdvice.class
        )){
            return false;
        }

        if(methodParameter.getMethod().isAnnotationPresent(

                IgnoreResponseAdvice.class
        )){

            return false;

        }

        return true; //其他情况返回true
    }

    /**
     * 在写入响应之前操作
     * @param o
     * @param methodParameter
     * @param mediaType
     * @param aClass
     * @param serverHttpRequest
     * @param serverHttpResponse
     * @return
     */
    @Override
    @Nullable
    @SuppressWarnings("all")
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter,
                                  MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {

        CommonResponse<Object> response = new CommonResponse<>(0,"");

        if(null == o){

            return response;

        }else if(o instanceof  CommonResponse){

            response = (CommonResponse<Object>) o; //强转

        }else {

            response.setData(o);
        }

        return response;
    }
}
