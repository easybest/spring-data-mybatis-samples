package com.example.demo.controller;

import com.example.demo.aop.ResultExceptionHandler;
import com.example.demo.command.RoleCreateCommand;
import com.example.demo.command.RoleModifyCommand;
import com.example.demo.dto.RoleDTO;
import com.example.demo.query.RoleQuery;
import com.example.demo.service.RoleService;

import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * .
 *
 * @author Jarvis Song
 */
@RestController
@RequestMapping("/api/role")
public class RoleController {
    private final RoleService service;

    public RoleController(RoleService roleService) {
        this.service = roleService;
    }

    @GetMapping
    public Result<Page<RoleDTO>> list(@PageableDefault(size = 20) Pageable pageable, @Validated RoleQuery query) {

        return Result.success(this.service.find(pageable, query, ExampleMatcher.matching()));
    }

    @GetMapping("{id}")
    @ResultExceptionHandler
    Result<RoleDTO> fetch(@PathVariable("id") Long id) {

        return Result.success(this.service.getById(id));
    }

    @PostMapping
    Result<Long> create(@Validated @RequestBody RoleCreateCommand command) {

        return Result.success(this.service.create(command));
    }

    @PutMapping("{id}")
    @ResultExceptionHandler
    Result<Long> modify(@PathVariable("id") Long id, @Validated @RequestBody RoleModifyCommand command) {

        this.service.modify(id, command);
        return Result.success(id);
    }

    @PatchMapping("{id}")
    @ResultExceptionHandler
    Result<Long> patch(@PathVariable("id") Long id, @Validated @RequestBody RoleModifyCommand command) {

        this.service.patch(id, command);

        return Result.success(id);
    }

    @DeleteMapping("{id}")
    @ResultExceptionHandler
    Result<Boolean> remove(@PathVariable Long id) {

        this.service.remove(id);

        return Result.TRUE;
    }
}
