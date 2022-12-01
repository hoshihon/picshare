package com.github.hoshihon.picshare.controller;

import com.github.hoshihon.picshare.controller.support.ApiResult;
import com.github.hoshihon.picshare.dto.UserProfile;
import com.github.hoshihon.picshare.dto.UserProperties;
import com.github.hoshihon.picshare.model.User;
import com.github.hoshihon.picshare.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    public static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/register")
    public ApiResult register(User userForm) {
        if (userService.register(userForm)) {
            return ApiResult.success();
        } else {
            return ApiResult.failed("register error");
        }
    }

    @GetMapping("/login")
    public ApiResult login(UserProperties userForm) {


        if (userService.login(userForm)) {
            return ApiResult.success();
        } else {
            return ApiResult.failed("login error");
        }
    }

    @GetMapping("/{id}")
    public ApiResult<UserProfile> userprofile(@PathVariable("id") long id) {
        UserProfile userProfile = userService.userProfile(id);
        return ApiResult.success(userProfile);
    }

    @PostMapping("/{id}/edit")
    public ApiResult editUser(UserProperties userProperties) {
        return null;
    }

    @GetMapping("/search/{id}")
    public ApiResult searchUser(@PathVariable("id") int id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ApiResult deleteUser(@PathVariable("id") int id) {
        return null;
    }

    @GetMapping("/{id}/like")
    public ApiResult userLikeQuery(@PathVariable("id") int id) {
        return null;
    }

    @GetMapping("/{id}/star")
    public ApiResult userStarQuery(@PathVariable("id") int id) {
        return null;
    }


}
