package org.coderboots.govdraftback.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.coderboots.govdraftback.entity.UserDepartment;
import org.coderboots.govdraftback.mapper.UserDepartmentMapper;
import org.coderboots.govdraftback.service.UserDepartmentService;
import org.springframework.stereotype.Service;

@Service
public class UserDepartmentServiceImpl extends ServiceImpl<UserDepartmentMapper, UserDepartment> implements UserDepartmentService {
}
