package guo.cloud.web.controller;

import guo.cloud.api.model.FightManagement;
import guo.cloud.api.model.HangBanInformation;
import guo.cloud.api.service.FightManagementService;
import guo.cloud.api.service.HangBanInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HangBanInformationController {

    @Autowired
    HangBanInformationService hangBanInformationService;

    /**
     * 根据飞机管理信息id关联航班信息id查询机票余量
     */

    @RequestMapping("/yuPiao/{id}")
    public Integer yuTicketsSelect(@PathVariable("id") Integer fightId, Model model) {

        Integer yuTicketsSelect = hangBanInformationService.yuTicketsSelect(fightId);

        model.addAttribute("yuPiao",yuTicketsSelect);

        return yuTicketsSelect;
    }

    /**
     * 在获取用户信息及飞机信息之后，插入用户id,飞机id及航班随机id及余量及订票时间
     */
    @RequestMapping("/insertUserAndFight/{id}/{fightId}")
    public HangBanInformation insertUserAndFight(@RequestBody HangBanInformation hangBanInformation,@PathVariable("id") Integer id,@PathVariable("fightId") Integer fightId) {

        HangBanInformation insertUserAndFight = hangBanInformationService.insertUserAndFight(hangBanInformation,id,fightId);

        return  insertUserAndFight;

    }

    /**
     * 去航班信息表查询在飞机id下的所有用户的id信息
     */

    @RequestMapping("selectUserIdByFightId/{id}")
    public List<HangBanInformation> selectUserIdByFightId(@PathVariable("id") Integer fightId,Model model) {

        List<HangBanInformation> userIdByFightId = hangBanInformationService.selectUserIdByFightId(fightId);

        model.addAttribute("userIdByFightId","userIdByFightId");

        return userIdByFightId;

    }

    /**
     * 去航班信息表查询在用户id下的所有机票的id信息
     */

    @RequestMapping("selectFightIdByUserId/{id}")
    public List<HangBanInformation> selectFightIdByUserId(@PathVariable("id") Integer id,Model model) {

        List<HangBanInformation> fightIdByUserId = hangBanInformationService.selectFightIdByUserId(id);

        model.addAttribute("fightIdByUserId","fightIdByUserId");

        return fightIdByUserId;

    }

    /**
     * 去航班信息表中实现用户的退订功能（delete）
     */
    @RequestMapping("/deleteUserTicket/{id}/{fightId}")
    public Integer deleteUserTicket(@PathVariable("id") Integer id,@PathVariable("fightId") Integer fightId) {

        return hangBanInformationService.deleteUserTicket(id,fightId);

    }

}
