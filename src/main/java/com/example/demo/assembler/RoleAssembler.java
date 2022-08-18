package com.example.demo.assembler;

import com.example.demo.command.RoleCreateCommand;
import com.example.demo.command.RoleModifyCommand;
import com.example.demo.domain.Role;
import com.example.demo.dto.RoleDTO;
import com.example.demo.query.RoleQuery;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import static org.mapstruct.InjectionStrategy.CONSTRUCTOR;

/**
 * .
 *
 * @author Jarvis Song
 */
@Mapper(componentModel = "spring", injectionStrategy = CONSTRUCTOR)
public interface RoleAssembler {

    @Named("toDTO")
    RoleDTO toDTO(Role role);

    @Mapping(target = "id", ignore = true)
    @Named("fromQuery")
    Role fromQuery(RoleQuery query);


    @Mapping(target = "id", ignore = true)
    Role fromCreateCommand(RoleCreateCommand command);


    @Mapping(target = "id", ignore = true)
    Role fromModifyCommand(RoleModifyCommand command);

}
