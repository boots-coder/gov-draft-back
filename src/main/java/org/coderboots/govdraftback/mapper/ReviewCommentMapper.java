package org.coderboots.govdraftback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.coderboots.govdraftback.entity.ReviewComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReviewCommentMapper extends BaseMapper<ReviewComment> {

    @Select("SELECT rc.*, u.username as reviewer_name " +
            "FROM review_comments rc " +
            "LEFT JOIN users u ON rc.reviewer_id = u.user_id " +
            "WHERE rc.article_id = #{articleId} " +
            "ORDER BY rc.commented_at DESC")
    List<ReviewComment> selectByArticleId(@Param("articleId") Integer articleId);
}
