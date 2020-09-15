package com.ybe.llwback.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ybe.llwback.entity.User;
import com.ybe.llwback.mapper.UserMapper;
import com.ybe.llwback.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author: beier
 * @date: 2020/9/15
 * @description: 用户实现类
 * @version: 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
}
