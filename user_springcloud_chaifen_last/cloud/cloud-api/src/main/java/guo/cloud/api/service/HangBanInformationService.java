package guo.cloud.api.service;
import guo.cloud.api.model.HangBanInformation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name = "cloud-producer")
public interface HangBanInformationService {

    /**
     * 根据航班表关联飞机管理信息查询票数余量
     */
    @GetMapping("/hangBan/{id}")
    Integer yuTicketsSelect(@PathVariable("id") Integer fightId);

    /**
     * 在获取用户信息及飞机信息之后，插入用户id,飞机id及航班随机id及余量及订票时间
     */
    @RequestMapping(value = "/hangBan/add/{id}/{fightId}", method = RequestMethod.POST)
    HangBanInformation insertUserAndFight(@RequestBody HangBanInformation hangBanInformation,@PathVariable("id") Integer id,@PathVariable("fightId") Integer fightId);

    /**
     * 去航班信息表查询在飞机id下的所有用户的id信息
     */
    @GetMapping("/hangBanUser/{id}")
    List<HangBanInformation> selectUserIdByFightId(@PathVariable("id") Integer fightId);

    /**
     * 去航班信息表查询在用户id下的所有飞机的id信息
     * @param id
     * @return
     */
    @GetMapping("/hangBanFight/{id}")
    List<HangBanInformation> selectFightIdByUserId(@PathVariable("id") Integer id);

    /**
     * 去航班信息表中实现用户的退订功能（delete）
     */
    @DeleteMapping("/delete/{id}/{fightId}")
    Integer deleteUserTicket(@PathVariable("id") Integer id,@PathVariable("fightId") Integer fightId);

}
