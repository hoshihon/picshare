package com.github.hoshihon.picshare.service.impl;

import com.github.hoshihon.picshare.VO.UserVO;
import com.github.hoshihon.picshare.dao.LikeDAO;
import com.github.hoshihon.picshare.dao.UserDAO;
import com.github.hoshihon.picshare.dto.UserProfile;
import com.github.hoshihon.picshare.dto.UserProperties;
import com.github.hoshihon.picshare.model.LoginUser;
import com.github.hoshihon.picshare.model.User;
import com.github.hoshihon.picshare.service.LoginResult;
import com.github.hoshihon.picshare.service.ResponseResult;
import com.github.hoshihon.picshare.service.UserService;
import com.github.hoshihon.picshare.util.JwtUtil;
import com.github.hoshihon.picshare.util.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private LikeDAO likeDAO;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisCache redisCache;


    @Override
    public boolean register(User user) {
        String username = user.getUsername();
        User registUser = userDAO.findUser(username);

        if (registUser != null) {
            return false;
        }
        user.setRegisterDate(new Date());
        user.setNickname(username);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDAO.register(user);
        return true;
    }


    /**
     * @param user
     * @return 0 -
     * 1 -
     */
    @Override
    public ResponseResult login(UserProperties user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        Authentication authenticate;
        try {
            authenticate = authenticationManager.authenticate(authenticationToken);
        } catch (LockedException e) {
            return new ResponseResult(LoginResult.ACCOUNT_LOCKED, "用户被锁定");
        } catch (DisabledException e) {
            return new ResponseResult(LoginResult.ACCOUNT_DISABLE, "用户不可用");
        } catch (BadCredentialsException e) {
            return new ResponseResult(LoginResult.WRONG_PASSWORD, "用户密码错误");
        } catch (UsernameNotFoundException e) {
            return new ResponseResult(LoginResult.ACCOUNT_NOT_FOUND, "没有该名用户");
        }

        //根据userid获取jwt
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userid = Long.toString(loginUser.getUser().getId());
        String jwt = JwtUtil.createJWT(userid);
        Map<String, String> map = new HashMap();
        map.put("token", jwt);
        //存入redis
        redisCache.setCacheObject("login:" + userid, loginUser);

        //

        return new ResponseResult(LoginResult.SUCCESS, "登陆成功", map);
    }

    @Override
    public ResponseResult loginOut() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        long userid = loginUser.getUser().getId();
        redisCache.deleteObject("login:"+userid);
        return new ResponseResult(LoginResult.SUCCESS,"登出成功");
    }

    @Override
    public UserProfile userProfile(long id) {
        UserProfile userProfiles = userDAO.userProfile(id);
        return userProfiles;
    }

    @Override
    public int updateUser(UserProperties userProperties) {
        User user = userProperties.toUser(userProperties);
        int update = userDAO.update(user);
        return update;


    }

    @Override
    public UserProperties findById(long id) {
        UserProperties user = (UserProperties) userDAO.findById(id);
        return user;
    }

    @Override
    public UserProperties searchUser(int id) {
        return null;
    }

    @Override
    public int deleteUser(int id) {
        int delete = userDAO.delete(id);
        return delete;
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
