package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

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
@Table(name = "ROLE")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Role extends LongId {

    private String name;

}
