package org.coderboots.govdraftback.controller;

import org.coderboots.govdraftback.common.Result;
import org.coderboots.govdraftback.entity.User;
import org.coderboots.govdraftback.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/page")
    public Result<Page<User>> page(
            @RequestParam(defaultValue = "1") Integer current,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(required = false) String username) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(username != null, User::getUsername, username);
        return Result.success(userService.page(new Page<>(current, size), wrapper));
    }

    @GetMapping("/{id}")
    public Result<User> getById(@PathVariable Integer id) {
        return Result.success(userService.getById(id));
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody User user) {
        return Result.success(userService.save(user));
    }

    @PutMapping
    public Result<Boolean> update(@RequestBody User user) {
        return Result.success(userService.updateById(user));
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable Integer id) {
        return Result.success(userService.removeById(id));
    }

    @PostMapping("/login")
    public Result<User> login(@RequestParam String username, @RequestParam String password) {
        User user = userService.login(username, password);
        return user != null ? Result.success(user) : Result.error("用户名或密码错误");
    }

//    @PostMapping("/change-password")
//    public Result<Boolean> changePassword(
//            @RequestParam Integer userId,
//            @RequestParam String oldPassword,
//            @RequestParam String newPassword) {
//        return Result.success(userService.changePassword(userId, oldPassword, newPassword));
//    }
}
