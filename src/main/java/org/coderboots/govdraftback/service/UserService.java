package org.coderboots.govdraftback.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.coderboots.govdraftback.entity.User;

public interface UserService extends IService<User> {
    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return 登录成功返回用户信息，失败返回null
     */
    User login(String username, String password);
}
