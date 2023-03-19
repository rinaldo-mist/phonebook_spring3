package com.assessment.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.demo.model.GlobalObject;
import com.assessment.demo.model.UserParam;
import com.assessment.demo.model.Users;
import com.assessment.demo.service.Helper;
import com.assessment.demo.service.UserService;

// import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class UserApiController {

    UserService oUserService;

    public UserApiController(UserService oUserService) {
        this.oUserService = oUserService;
    }

    @GetMapping({"","/"})
    public String viewHomePage() {
        return Helper.USER_HOME_VIEW;
    }

    @GetMapping("/logout")
    public String signOut(){
        return Helper.USER_HOME_VIEW;
    }

    @PostMapping("/logout")
    public String postSignOut(){
        return Helper.USER_HOME_VIEW;
    }
    
    @GetMapping({"/home","/user/home"})
    public List<Users> userHomePage(){
        List<Users> lUsers = new ArrayList<>();
        try {
            lUsers = oUserService.getAllUser();
        } catch (Exception e) {
            lUsers = null;
        }        
        return lUsers;
    }

    @GetMapping("/user/login")
    public String userLoginForm(Model oModel) {
        oModel.addAttribute("user", new Users()); 
        return Helper.USER_LOGIN_VIEW;
    }

    @PostMapping("/user/login")
    public GlobalObject userPostLogin(Users oUser){
        GlobalObject oReturn = new GlobalObject();
        Users rUser = oUserService.getUserDetail(oUser);
        if(rUser == null){
            oReturn.returnObject = Helper.USER_LOGIN_VIEW;
            oReturn.returnMessage = "failed";
            return oReturn;
        } else {
            oReturn.returnObject = rUser;
            oReturn.returnMessage = Helper.USER_DETAIL_VIEW;
            return oReturn;
        }
    }

    @GetMapping("/user/register")
    public String userRegisterForm(Model oModel){
        oModel.addAttribute("user", new Users()); 
        return Helper.USER_REGISTER_VIEW;
    }

    @PostMapping("/user/register")
    public GlobalObject userPostRegister(UserParam oUserParam){
        GlobalObject oReturn = new GlobalObject();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(oUserParam.oUser.getPass());
        oUserParam.oUser.setPass(encodedPassword);
        try {
            if(oUserService.insertUser(oUserParam.oUser, oUserParam.actor)){
                oReturn.returnObject = Helper.USER_LOGIN_VIEW;
                oReturn.returnMessage = "success";
                return oReturn;
            } else {
                oReturn.returnObject = Helper.USER_REGISTER_VIEW;
                oReturn.returnMessage = "failed";
                return oReturn;
            }
        } catch (Exception ex) {
            oReturn.returnObject = Helper.USER_REGISTER_VIEW;
            oReturn.returnMessage = "failed";
            return oReturn;
        }
    }

    @GetMapping("/user/renew")
    public String userRenewForm(Model oModel){
        oModel.addAttribute("user", new Users()); 
        return Helper.USER_REGISTER_VIEW;
    }

    @PutMapping("/user/renew")
    public GlobalObject userRenewUpdate(UserParam oUserParam){
        GlobalObject oReturn = new GlobalObject();
        
        /*
         * login [start]
         */
        Users rUser = oUserService.getUserDetail(oUserParam.oUser);
        /*
         * login [end]
         */
        if(rUser == null){
            oReturn.returnObject = Helper.USER_LOGIN_VIEW;
            oReturn.returnMessage = "failed";
            return oReturn;
        } else {
            /*
             * repopulate new user [start]
             */
            oUserParam.oUser.setId(rUser.getId());
            oUserParam.oUser.setPass(rUser.getPass());
            oUserParam.oUser.setCreated_by(rUser.getCreated_by());
            oUserParam.oUser.setDate_created(rUser.getDate_created());
            oUserParam.oUser.setStatus(rUser.getStatus());
            /*
             * repopulate new user [end]
             */
            try {
                if(oUserService.updateUser(oUserParam.oUser, oUserParam.actor)){
                    oReturn.returnObject = Helper.USER_LOGIN_VIEW;
                    oReturn.returnMessage = "success";
                    return oReturn;
                } else {
                    oReturn.returnObject = Helper.USER_UPDATE_VIEW;
                    oReturn.returnMessage = "failed";
                    return oReturn;
                }
            } catch (Exception ex) {
                oReturn.returnObject = Helper.USER_DETAIL_VIEW;
                oReturn.returnMessage = "failed";
                return oReturn;
            }
        }
    }

    @PutMapping("/user/remove")
    public GlobalObject removeStudent(@RequestParam String userId){
        GlobalObject oReturn = new GlobalObject();
        if(oUserService.removeUser(userId)){
            oReturn.returnObject = Helper.USER_HOME_VIEW;
            oReturn.returnMessage = "success";
            return oReturn;
        } else {
            oReturn.returnObject = Helper.USER_HOME_VIEW;
            oReturn.returnMessage = "failed";
            return oReturn;
        }
    }

    @GetMapping("/user/search")
    public List<Users> userSearchPage(@RequestParam String name){
        List<Users> lUsers = new ArrayList<>();
        try {
            lUsers = oUserService.getAllUserByName(name);
        } catch (Exception e) {
            lUsers = null;
        }        
        return lUsers;
    }
}
