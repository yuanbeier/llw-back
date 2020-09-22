package com.ybe.llwback.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ybe.llwback.dto.ArticleDto;
import com.ybe.llwback.dto.ArticleListInputDto;
import com.ybe.llwback.entity.Article;
import com.ybe.llwback.service.ArticleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: beier
 * @date: 2020/9/19
 * @description: 文章Controller
 * @version: 1.0
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("add")
    public void save(@RequestBody @Validated ArticleDto dto, BindingResult bindingResult) throws UnsupportedEncodingException {
        if(bindingResult.hasErrors()){
            return ;
        }
        Article article = new Article();
        BeanUtils.copyProperties(dto,article);
        article.setContent(dto.getContent().getBytes("UTF-8"));
        articleService.save(article);
    }

    @PutMapping
    public void update(@RequestBody @Valid ArticleDto dto) throws UnsupportedEncodingException {
        Article article = new Article();
        BeanUtils.copyProperties(dto,article);
        article.setContent(dto.getContent().getBytes("UTF-8"));
        articleService.updateById(article);
    }

    @DeleteMapping
    public void delete(@RequestParam ("id") int  id){
        articleService.removeById(id);
    }

    @PostMapping("/list")
    public List<ArticleDto> getList(@RequestBody ArticleListInputDto articleDto){
        QueryWrapper<Article> queryWrapper = new QueryWrapper();
        if(articleDto != null){
            if(StrUtil.isNotBlank(articleDto.getTitle())){
                queryWrapper.lambda().like(Article::getTitle,articleDto.getTitle());
            }
        }

        List<Article> list = articleService.list(queryWrapper);
        List<ArticleDto> articleDtos = new ArrayList<>();
        list.forEach(x -> {
            ArticleDto dto = new ArticleDto();
            BeanUtils.copyProperties(x,dto);
            dto.setId(x.getId());
            dto.setContent(new String(x.getContent()));
            articleDtos.add(dto);
        });
        return articleDtos;
    }
}

