package org.coderboots.govdraftback.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.coderboots.govdraftback.entity.Article;
import org.coderboots.govdraftback.mapper.ArticleMapper;
import org.coderboots.govdraftback.service.ArticleService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Override
    public boolean submit(Article article) {
        // 设置提交时间
        article.setSubmittedAt(LocalDateTime.now());
        // 设置初始状态为待审核
        article.setStatus("待审核");
        return this.save(article);
    }

    @Override
    public boolean review(Integer articleId, String status, String comments) {
        Article article = this.getById(articleId);
        if (article == null) {
            return false;
        }

        // 更新文章状态
        article.setStatus(status);
        // TODO: 可以在这里添加审核记录等其他逻辑

        return this.updateById(article);
    }

    @Override
    public Page<Article> getUserArticles(Integer userId, Page<Article> page) {
        LambdaQueryWrapper<Article> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Article::getSubmitterId, userId)
                .orderByDesc(Article::getSubmittedAt);

        return this.page(page, wrapper);
    }

    @Override
    public Page<Article> getPendingArticles(Page<Article> page) {
        LambdaQueryWrapper<Article> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Article::getStatus, "PENDING")
                .orderByAsc(Article::getSubmittedAt);

        return this.page(page, wrapper);
    }
}