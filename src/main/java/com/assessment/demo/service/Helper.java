package com.assessment.demo.service;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class Helper {
    public static String USER_HOME_VIEW = "/home";
    public static String USER_DETAIL_VIEW = "user/detail";
    public static String USER_LOGIN_VIEW = "user/login";
    public static String USER_REGISTER_VIEW = "user/register";
    public static String USER_REMOVE_VIEW = "user/remove";
    public static String USER_UPDATE_VIEW = "user/update";
    public static String USER_LOGOUT_VIEW = "user/logout";

    public Timestamp getCurrentDate(){
        Timestamp oTimestamp = new Timestamp(new Date().getTime());
        return oTimestamp;
    }
}
