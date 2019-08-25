package com.guo.Service;

import com.guo.exception.OrderDiaoUserException;
import com.guo.Model.LoginUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 在订单服务调用用户接口
 */
@FeignClient(name = "user-service",fallbackFactory = OrderDiaoUserException.class)
public interface OrderDiaoUserService {

    @GetMapping("/user/test/{id}")
    LoginUser getUserById(@PathVariable("id") Integer id);

}
