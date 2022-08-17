package com.example.demo.command;

import com.example.demo.domain.Address;
import lombok.Data;

/**
 * .
 *
 * @author Jarvis Song
 */
@Data
public class UserCreateCommand {


    private String emailAddress;

    private String firstname;

    private String lastname;

    private int age;

    private boolean active;

    private Address address;

    private Long managerId;

}
