//package com.guo;
//
//import com.guo.Model.LoginUser;
//import com.guo.Service.LoginUserService;
//import feign.hystrix.FallbackFactory;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@FeignClient(name = "cloud-producer")
//@Component
//public class FallBackUserToFight implements FallbackFactory<LoginUserService> {
//
//    @Override
//    public LoginUserService create(Throwable throwable) {
//
//        return new LoginUserService() {
//
//            @Override
//            public LoginUser getUserById(Integer id) {
//                System.out.println(".....根据id查询用户信息失败");
//                return null;
//            }
//
//            @Override
//            public List<LoginUser> listUsers() {
//                System.out.println(".....查询所有用户信息失败");
//                return null;
//            }
//
//            @Override
//            public void deleteUserById(Integer id) {
//
//                System.out.println(".....删除用户信息失败");
//
//            }
//
//            @Override
//            public void updateUser(LoginUser loginUser) {
//
//                System.out.println(".....更新用户信息失败");
//
//            }
//
//            @Override
//            public LoginUser insertUser(LoginUser user) {
//                System.out.println(".....插入用户信息失败");
//                return null;
//            }
//
//            @Override
//            public LoginUser selectByUserNameAndPwd(String username) {
//                System.out.println(".....根据用户名和密码查询用户");
//                return null;
//            }
//
//            @Override
//            public LoginUser selectByUserName(String username) {
//                System.out.println(".....根据用户名查询用户");
//                return null;
//            }
//
//            @Override
//            public List<LoginUser> fightToUser(Integer id) {
//                System.out.println(".....根据id查询用户");
//                return null;
//            }
//        };
//
//    }
//}
