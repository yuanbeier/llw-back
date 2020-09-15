package com.ybe.llwback.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ybe.llwback.entity.App;
import com.ybe.llwback.mapper.AppMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

/**
 * @author:beier
 * @date:2020/3/4
 * @description:com.topevery.sms.platform.oauth2.service
 * @verison:1.0
 */
@Slf4j
@Service
public class CustomClientDitailService implements ClientDetailsService {

    @Autowired
    private AppMapper appMapper;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        QueryWrapper<App> wrapper = new QueryWrapper<>();
        wrapper.eq("client_id",clientId);
        App app = appMapper.selectOne(wrapper);
        if(app == null){
            throw  new UsernameNotFoundException("客户端不存在");
        }

        BaseClientDetails clientDetails = new
                BaseClientDetails(clientId,
                app.getResourceIds(),
                app.getScopes(),
                app.getGrantTypes(),
                "",
                app.getCallbackUrl());
        clientDetails.setClientSecret(app.getClientSecret());
        return clientDetails;
    }
}
