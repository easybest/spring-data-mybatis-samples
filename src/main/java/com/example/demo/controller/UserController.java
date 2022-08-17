package com.example.demo.controller;

import com.example.demo.aop.ResultExceptionHandler;
import com.example.demo.command.UserCreateCommand;
import com.example.demo.command.UserModifyCommand;
import com.example.demo.dto.UserDTO;
import com.example.demo.query.UserQuery;
import com.example.demo.service.UserService;

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
@RequestMapping("/api/user")
public class UserController {
    private final UserService service;

    public UserController(UserService userService) {
        this.service = userService;
    }

    @GetMapping
    @ResultExceptionHandler
    Result<Page<UserDTO>> list(@PageableDefault(size = 20) Pageable pageable, @Validated UserQuery query) {

        return Result.success(this.service.find(pageable, query, ExampleMatcher.matching()));
    }

    @GetMapping("{id}")
    @ResultExceptionHandler
    Result<UserDTO> fetch(@PathVariable("id") Long id) {

        return Result.success(this.service.getById(id));
    }

    @PostMapping
    Result<Long> create(@Validated @RequestBody UserCreateCommand command) {

        return Result.success(this.service.create(command));
    }

    @PutMapping("{id}")
    @ResultExceptionHandler
    Result<Long> modify(@PathVariable("id") Long id, @Validated @RequestBody UserModifyCommand command) {

        this.service.modify(id, command);
        return Result.success(id);
    }

    @PatchMapping("{id}")
    @ResultExceptionHandler
    Result<Long> patch(@PathVariable("id") Long id, @Validated @RequestBody UserModifyCommand command) {

        this.service.patch(id, command);

        return Result.success(id);
    }

    @DeleteMapping("{id}")
    @ResultExceptionHandler
    Result<Boolean> remove(@PathVariable Long id){

        this.service.remove(id);

        return Result.TRUE;
    }

}
