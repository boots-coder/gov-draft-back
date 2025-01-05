package org.coderboots.govdraftback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.coderboots.govdraftback.entity.Solicitation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SolicitationMapper extends BaseMapper<Solicitation> {

    @Select("SELECT s.*, " +
            "u1.username as solicitor_name, " +
            "u2.username as solicited_person_name " +
            "FROM solicitations s " +
            "LEFT JOIN users u1 ON s.solicitor_id = u1.user_id " +
            "LEFT JOIN users u2 ON s.solicited_person_id = u2.user_id " +
            "WHERE s.deadline >= CURRENT_DATE")
    IPage<Solicitation> selectPendingSolicitations(Page<Solicitation> page);
}
