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

package org.springframework.data.mybatis.samples.enums;

/**
 * @author Jarvis Song
 */
public enum Role {
    ROLE_USER(1),
    ROLE_MANAGER(2),
    ROLE_ADMIN(3),
    ROLE_CLIENT(4),
    ROLE_TRUSTED_CLIENT(5);

    private int value;

    Role(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    /**
     * From int to Role
     *
     * @param value
     * @return
     */
    public static Role getRoleFromValue(int value) {
        Role result = null;
        for (Role s : Role.values()) {
            if (s.getValue() == value) {
                result = s;
            }
        }
        if (result == null) {
            throw new IllegalArgumentException("No exist the Role with that value");
        }
        return result;
    }
}
