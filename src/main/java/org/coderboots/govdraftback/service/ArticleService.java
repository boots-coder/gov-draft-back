package org.coderboots.govdraftback.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.coderboots.govdraftback.entity.Article;

public interface ArticleService extends IService<Article> {
    /**
     * 提交文章
     */
    boolean submit(Article article);

    /**
     * 审核文章
     */
    boolean review(Integer articleId, String status, String comments);

    /**
     * 获取用户的文章列表
     */
    Page<Article> getUserArticles(Integer userId, Page<Article> page);

    /**
     * 获取待审核的文章
     */
    Page<Article> getPendingArticles(Page<Article> page);
}