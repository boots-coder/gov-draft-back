package org.coderboots.govdraftback.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.coderboots.govdraftback.entity.Department;
import org.coderboots.govdraftback.mapper.DepartmentMapper;
import org.coderboots.govdraftback.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {
}
