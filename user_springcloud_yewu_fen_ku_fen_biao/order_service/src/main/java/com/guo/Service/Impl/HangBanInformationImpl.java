package com.guo.Service.Impl;


import com.guo.Mapper.HangBanInformationMapper;
import com.guo.Model.HangBanInformation;
import com.guo.Service.HangBanInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HangBanInformationImpl implements HangBanInformationService {

    @Autowired
    private HangBanInformationMapper hangBanInformationMapper;

    /**
     * 根据航班表关联飞机管理信息查询票数余量
     */
    @Override
    public Integer yuTicketsSelect(@PathVariable("id") Integer fightId) {

        return hangBanInformationMapper.yuTicketsSelect(fightId);
    }


    /**
     * 在获取用户信息及飞机信息之后，插入用户id,飞机id及航班随机id及余量及订票时间
     */
    @Override
    public HangBanInformation insertUserAndFight(@RequestBody HangBanInformation hangBanInformation, @PathVariable("id") Integer id, @PathVariable("fightId") Integer fightId) {

        //首先查询余票,调用查询余票方法
        Integer yuPiao = hangBanInformationMapper.yuTicketsSelect(fightId);

        //判断插入的条件
        if(yuPiao > 0){

            hangBanInformation.setFightId(Long.valueOf(fightId + ""));

            hangBanInformation.setId(Long.valueOf(id + ""));

            Integer hangBanId = hangBanInformationMapper.insertUserAndFight(hangBanInformation);

            hangBanInformation.setHangBanId(Long.valueOf(hangBanId + ""));

        }else{

            System.out.println("暂无余票,禁止插入信息");
        }

        return hangBanInformation;


    }

    /**
     *去航班信息表查询在飞机id下的所有用户的id信息
     */
    @Override
    public List<HangBanInformation> selectUserIdByFightId(@PathVariable("id") Integer fightId) {

        return hangBanInformationMapper.selectUserIdByFightId(fightId);

    }

    /**
     *去航班信息表查询在用户id下的所有飞机的id信息
     */
    @Override
    public List<HangBanInformation> selectFightIdByUserId(@PathVariable("id") Integer id) {

        return hangBanInformationMapper.selectFightIdByUserId(id);

    }

    /**
     * 去航班信息表中实现用户的退订功能（delete）
     */
    @Override
    public Integer deleteUserTicket(@PathVariable("id") Integer id,@PathVariable("fightId") Integer fightId) {

        return hangBanInformationMapper.deleteUserTicket(id,fightId);

    }


}
