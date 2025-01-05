package org.coderboots.govdraftback.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.time.LocalDate;

@Data
@TableName("journals")
public class Journal {
    @TableId(value = "journal_id", type = IdType.AUTO)
    private Integer journalId;
    private String title;
    private LocalDate publishDate;
    private String content;
}
