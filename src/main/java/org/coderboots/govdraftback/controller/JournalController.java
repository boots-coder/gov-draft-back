package org.coderboots.govdraftback.controller;

import org.coderboots.govdraftback.common.Result;
import org.coderboots.govdraftback.entity.Journal;
import org.coderboots.govdraftback.service.JournalService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@RestController
@RequestMapping("/journal")
public class JournalController {

    @Autowired
    private JournalService journalService;

    @GetMapping("/page")
    public Result<Page<Journal>> page(
            @RequestParam(defaultValue = "1") Integer current,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(required = false) LocalDate startDate,
            @RequestParam(required = false) LocalDate endDate) {
        Page<Journal> page = new Page<>(current, size);
        return Result.success(journalService.page(page));
    }

    @GetMapping("/{id}")
    public Result<Journal> getById(@PathVariable Integer id) {
        return Result.success(journalService.getById(id));
    }

    @PostMapping
    public Result<Boolean> save(@RequestBody Journal journal) {
        return Result.success(journalService.save(journal));
    }

    @PutMapping
    public Result<Boolean> update(@RequestBody Journal journal) {
        return Result.success(journalService.updateById(journal));
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> delete(@PathVariable Integer id) {
        return Result.success(journalService.removeById(id));
    }
}
