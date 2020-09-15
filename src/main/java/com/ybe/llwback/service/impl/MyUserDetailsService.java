package com.ybe.llwback.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ybe.llwback.entity.User;
import com.ybe.llwback.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author:beier
 * @date:2020/3/3
 * @description:com.topevery.sms.platform.service
 * @verison:1.0
 */
@Slf4j
@Service
public class MyUserDetailsService  implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.ge("username",username);
        User user = userMapper.selectOne(wrapper);
        if(user == null){
            throw  new UsernameNotFoundException("用户不存在");
        }
        org.springframework.security.core.userdetails.User userdetails =
                new org.springframework.security.core.userdetails.User(
                        user.getUsername(),
                        user.getPassword(),
                        new ArrayList<>());
        return userdetails;
    }
}
