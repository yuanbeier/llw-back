package com.ybe.llwback.entity;

import lombok.Data;

/**
 * @author: beier
 * @date: 2020/9/15
 * @description: 用户基本信息
 * @version: 1.0
 */
@Data
public class UserInfo {
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户名
     */
    private String name;

    /**
     * 图片地址
     */
    private String avatar ;
}
