package org.coderboots.govdraftback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.coderboots.govdraftback.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DepartmentMapper extends BaseMapper<Department> {

    @Select("WITH RECURSIVE dept_tree AS (" +
            "  SELECT * FROM departments WHERE dept_id = #{deptId} " +
            "  UNION ALL " +
            "  SELECT d.* FROM departments d " +
            "  INNER JOIN dept_tree t ON d.parent_dept_id = t.dept_id" +
            ") " +
            "SELECT * FROM dept_tree")
    List<Department> selectDepartmentTree(@Param("deptId") Integer deptId);
}
