package com.example.demo.dto;

import java.util.Set;

import com.example.demo.domain.Address;
import lombok.Data;

/**
 * .
 *
 * @author Jarvis Song
 */
@Data
public class UserDTO {

    private Long id;

    private String emailAddress;

    private String firstname;

    private String lastname;

    private int age;

    private boolean active;

    private Address address;

    private UserDTO manager;

    private Set<RoleDTO> roles;
}
