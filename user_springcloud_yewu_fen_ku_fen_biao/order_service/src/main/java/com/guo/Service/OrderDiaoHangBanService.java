package com.guo.Service;

import com.guo.exception.OrderDiaoHangBanException;
import com.guo.Model.FightManagement;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "hang-ban-service",fallbackFactory = OrderDiaoHangBanException.class)
public interface OrderDiaoHangBanService {

    /**
     * 根据ID获得飞机管理信息
     * @param id
     * @return
     */
    @GetMapping("/fight/test/{id}")
    FightManagement fightId(@PathVariable("id") Integer id);


}
