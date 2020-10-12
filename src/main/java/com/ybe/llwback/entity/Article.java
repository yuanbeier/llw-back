package com.ybe.llwback.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.ybe.llwback.entity.base.BaseEntity;
import lombok.Data;
import org.apache.ibatis.type.BlobTypeHandler;

/**
 * @author: beier
 * @date: 2020/9/18
 * @description: 文章类容
 * @version: 1.0
 */
@Data
public class Article extends BaseEntity<Integer> {
    private String title;
    private String subTitle;
    @TableField(typeHandler = BlobTypeHandler.class)
    private byte[] content;
    private String createName;
    private int orderId;
}
