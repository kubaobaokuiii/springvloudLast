package guo.cloud.core.service.impl;

import guo.cloud.api.model.FightManagement;
import guo.cloud.api.model.LoginUser;
import guo.cloud.api.service.FightManagementService;
import guo.cloud.core.mapper.FightManagementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FightManagementServiceImpl implements FightManagementService {

    @Autowired
    private FightManagementMapper fightManagementMapper;

    @Override
    public FightManagement fightId(@PathVariable("id") Integer id) {
        return fightManagementMapper.fightId(id);
    }

    @Override
    public List<FightManagement> findAllFight() {
        return fightManagementMapper.findAllFight();
    }

    @Override
    public void FightDeleteById(@PathVariable("id") Integer id) {
        fightManagementMapper.FightDeleteById(id);
    }

    @Override
    public void FightUpdate(@RequestBody FightManagement fightManagement) {
        fightManagementMapper.FightUpdate(fightManagement);
    }

    @Override
    public FightManagement insertFight(@RequestBody FightManagement fightManagement) {
        Integer fightId = fightManagementMapper.insertFight(fightManagement);
        fightManagement.setFightId(fightId);
        return fightManagement;
    }

    /**
     * 根据用户查询所对应的机票信息
     */

    @Override
    public List<FightManagement> userToFight(@PathVariable("id") Integer id) {

        return fightManagementMapper.userToFight(id);

    }

}
