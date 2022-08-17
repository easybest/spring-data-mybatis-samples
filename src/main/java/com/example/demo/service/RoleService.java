package com.example.demo.service;

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

}
