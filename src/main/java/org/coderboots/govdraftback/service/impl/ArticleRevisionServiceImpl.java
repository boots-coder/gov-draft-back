package org.coderboots.govdraftback.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.coderboots.govdraftback.entity.ArticleRevision;
import org.coderboots.govdraftback.mapper.ArticleRevisionMapper;
import org.coderboots.govdraftback.service.ArticleRevisionService;
import org.springframework.stereotype.Service;

@Service
public class ArticleRevisionServiceImpl extends ServiceImpl<ArticleRevisionMapper, ArticleRevision> implements ArticleRevisionService {
}
