package com.ybe.llwback.vo;

import com.ybe.llwback.entity.UserInfo;
import lombok.Data;

import java.util.List;

/**
 * @author: beier
 * @date: 2020/9/15
 * @description: 用户信息总类
 * @version: 1.0
 */
@Data
public class UserVO {
    private UserInfo userInfo;
    private String roles;
    private List<String> permission;

}
