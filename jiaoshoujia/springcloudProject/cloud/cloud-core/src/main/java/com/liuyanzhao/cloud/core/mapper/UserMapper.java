package com.liuyanzhao.cloud.core.mapper;

import com.liuyanzhao.cloud.api.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 郭双
 * @date
 */

@Mapper
@Component("userMapper")
public interface UserMapper {

    int deleteById(Integer id);

    int insert(User record);

    User findById(Integer id);

    int update(User record);

    List<User> findAll();

}
