package com.github.hoshihon.picshare.controller;

import com.github.hoshihon.picshare.controller.support.ApiResult;
import com.github.hoshihon.picshare.dto.UserProfile;
import com.github.hoshihon.picshare.dto.UserProperties;
import com.github.hoshihon.picshare.model.User;
import com.github.hoshihon.picshare.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Value(("${web.upload-path}"))
    private String uploadPath;

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

    @PostMapping("/update/{id}")
    public ApiResult updateUser(UserProperties userProperties) {

        if (userService.updateUser(userProperties) == 1) {
            return ApiResult.success("update success");
        }
        return ApiResult.failed("update error ");
    }

    @GetMapping("/search/{id}")
    public ApiResult<UserProperties> searchUser(@PathVariable("id") long id) {

        return null;
    }

    @PostMapping("/icon/{id}")
    public ApiResult updateIcon(@PathVariable("id")long id, MultipartFile file) throws IOException {
        //判断是否存在文件夹
        File imgDir = new File(uploadPath + "/icon/");
        if (!imgDir.exists()) {
            imgDir.mkdir();
        }

        FileChannel channel = FileChannel.open("");

        channel.transferTo()

        UserProperties user = userService.findById(id);

        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            UUID uuid = UUID.randomUUID();
            //生成新的文件名称
            String fileNewName = uuid.toString() + suffixName;
            file.transferTo(new File(uploadPath + "/icon/" + fileNewName));
            user.setIcon(uploadPath + "/icon/" + fileNewName);

            if (userService.updateUser(user) == 1) {
                return ApiResult.success("icon updated");
            } else {
                return ApiResult.failed("icon update fail");
            }

        } else {
            return ApiResult.failed("no such image");
        }

    }


    @DeleteMapping("/{id}")
    public ApiResult deleteUser(@PathVariable("id") int id) {
        if (userService.deleteUser(id) == 1) {
            return ApiResult.success("delete success");
        }
        return ApiResult.failed("delete false");
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
