package org.coderboots.govdraftback.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.coderboots.govdraftback.entity.ArticleTemplate;
import org.coderboots.govdraftback.mapper.ArticleTemplateMapper;
import org.coderboots.govdraftback.service.ArticleTemplateService;
import org.springframework.stereotype.Service;

@Service
public class ArticleTemplateServiceImpl extends ServiceImpl<ArticleTemplateMapper, ArticleTemplate> implements ArticleTemplateService {
}
