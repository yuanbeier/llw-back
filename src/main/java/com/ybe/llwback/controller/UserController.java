package com.ybe.llwback.controller;

import com.ybe.llwback.entity.User;
import com.ybe.llwback.entity.UserInfo;
import com.ybe.llwback.entity.security.SecurityUser;
import com.ybe.llwback.service.impl.UserServiceImpl;
import com.ybe.llwback.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;

/**
 * @author: beier
 * @date: 2020/9/15
 * @description: 用户类
 * @version: 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService ;

    /**
     * 获取用户信息
     * @return
     */
    @GetMapping("/getUserInfo")
    public UserVO getUserInfo(){
        UserVO userVO = new UserVO();
        Object principal = SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        if( principal instanceof  SecurityUser){
            Integer userId = ((SecurityUser) principal).getUserId();
            User byId = userService.getById(userId);
            UserInfo userInfo = new UserInfo();
            userInfo.setUsername(byId.getUsername());
            userInfo.setName(byId.getUsername());
            userVO.setUserInfo(userInfo);
            userVO.setRoles("admin");
            userVO.setPermission(new ArrayList<>());
        }
        return userVO;
    }

    /**
     * 退出登录
     * @return
     */
    @GetMapping("/logout")
    public boolean logout(){
        return true;
    }

    @GetMapping
    public String getPrincipal(){
        Object principal = SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        if( principal instanceof  SecurityUser){
            Integer userId = ((SecurityUser) principal).getUserId();
            return userId.toString();
        }
        return "meiy";
    }
    @RequestMapping("/me")
    public Principal me(Principal principal){
        return principal;
    }
}
