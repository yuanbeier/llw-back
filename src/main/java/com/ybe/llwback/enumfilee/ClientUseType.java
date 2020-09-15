package com.ybe.llwback.enumfilee;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * @author:beier
 * @date:2020/3/11
 * @description:client使用类型
 * @verison:1.0
 */

public enum ClientUseType {
    USER("用户",1),
    SYSTEM("系统",2);

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @EnumValue
    private int value ;
    private String name;

    private ClientUseType(String name, int value){
        this.value = value;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
