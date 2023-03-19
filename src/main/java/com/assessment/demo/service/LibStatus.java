package com.assessment.demo.service;

public enum LibStatus {
    Active(1), Inactive(2);

    private int val;

    LibStatus(int val) {
        this.val = val;
    }

    public int getStatus(){
        return val;
    }
}