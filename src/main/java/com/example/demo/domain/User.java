package com.example.demo.domain;

import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import io.easybest.mybatis.annotation.DatabaseDefault;
import io.easybest.mybatis.domain.LongId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * .
 *
 * @author Jarvis Song
 */
@Entity
@Table(name = "USER")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class User extends LongId {

    private String emailAddress;

    private String firstname;

    private String lastname;

    private int age;

    private boolean active;

    @Embedded
    private Address address;

    @ManyToOne
    private User manager;

    @ManyToMany
    @JoinTable(name = "USER_ROLE")
    private Set<Role> roles;

    @Version
    @DatabaseDefault
    private Integer version;

    public User() {
    }

    public User(Long id) {

        super(id);
    }
}
