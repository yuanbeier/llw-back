package com.ybe.llwback.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import sun.plugin2.message.Message;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author: beier
 * @date: 2020/9/19
 * @description: dto
 * @version: 1.0
 */
@Data
public class ArticleDto {
    /**
     * 文件id
     */
    private Integer id;
    @NotEmpty(message = "标题不能为空")
    private String title;
    private String subTitle;
    @NotEmpty(message = "内容不能为空")
    private String content;
    /**
     * 创建人
     */
    private String createName;

    private Date createTime;
}
