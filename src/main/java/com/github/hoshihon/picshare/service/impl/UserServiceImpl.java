package com.github.hoshihon.picshare.service.impl;

import com.github.hoshihon.picshare.VO.UserVO;
import com.github.hoshihon.picshare.dao.LikeDAO;
import com.github.hoshihon.picshare.dao.UserDAO;
import com.github.hoshihon.picshare.dto.UserProperties;
import com.github.hoshihon.picshare.model.User;
import com.github.hoshihon.picshare.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    private LikeDAO likeDAO;


    @Override
    public boolean register(UserProperties userProperties) {
        String username = userProperties.getUsername();
        User registUser = userDAO.findUser(username);
        if (registUser != null) {
            return false;
        }
        userDAO.insert(userProperties);
        return true;
    }


    @Override
    public boolean login(UserProperties user) {
        String username = user.getUsername();
        String password = user.getPassword();
        User loginUser = userDAO.findUser(username);
        if (loginUser == null) {
            return false;
        } else {
            return loginUser.getPassword().equals(password);
        }
    }

    @Override
    public List<UserVO> queryUser(int id) {
        return null;
    }

    @Override
    public UserVO editUser(UserProperties userProperties) {
        return null;
    }

    @Override
    public UserVO searchUser(int id) {
        return null;
    }

    @Override
    public UserVO deleteUser(int id) {
        return null;
    }

    @Override
    public UserVO likeList(int id) {
        return null;
    }

    @Override
    public UserVO starList(int id) {
        return null;
    }
}
