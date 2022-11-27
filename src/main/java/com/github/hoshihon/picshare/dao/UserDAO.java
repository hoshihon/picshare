package com.github.hoshihon.picshare.dao;

import com.github.hoshihon.picshare.dto.UserProfile;
import com.github.hoshihon.picshare.dto.UserProperties;
import com.github.hoshihon.picshare.model.User;

import java.util.List;

public interface UserDAO extends BaseDAO {

    List<UserProfile> userProfile(long id);

    void register(User user);

    List<UserProperties> findById(int id);

    void update(UserProperties userProperties);

    User findUser(String username);

}
