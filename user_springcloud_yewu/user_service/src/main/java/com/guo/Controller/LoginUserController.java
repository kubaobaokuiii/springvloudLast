package com.guo.Controller;


import com.guo.Model.LoginUser;
import com.guo.Service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class LoginUserController {

    @Autowired
    LoginUserService loginUserService;

    public static final String LOGIN_USER = "username";

    /**
     * 判断是添加还是修改的界面
     */
//    @RequestMapping("/saveOrUpdate")
//    public void saveOrUpdate(LoginUser loginUser){
//
//        //判断是否添加还是修改
//        if((Long)loginUser.getId() != null){
//
//            //修改
//            loginUserService.updateUser();
//
//        }else {
//
//            //添加
//            loginUserService.insertUser(loginUser);
//
//        }
//
//    }

//    /**
//     * 进入saveuser.html界面
//     */
//    @RequestMapping("saveUser")
//    public ModelAndView saveUser(){
//
//        return new ModelAndView(new InternalResourceView("/saveuser.jsp"));
//    }

    /**
     * 查询所有用户(right)
     */
    @RequestMapping("/allUser")
    public List<LoginUser> listUsers(Model model) {

        List<LoginUser> list =  loginUserService.listUsers();

        model.addAttribute("loginUser",list);

        return list;
    }


    /**
     * 根据id查询用户(right)
     */

    @RequestMapping("/allUser/{id}")
    public LoginUser getUserById(@PathVariable("id") Integer id,Model model) {

        LoginUser loginUser = loginUserService.getUserById(id);

        model.addAttribute("loginUser",loginUser);

        System.out.println(loginUser);

        return loginUser;
    }

    /**
     * 增加新用户(right)
     */
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public LoginUser insertUser(@RequestBody LoginUser user) {
        LoginUser userId = loginUserService.insertUser(user);
        return userId;
    }

    /**
     * 修改新用户
     */
    @RequestMapping("/updateUser")
    public void updateUser(@RequestBody LoginUser loginUser) {

         loginUserService.updateUser(loginUser);
    }

    /**
     * 删除用户(right)
     */
    @RequestMapping("/deleteUser/{id}")
    public void deleteUserById(@PathVariable("id") Integer id) {

        loginUserService.deleteUserById(id);
    }

    /**
     * 用户的登录与注册退出
     */
    @RequestMapping("login")
    public ModelAndView login(){

        return new ModelAndView(new InternalResourceView("/login.html"));
    }

    //进入登录成功列表界面
    @RequestMapping("list")
    public ModelAndView list(){

        return new ModelAndView(new InternalResourceView("/index.html"));
    }

    @RequestMapping("saveLogin/{username}")
    public ModelAndView saveLogin(@PathVariable("username") String username, HttpSession session){

        ModelAndView modelAndView = new ModelAndView();

        LoginUser user = loginUserService.selectByUserNameAndPwd(username);

        if(user != null){

            //登录成功
            session.setAttribute(LOGIN_USER, user);

            //重定向
            modelAndView.setView(new RedirectView("/list",true));

            return modelAndView;

        }

        modelAndView.addObject("msg", "用户名或密码错误！");

        modelAndView.setView(new InternalResourceView("/login.html"));

        return modelAndView;
    }

    @RequestMapping("logout")
    public ModelAndView logout(HttpSession session){

        session.removeAttribute(LOGIN_USER);

        return new ModelAndView(new RedirectView("/login",true));

    }

    /**
     * 查询用户的列表部分(接前台方法)
     */
    @RequestMapping("/userList")
    public ModelAndView list(Model model){

        List<LoginUser> list = loginUserService.listUsers();

        model.addAttribute("userList",list);

        return new ModelAndView(new RedirectView("/list",true));


    }

    /**
     * 根据机票查看预定此用户的所有信息
     */

    @RequestMapping("/fightToUser/{id}")
    public  List<LoginUser> userToFight(@PathVariable("id") Integer id, Model model) {

        List<LoginUser> userToFight = loginUserService.fightToUser(id);

        model.addAttribute("userToFight",userToFight);

        return userToFight;

    }


}
