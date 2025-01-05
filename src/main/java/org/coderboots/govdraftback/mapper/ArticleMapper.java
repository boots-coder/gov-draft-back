package org.coderboots.govdraftback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.coderboots.govdraftback.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

    @Select("SELECT a.*, u.username as submitter_name " +
            "FROM articles a " +
            "LEFT JOIN users u ON a.submitter_id = u.user_id " +
            "WHERE a.status = #{status}")
    IPage<Article> selectArticlesByStatus(Page<Article> page, @Param("status") String status);

    @Select("SELECT a.*, u.username as submitter_name " +
            "FROM articles a " +
            "LEFT JOIN users u ON a.submitter_id = u.user_id " +
            "WHERE a.submitter_id = #{submitterId}")
    List<Article> selectBySubmitter(@Param("submitterId") Integer submitterId);
}
