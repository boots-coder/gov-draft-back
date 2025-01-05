package org.coderboots.govdraftback.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.coderboots.govdraftback.entity.User;
import org.coderboots.govdraftback.mapper.UserMapper;
import org.coderboots.govdraftback.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}

