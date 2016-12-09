/*
 *
 *   Copyright 2016 the original author or authors.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package org.springframework.data.mybatis.samples.domains;

import org.springframework.data.mybatis.annotations.Column;
import org.springframework.data.mybatis.annotations.Entity;
import org.springframework.data.mybatis.annotations.JdbcType;
import org.springframework.data.mybatis.annotations.TypeHandler;
import org.springframework.data.mybatis.domains.LongId;
import org.springframework.data.mybatis.samples.enums.Role;
import org.springframework.data.mybatis.samples.handlers.RoleListTypeHandler;

import java.util.List;

import static org.apache.ibatis.type.JdbcType.VARCHAR;

/**
 * @author Jarvis Song
 */
@Entity
public class Manager extends LongId {

    private String     login;
    @JdbcType(VARCHAR)
    @Column(name = "roles")
    @TypeHandler(RoleListTypeHandler.class)
    private List<Role> roleList;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "login='" + login + '\'' +
                ", roleList=" + roleList +
                '}';
    }
}
