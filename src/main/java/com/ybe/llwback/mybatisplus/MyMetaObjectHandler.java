package com.ybe.llwback.mybatisplus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.ybe.llwback.entity.security.SecurityUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author:beier
 * @date:2020/3/3
 * @description:自动填充增强类
 * @verison:1.0
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    /**
     * 插入填充
     * @return
     */
    @Override
    public void insertFill(MetaObject metaObject) {

        log.info("insertFill running...");
        /**
         * 自动填充的字段，填充的值，metaObject
         */
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);
        Object principal = SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        if( principal instanceof SecurityUser){
            SecurityUser principal1 = (SecurityUser) principal;
            this.setFieldValByName("createId",principal1.getUserId() ,metaObject);
            this.setFieldValByName("createName",principal1.getUsername(),metaObject);
        }

    }
    /**
     * 更新填充
     * @return
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("updateFill running...");
        this.setFieldValByName("updateTime",new Date(),metaObject);

        Object principal = SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        if( principal instanceof SecurityUser){
            Integer userId = ((SecurityUser) principal).getUserId();
            this.setFieldValByName("updateId",userId ,metaObject);
        }
    }
}
