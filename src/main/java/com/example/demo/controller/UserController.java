package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.query.UserQuery;
import com.example.demo.service.UserService;

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
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Result<Page<UserDTO>> list(@PageableDefault(size = 20) Pageable pageable, @Validated UserQuery query) {

        return Result.success(this.userService.find(pageable, query));
    }


}
