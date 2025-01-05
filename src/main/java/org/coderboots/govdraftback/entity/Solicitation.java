package org.coderboots.govdraftback.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import java.time.LocalDateTime;
import java.time.LocalDate;

@Data
@TableName("solicitations")
public class Solicitation {
    @TableId(value = "solicitation_id", type = IdType.AUTO)
    private Integer solicitationId;
    private String topic;
    private LocalDateTime solicitedAt;
    private Integer solicitorId;
    private Integer solicitedPersonId;
    private LocalDate deadline;

    @TableField(exist = false)
    private String solicitorName;
    @TableField(exist = false)
    private String solicitedPersonName;
}
