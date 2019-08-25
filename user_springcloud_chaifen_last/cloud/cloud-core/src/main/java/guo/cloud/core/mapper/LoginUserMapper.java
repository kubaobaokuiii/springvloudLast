package guo.cloud.core.mapper;

import guo.cloud.api.model.LoginUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Mapper
@Component("loginUserMapper")
public interface LoginUserMapper {

    //根据id删除用户信息
    int deleteById(Integer id);

    //插入用户信息
    int insert(LoginUser record);

    //查找用户信息
    LoginUser findById(Integer id);

    //更新用户信息
    void update(LoginUser loginUser);

    //查找所有用户信息
    List<LoginUser> findAll();

    //根据用户名和密码找用户
    LoginUser selectByUserNameAndPwd(@Param("username") String username);

    //查询还是修改方法
//    void saveOrUpdate(LoginUser loginUser,Integer id);

    //根据用户名查找用户
    LoginUser selectByUserName(@Param("username") String username);

    //查看预定机票的所有用户
    List<LoginUser> fightToUser(Integer id);


}
