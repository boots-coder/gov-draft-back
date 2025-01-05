package org.coderboots.govdraftback.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("review_comments")
public class ReviewComment {
    @TableId(value = "comment_id", type = IdType.AUTO)
    private Integer commentId;
    private Integer articleId;
    private Integer reviewerId;
    private String content;
    private LocalDateTime commentedAt;
    private String status;
}
