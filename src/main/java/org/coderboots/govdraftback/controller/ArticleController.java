package org.coderboots.govdraftback.controller;

import org.coderboots.govdraftback.common.Result;
import org.coderboots.govdraftback.entity.Article;
import org.coderboots.govdraftback.service.ArticleService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/page")
    public Result<Page<Article>> page(
            @RequestParam(defaultValue = "1") Integer current,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(required = false) String status) {
        return Result.success(articleService.page(new Page<>(current, size)));
    }

    @GetMapping("/{id}")
    public Result<Article> getById(@PathVariable Integer id) {
        return Result.success(articleService.getById(id));
    }

    @PostMapping("/submit")
    public Result<Boolean> submit(@RequestBody Article article) {
        return Result.success(articleService.submit(article));
    }

    @PutMapping("/review/{id}")
    public Result<Boolean> review(
            @PathVariable Integer id,
            @RequestParam String status,
            @RequestParam(required = false) String comments) {
        return Result.success(articleService.review(id, status, comments));
    }

    @GetMapping("/user/{userId}")
    public Result<Page<Article>> getUserArticles(
            @PathVariable Integer userId,
            @RequestParam(defaultValue = "1") Integer current,
            @RequestParam(defaultValue = "10") Integer size) {
        return Result.success(articleService.getUserArticles(userId, new Page<>(current, size)));
    }

    @GetMapping("/pending")
    public Result<Page<Article>> getPendingArticles(
            @RequestParam(defaultValue = "1") Integer current,
            @RequestParam(defaultValue = "10") Integer size) {
        return Result.success(articleService.getPendingArticles(new Page<>(current, size)));
    }
}
