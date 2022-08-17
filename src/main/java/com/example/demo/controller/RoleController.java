package com.example.demo.controller;

import com.example.demo.dto.RoleDTO;
import com.example.demo.query.RoleQuery;
import com.example.demo.service.RoleService;

import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
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
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public Result<Page<RoleDTO>> list(@PageableDefault(size = 20) Pageable pageable, @Validated RoleQuery query) {

        return Result.success(this.roleService.find(pageable, query, ExampleMatcher.matching()));
    }


}
