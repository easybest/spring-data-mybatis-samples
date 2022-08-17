package com.example.demo.assembler;

import com.example.demo.command.UserCreateCommand;
import com.example.demo.command.UserModifyCommand;
import com.example.demo.domain.User;
import com.example.demo.dto.UserDTO;
import com.example.demo.query.UserQuery;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import static org.mapstruct.InjectionStrategy.CONSTRUCTOR;

/**
 * .
 *
 * @author Jarvis Song
 */
@Mapper(componentModel = "spring", injectionStrategy = CONSTRUCTOR, uses = {RoleAssembler.class})
public interface UserAssembler {

    @Mapping(target = "version", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "manager", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "age", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Named("fromQuery")
    User fromQuery(UserQuery query);

    @Named("toDTO")
    @Mapping(source = "manager", target = "manager", qualifiedByName = "toDTO")
    @Mapping(source = "roles", target = "roles", qualifiedByName = "toDTO")
    UserDTO toDTO(User user);

    @Mapping(target = "version", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "manager", ignore = true)
    @Mapping(target = "id", ignore = true)
    User fromCreateCommand(UserCreateCommand command);

    @Mapping(target = "version", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "manager", ignore = true)
    @Mapping(target = "id", ignore = true)
    User fromModifyCommand(UserModifyCommand command);
}
