package com.example.demo.service.impl;

import com.example.demo.assembler.UserAssembler;
import com.example.demo.domain.User;
import com.example.demo.dto.UserDTO;
import com.example.demo.query.UserQuery;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * .
 *
 * @author Jarvis Song
 */
@Service
public class UserServiceImpl implements UserService {


    private final UserRepository repository;
    private final UserAssembler assembler;

    public UserServiceImpl(UserRepository repository, UserAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }


    @Override
    public Page<UserDTO> find(Pageable pageable, UserQuery query) {

        Assert.notNull(query, "query must not be null.");

        User probe = this.assembler.fromQuery(query);
        Example<User> example = Example.of(probe, ExampleMatcher.matching());

        Page<User> page = this.repository.findAll(example, pageable);
        return page.map(this.assembler::toDTO);
    }
}
