package com.example.demo.assembler;

import com.example.demo.domain.User;
import com.example.demo.dto.UserDTO;
import com.example.demo.query.UserQuery;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.InjectionStrategy.CONSTRUCTOR;

/**
 * .
 *
 * @author Jarvis Song
 */
@Mapper(componentModel = "spring", injectionStrategy = CONSTRUCTOR)
public interface UserAssembler {

    @Mapping(target = "version", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "manager", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "age", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "active", ignore = true)
    User fromQuery(UserQuery query);

    UserDTO toDTO(User user);

}
