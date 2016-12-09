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

package org.springframework.data.mybatis.samples;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mybatis.samples.domains.Manager;
import org.springframework.data.mybatis.samples.enums.Role;
import org.springframework.data.mybatis.samples.repositories.ManagerRepository;

import java.util.Arrays;

@SpringBootApplication
public class SpringDataMybatisSamplesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataMybatisSamplesApplication.class, args);
    }

    @Bean
    public CommandLineRunner dummyCLR(ManagerRepository managerRepository) {
        return args -> {
            Manager apple = new Manager();
            apple.setLogin("apple");
            apple.setRoleList(Arrays.asList(Role.ROLE_ADMIN, Role.ROLE_CLIENT));
            managerRepository.save(apple);

            Manager tom = managerRepository.findByLogin("apple");
            System.out.println(tom);
        };
    }

}
