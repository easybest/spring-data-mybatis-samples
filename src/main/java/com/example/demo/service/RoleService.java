package com.example.demo.service;

import com.example.demo.command.RoleCreateCommand;
import com.example.demo.command.RoleModifyCommand;
import com.example.demo.dto.RoleDTO;
import com.example.demo.query.RoleQuery;

import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * .
 *
 * @author Jarvis Song
 */
public interface RoleService {

    Page<RoleDTO> find(Pageable pageable, RoleQuery query, ExampleMatcher matcher);

    RoleDTO getById(Long id);

    Long create(RoleCreateCommand command);

    void modify(Long id, RoleModifyCommand command);

    void patch(Long id, RoleModifyCommand command);

    void remove(Long id);
}
