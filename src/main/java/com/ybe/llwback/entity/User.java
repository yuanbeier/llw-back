package com.ybe.llwback.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ybe.llwback.entity.base.BaseEntity;
import lombok.Data;

/**
 * @author:beier
 * @date:2020/3/3
 * @description:com.topevery.sms.platform.pojo
 * @verison:1.0
 */
@Data
@TableName("user")
public class User extends BaseEntity<Integer> {
    private String username;
    private String password;
}
