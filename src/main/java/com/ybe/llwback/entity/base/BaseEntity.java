package com.ybe.llwback.entity.base;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author:beier
 * @date:2020/3/11
 * @description: 实体基类
 * @verison:1.0
 */
@Data
public class BaseEntity<T> implements Serializable {
    @TableId(type= IdType.AUTO)
    public  T id;
    private int createId;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    private int updateId;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @TableLogic
    private int deleted;
}

