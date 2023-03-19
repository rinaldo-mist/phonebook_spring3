package com.assessment.demo.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PassEncoder {

    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public static String encode(String incomingPass) {
        return passwordEncoder.encode(incomingPass);
    }

    public static boolean matches(String incomingPass, String encodedPass) {
        return passwordEncoder.matches(incomingPass, encodedPass);
    }
}
