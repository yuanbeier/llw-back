package com.ybe.llwback.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ybe.llwback.entity.base.BaseEntity;
import com.ybe.llwback.enumfilee.ClientUseType;
import lombok.Data;

import java.util.UUID;

/**
 * @author:beier
 * @date:2020/3/11
 * @description:sms.platform.manager.pojo
 * @verison:1.0
 */
@Data
@TableName("app")
public class App extends BaseEntity<Integer> {
    private String clientId;
    private String clientSecret ;
    private String grantTypes;
    private String resourceIds;
    private String callbackUrl;
    private String scopes;
    private ClientUseType userType;
}
