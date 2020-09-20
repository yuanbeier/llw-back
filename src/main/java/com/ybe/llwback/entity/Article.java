package com.ybe.llwback.entity;

import com.ybe.llwback.entity.base.BaseEntity;
import lombok.Data;

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
    private String content;
    private String createName;
}
