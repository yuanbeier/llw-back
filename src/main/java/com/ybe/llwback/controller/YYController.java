package com.ybe.llwback.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ybe.llwback.dto.ArticleDto;
import com.ybe.llwback.dto.ArticleListInputDto;
import com.ybe.llwback.entity.Article;
import com.ybe.llwback.service.ArticleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: beier
 * @date: 2020/9/21
 * @description: 网站接口
 * @version: 1.0
 */
@RestController
@RequestMapping("/yy/")
public class YYController {
    @Autowired
    private ArticleService articleService;

    @PostMapping("/list")
    public List<ArticleDto> getList(){
        QueryWrapper<Article> queryWrapper = new QueryWrapper();
        List<Article> list = articleService.list(queryWrapper);
        List<ArticleDto> articleDtos = new ArrayList<>();
        list.forEach(x -> {
            ArticleDto dto = new ArticleDto();
            BeanUtils.copyProperties(x,dto);
            dto.setId(x.getId());
            dto.setContent("");
            articleDtos.add(dto);
        });
        return articleDtos;
    }

    @GetMapping("/{id}")
    public ArticleDto getByArticleId(@PathVariable("id") int id){
        Article article = articleService.getById(id);
        ArticleDto dto = new ArticleDto();
        BeanUtils.copyProperties(article,dto);
        return dto;
    }
}
