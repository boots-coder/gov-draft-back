package org.coderboots.govdraftback.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("workflow_definitions")
public class WorkflowDefinition {
    @TableId(value = "workflow_id", type = IdType.AUTO)
    private Integer workflowId;
    private String workflowName;
    private String description;
    private String steps;
    private LocalDateTime createdAt;
    private Integer creatorId;
}
