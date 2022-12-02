package com.github.hoshihon.picshare.dao;

import com.github.hoshihon.picshare.dto.UserProfile;
import com.github.hoshihon.picshare.dto.UserProperties;
import com.github.hoshihon.picshare.model.User;

import java.util.List;

public interface UserDAO extends BaseDAO {

    UserProfile userProfile(long id);

    void register(User user);


    User findUser(String username);

}
