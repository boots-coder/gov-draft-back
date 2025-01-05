package org.coderboots.govdraftback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.coderboots.govdraftback.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT * FROM users WHERE username = #{username}")
    User findByUsername(@Param("username") String username);

    @Select("SELECT u.* FROM users u " +
            "INNER JOIN user_departments ud ON u.user_id = ud.user_id " +
            "WHERE ud.dept_id = #{deptId}")
    List<User> findByDepartment(@Param("deptId") Integer deptId);

    @Select("SELECT u.* FROM users u " +
            "INNER JOIN user_departments ud ON u.user_id = ud.user_id " +
            "WHERE ud.dept_id = #{deptId} AND ud.position = #{position}")
    List<User> findByDepartmentAndPosition(@Param("deptId") Integer deptId, @Param("position") String position);
}
