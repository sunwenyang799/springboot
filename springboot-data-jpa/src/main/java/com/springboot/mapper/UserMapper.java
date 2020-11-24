package com.springboot.mapper;

import com.springboot.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @ Author     ：swy
 * @ Date       ：Created in 20:31 2020/11/24
 * @ Description：
 */
public interface UserMapper extends JpaRepository<User,Integer> {

    Page<User> findAllByEmail(String email);
}
