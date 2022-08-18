package com.example.demo.service.impl;

import com.example.demo.assembler.RoleAssembler;
import com.example.demo.command.RoleCreateCommand;
import com.example.demo.command.RoleModifyCommand;
import com.example.demo.domain.Role;
import com.example.demo.dto.RoleDTO;
import com.example.demo.query.RoleQuery;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.RoleService;

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
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;
    private final RoleAssembler assembler;


    public RoleServiceImpl(RoleRepository repository, RoleAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<RoleDTO> find(Pageable pageable, RoleQuery query, ExampleMatcher matcher) {


        Assert.notNull(query, "query must not be null.");

        Role probe = this.assembler.fromQuery(query);
        Example<Role> example = Example.of(probe, matcher);

        Page<Role> page = this.repository.findAll(example, pageable);
        return page.map(this.assembler::toDTO);
    }


    @Override
    @Transactional(readOnly = true)
    public RoleDTO getById(Long id) {

        Assert.notNull(id, "id must not be null.");

        Role role = this.repository.getById(id);
        if (null == role) {
            return null;
        }

        return this.assembler.toDTO(role);
    }

    @Override
    @Transactional
    public Long create(RoleCreateCommand command) {

        Role role = this.assembler.fromCreateCommand(command);
        Role inserted = this.repository.insert(role);
        return inserted.getId();
    }

    @Override
    @Transactional
    public void modify(Long id, RoleModifyCommand command) {

        Role role = this.assembler.fromModifyCommand(command);
        this.repository.update(id, role);
    }

    @Override
    @Transactional
    public void patch(Long id, RoleModifyCommand command) {

        Role role = this.assembler.fromModifyCommand(command);
        this.repository.updateSelective(id, role);
    }

    @Override
    @Transactional
    public void remove(Long id) {

        this.repository.deleteById(id);
    }
}
