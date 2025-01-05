package org.coderboots.govdraftback.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.coderboots.govdraftback.entity.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}

