package com.github.hoshihon.picshare.service;


import com.github.hoshihon.picshare.VO.UserVO;
import com.github.hoshihon.picshare.dto.UserProperties;

import java.util.List;

public interface UserService {


    boolean register(UserProperties userProperties);

    boolean login(UserProperties userProperties);


    List<UserVO> queryUser(int id);

    UserVO editUser(UserProperties userProperties);


    UserVO searchUser(int id);

    UserVO deleteUser(int id);

    UserVO likeList(int id);

    UserVO starList(int id);


}