package org.coderboots.govdraftback.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("article_revisions")
public class ArticleRevision {
    @TableId(value = "revision_id", type = IdType.AUTO)
    private Integer revisionId;
    private Integer articleId;
    private String content;
    private Integer revisorId;
    private LocalDateTime revisedAt;
    private String comments;
}
