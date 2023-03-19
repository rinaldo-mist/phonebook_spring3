package com.assessment.demo.repository;
import com.assessment.demo.model.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<Users, String> {
    @Query(value = " SELECT * FROM users WHERE username = ?1 LIMIT 1 ", nativeQuery = true)
    public Users getUser(String username);

    @Query(value = " SELECT * FROM users ", nativeQuery = true)
    public List<Users> getUsers(int status);

    @Query(value = " SELECT * FROM users WHERE LOWER(name) LIKE (%?1%)", nativeQuery = true)
    public List<Users> getUsersByName(String name);
}