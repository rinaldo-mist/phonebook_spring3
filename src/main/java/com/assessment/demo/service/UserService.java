package com.assessment.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.assessment.demo.model.Users;
import com.assessment.demo.repository.UserRepository;

@Service
public class UserService implements UserImpl{

    UserRepository oUserRepo;
    StatusImpl oStatusImpl;

    @Autowired
    Helper oHelper;
    
    private BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository oUserRepo, StatusImpl oStatusImpl) {
        this.oUserRepo = oUserRepo;
        this.oStatusImpl = oStatusImpl;
    }

    public Users getUserDetail(Users iUser){
        Users rUser = null;
        try {
            rUser = oUserRepo.getUser(iUser.getUsername());
            if(rUser != null){
                if(passwordEncoder.matches(iUser.getPass(), rUser.getPass())){
                    rUser.setPass("*******");
                    return rUser;
                }
            }
        } catch (Exception e) {
            return rUser;
        }
        return rUser;
    }

    public List<Users> getAllUser(){
        return oUserRepo.findAll();
    }

    public List<Users> getAllUserByName(String name){
        return oUserRepo.getUsersByName(name.toLowerCase());
    }

    public Boolean insertUser(Users oUser, String actor){
        try{
            if(oUser.getUsername().isEmpty()){
                return false;
            }
            if(oUser.getPass().isEmpty()){
                return false;
            }
            if(oUser.getPhone().isEmpty()){
                return false;
            }
            if(oUserRepo.getUser(oUser.getUsername()) != null){
                return false;
            }

            oUser.setStatus(oStatusImpl.getStatus(1).getId().toString());
            oUser.setDate_created(oHelper.getCurrentDate());
            oUser.setCreated_by(actor.toString());
            oUser.setDate_updated(oHelper.getCurrentDate());
            oUser.setUpdated_by(actor.toString());
            oUserRepo.save(oUser);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public Boolean removeUser(String oUserUuid){
        try{
            if(oUserUuid.isEmpty()){
                return false;
            }
            Users oUser = oUserRepo.getReferenceById(oUserUuid);
            oUser.setStatus(oStatusImpl.getStatus(2).getId().toString());
            oUser.setDate_updated(oHelper.getCurrentDate());
            /*
             * default to admin UUID = 756207ff-c61b-11ed-89a3-50ebf6e6bf42 , for now
            */
            oUser.setUpdated_by("756207ff-c61b-11ed-89a3-50ebf6e6bf42");
            oUserRepo.save(oUser);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public Boolean updateUser(Users oUser, String actor){
        try{
            if(oUser.getUsername().isEmpty()){
                return false;
            }
            if(oUser.getPass().isEmpty()){
                return false;
            }
            if(oUser.getPhone().isEmpty()){
                return false;
            }
            oUser.setDate_updated(oHelper.getCurrentDate());
            oUser.setUpdated_by(actor.toString());
            oUserRepo.save(oUser);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
}
