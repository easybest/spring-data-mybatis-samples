package com.example.demo.service.impl;

import com.example.demo.assembler.UserAssembler;
import com.example.demo.command.UserCreateCommand;
import com.example.demo.command.UserModifyCommand;
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
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional(readOnly = true)
    public Page<UserDTO> find(Pageable pageable, UserQuery query, ExampleMatcher matcher) {

        Assert.notNull(query, "query must not be null.");

        User probe = this.assembler.fromQuery(query);
        Example<User> example = Example.of(probe, matcher);

        Page<User> page = this.repository.findAll(example, pageable);
        return page.map(this.assembler::toDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDTO getById(Long id) {

        Assert.notNull(id, "id must not be null.");

        User user = this.repository.getById(id);
        if (null == user) {
            return null;
        }

        return this.assembler.toDTO(user);
    }

    @Override
    @Transactional
    public Long create(UserCreateCommand command) {

        User user = this.assembler.fromCreateCommand(command);
        User inserted = this.repository.insert(user);
        return inserted.getId();
    }

    @Override
    @Transactional
    public void modify(Long id, UserModifyCommand command) {

        User user = this.assembler.fromModifyCommand(command);
        this.repository.update(id, user);
    }

    @Override
    @Transactional
    public void patch(Long id, UserModifyCommand command) {

        User user = this.assembler.fromModifyCommand(command);
        this.repository.updateSelective(id, user);
    }

    @Override
    @Transactional
    public void remove(Long id) {

        this.repository.deleteById(id);
    }
}
