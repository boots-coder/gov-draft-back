package org.coderboots.govdraftback.controller;

import org.coderboots.govdraftback.common.Result;
import org.coderboots.govdraftback.entity.Department;
import org.coderboots.govdraftback.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/list")
    public Result<List<Department>> list() {
        return Result.success(departmentService.list());
    }

    @GetMapping("/{id}")
    public Result<Department> getById(@PathVariable Integer id) {
        return Result.success(departmentService.getById(id));
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody Department department) {
        return Result.success(departmentService.save(department));
    }

    @PutMapping
    public Result<Boolean> update(@RequestBody Department department) {
        return Result.success(departmentService.updateById(department));
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable Integer id) {
        return Result.success(departmentService.removeById(id));
    }
}
