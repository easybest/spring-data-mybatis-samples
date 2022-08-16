package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.dto.UserDTO;
import com.example.demo.query.UserQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * .
 *
 * @author Jarvis Song
 */
public interface UserService {

    Page<UserDTO> find(Pageable pageable, UserQuery query);

}
