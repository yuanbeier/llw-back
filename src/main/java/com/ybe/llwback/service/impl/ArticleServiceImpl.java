package com.ybe.llwback.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ybe.llwback.entity.Article;
import com.ybe.llwback.mapper.ArticleMapper;
import com.ybe.llwback.service.ArticleService;
import org.springframework.stereotype.Service;

/**
 * @author: beier
 * @date: 2020/9/19
 * @description: 文章实现类
 * @version: 1.0
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
}
