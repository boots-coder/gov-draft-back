package org.coderboots.govdraftback.controller;

import org.coderboots.govdraftback.common.Result;
import org.coderboots.govdraftback.entity.Solicitation;
import org.coderboots.govdraftback.service.SolicitationService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/solicitation")
public class SolicitationController {

    @Autowired
    private SolicitationService solicitationService;

    @GetMapping("/page")
    public Result<Page<Solicitation>> page(
            @RequestParam(defaultValue = "1") Integer current,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(required = false) Integer solicitorId,
            @RequestParam(required = false) Integer solicitedPersonId) {
        Page<Solicitation> page = new Page<>(current, size);
        return Result.success(solicitationService.page(page));
    }

    @GetMapping("/{id}")
    public Result<Solicitation> getById(@PathVariable Integer id) {
        return Result.success(solicitationService.getById(id));
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody Solicitation solicitation) {
        return Result.success(solicitationService.save(solicitation));
    }

    @PutMapping
    public Result<Boolean> update(@RequestBody Solicitation solicitation) {
        return Result.success(solicitationService.updateById(solicitation));
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable Integer id) {
        return Result.success(solicitationService.removeById(id));
    }
}
