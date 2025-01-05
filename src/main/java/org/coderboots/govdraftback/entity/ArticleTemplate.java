package org.coderboots.govdraftback.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("article_templates")
public class ArticleTemplate {
    @TableId(value = "template_id", type = IdType.AUTO)
    private Integer templateId;
    private String templateName;
    private String content;
    private String category;
    private LocalDateTime createdAt;
    private Integer creatorId;
}
