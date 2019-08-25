package com.guo.Controller;

import com.guo.Model.FightManagement;
import com.guo.Service.FightManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hangBan")
public class FightManagementController {

    @Autowired
    FightManagementService fightManagementService;

    /**
     * 查询所有飞机管理信息
     */
    @RequestMapping("/allFight")
    public List<FightManagement> listUsers(Model model) {

        List<FightManagement> fightList =  fightManagementService.findAllFight();

        model.addAttribute("fightList",fightList);

        return fightList;
    }


    /**
     * 根据id查询飞机管理
     */

    @RequestMapping("/allFight/{id}")
    public FightManagement getUserById(@PathVariable("id") Integer id, Model model) {

        FightManagement fightMana = fightManagementService.fightId(id);

        model.addAttribute("findFightById",fightMana);

        return fightMana;
    }

    /**
     * 增加飞机管理信息
     */
    @RequestMapping(value = "/addFight", method = RequestMethod.POST)
    public FightManagement insertUser(@RequestBody FightManagement fightManagement) {
        FightManagement fightId = fightManagementService.insertFight(fightManagement);
        return fightId;
    }

    /**
     * 修改飞机管理信息
     */
    @RequestMapping("/updateFight")
    public void updateFight(@RequestBody FightManagement fightManagement) {

        fightManagementService.FightUpdate(fightManagement);
    }

    /**
     * 删除飞机管理信息
     */
    @RequestMapping("/deleteFight/{id}")
    public void FightDeleteById(@PathVariable("id") Integer id) {

        fightManagementService.FightDeleteById(id);
    }

    /**
     * 根据用户查询所对应的机票信息
     */

    @RequestMapping("/userToFight/{id}")
    public List<FightManagement> userToFight(@PathVariable("id") Integer id, Model model) {

        List<FightManagement> userToFight = fightManagementService.userToFight(id);

        model.addAttribute("userToFight",userToFight);

        return userToFight;
    }




}
