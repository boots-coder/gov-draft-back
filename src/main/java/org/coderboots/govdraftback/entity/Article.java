package org.coderboots.govdraftback.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("articles")
public class Article {
    @TableId(value = "article_id", type = IdType.AUTO)
    private Integer articleId;
    private String content;
    private Integer submitterId;
    private LocalDateTime submittedAt;
    private String status;

    @TableField(exist = false)
    private String submitterName;
}
