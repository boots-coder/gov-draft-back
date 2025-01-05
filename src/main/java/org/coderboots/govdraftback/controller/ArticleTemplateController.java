package org.coderboots.govdraftback.controller;

import org.coderboots.govdraftback.common.Result;
import org.coderboots.govdraftback.entity.ArticleTemplate;
import org.coderboots.govdraftback.service.ArticleTemplateService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/template")
public class ArticleTemplateController {

    @Autowired
    private ArticleTemplateService templateService;

    @GetMapping("/page")
    public Result<Page<ArticleTemplate>> page(
            @RequestParam(defaultValue = "1") Integer current,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(required = false) String category) {
        Page<ArticleTemplate> page = new Page<>(current, size);
        return Result.success(templateService.page(page));
    }

    @GetMapping("/{id}")
    public Result<ArticleTemplate> getById(@PathVariable Integer id) {
        return Result.success(templateService.getById(id));
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody ArticleTemplate template) {
        return Result.success(templateService.save(template));
    }

    @PutMapping
    public Result<Boolean> update(@RequestBody ArticleTemplate template) {
        return Result.success(templateService.updateById(template));
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable Integer id) {
        return Result.success(templateService.removeById(id));
    }
}
