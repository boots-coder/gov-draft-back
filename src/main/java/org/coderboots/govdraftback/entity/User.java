package org.coderboots.govdraftback.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("users")
public class User {
    @TableId
    private Integer userId;
    private String username;
    private String password;
    private String role;
    private String permissions;
    private LocalDateTime createdAt;
}
