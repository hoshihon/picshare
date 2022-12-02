package com.github.hoshihon.picshare.service;


import com.github.hoshihon.picshare.VO.UserVO;
import com.github.hoshihon.picshare.dto.UserProfile;
import com.github.hoshihon.picshare.dto.UserProperties;
import com.github.hoshihon.picshare.model.User;

public interface UserService {


    boolean register(User user);

    boolean login(UserProperties userProperties);


    UserProfile userProfile(long id);

    int updateUser(UserProperties userProperties);

    UserProperties findById(long id);


    UserProperties searchUser(int id);

    int deleteUser(int id);

    UserVO likeList(int id);

    UserVO starList(int id);


}
