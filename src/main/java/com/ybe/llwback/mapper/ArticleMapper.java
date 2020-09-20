package com.ybe.llwback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ybe.llwback.entity.Article;
import org.springframework.stereotype.Repository;

/**
 * @author: beier
 * @date: 2020/9/19
 * @description: 文章dao
 * @version: 1.0
 */
@Repository
public interface ArticleMapper extends BaseMapper<Article> {
}
