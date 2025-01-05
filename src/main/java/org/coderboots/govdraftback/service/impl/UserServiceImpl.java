package org.coderboots.govdraftback.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.coderboots.govdraftback.entity.User;
import org.coderboots.govdraftback.mapper.UserMapper;
import org.coderboots.govdraftback.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public User login(String username, String password) {
        // 构建查询条件
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, username);

        // 查询用户
        User user = this.getOne(wrapper);

        // 验证用户和密码
        if (user != null && password.equals(user.getPassword())) {
            // 密码正确，清空密码后返回用户信息
            user.setPassword(null);
            return user;
        }

        // 登录失败返回null
        return null;
    }
}