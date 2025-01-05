package org.coderboots.govdraftback.controller;

import org.coderboots.govdraftback.common.Result;
import org.coderboots.govdraftback.entity.ReviewComment;
import org.coderboots.govdraftback.service.ReviewCommentService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review-comment")
public class ReviewCommentController {

    @Autowired
    private ReviewCommentService reviewCommentService;

    @GetMapping("/article/{articleId}")
    public Result<Page<ReviewComment>> getByArticleId(
            @PathVariable Integer articleId,
            @RequestParam(defaultValue = "1") Integer current,
            @RequestParam(defaultValue = "10") Integer size) {
        Page<ReviewComment> page = new Page<>(current, size);
        return Result.success(reviewCommentService.page(page));
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody ReviewComment comment) {
        return Result.success(reviewCommentService.save(comment));
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable Integer id) {
        return Result.success(reviewCommentService.removeById(id));
    }
}
