package com.assessment.demo.model;

public class UserParam {
    public Users oUser;
    public String actor;
    public Users getoUser() {
        return oUser;
    }
    public void setoUser(Users oUser) {
        this.oUser = oUser;
    }
    public String getActor() {
        return actor;
    }
    public void setActor(String actor) {
        this.actor = actor;
    }
}
