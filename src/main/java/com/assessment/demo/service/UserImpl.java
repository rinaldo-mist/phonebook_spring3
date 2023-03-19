package com.assessment.demo.service;

import java.util.List;

import com.assessment.demo.model.Users;

public interface UserImpl {
    Users getUserDetail(Users oUser);
    List<Users> getAllUser();
    Boolean insertUser(Users oUser, String actor);
    Boolean removeUser(String uuidUser);
    Boolean updateUser(Users oUser, String actor);
}
