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

package org.springframework.data.mybatis.samples.handlers;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.springframework.data.mybatis.samples.enums.Role;
import org.springframework.util.StringUtils;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Jarvis Song
 */
@MappedJdbcTypes(JdbcType.VARCHAR)
@MappedTypes(List.class)
public class RoleListTypeHandler extends BaseTypeHandler<List<Role>> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<Role> roleList, JdbcType jdbcType) throws SQLException {
        Set<Integer> roles = new HashSet<>();
        for (Role role : roleList) {
            roles.add(role.getValue());
        }
        ps.setString(i, StringUtils.collectionToDelimitedString(roles, ","));
    }

    @Override
    public List<Role> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String roles = rs.getString(columnName);
        return getRoleListFromResultString(roles);
    }

    @Override
    public List<Role> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return getRoleListFromResultString(rs.getString(columnIndex));
    }

    @Override
    public List<Role> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return getRoleListFromResultString(cs.getString(columnIndex));
    }

    private List<Role> getRoleListFromResultString(String result) {
        ArrayList<Role> roleList = new ArrayList();
        for (String role : result.split(",")) {
            roleList.add(Role.getRoleFromValue(Integer.parseInt(role)));
        }

        return roleList;
    }
}
