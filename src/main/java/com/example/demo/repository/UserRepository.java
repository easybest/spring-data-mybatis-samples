package com.example.demo.repository;

import com.example.demo.domain.User;
import io.easybest.mybatis.repository.MybatisRepository;

/**
 * .
 *
 * @author Jarvis Song
 */
public interface UserRepository extends MybatisRepository<User, Long> {
}
