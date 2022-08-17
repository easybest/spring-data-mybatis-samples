package com.example.demo.service;

import com.example.demo.command.UserCreateCommand;
import com.example.demo.command.UserModifyCommand;
import com.example.demo.dto.UserDTO;
import com.example.demo.query.UserQuery;

import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * .
 *
 * @author Jarvis Song
 */
public interface UserService {

    Page<UserDTO> find(Pageable pageable, UserQuery query, ExampleMatcher matcher);

    UserDTO getById(Long id);

    Long create(UserCreateCommand command);

    void modify(Long id, UserModifyCommand command);

    void patch(Long id, UserModifyCommand command);

    void remove(Long id);
}
