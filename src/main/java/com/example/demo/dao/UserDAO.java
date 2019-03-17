package com.example.demo.dao;

import com.example.demo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserDAO extends JpaRepository<User, Long> {
    Page<User> findAll(Pageable pageable);
    List<User> findUserById(int id);


}
