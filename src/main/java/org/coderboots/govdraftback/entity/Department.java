package org.coderboots.govdraftback.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("departments")
public class Department {
    @TableId(value = "dept_id", type = IdType.AUTO)
    private Integer deptId;
    private String deptName;
    private String description;
    private Integer parentDeptId;
    private Integer leaderId;
}
