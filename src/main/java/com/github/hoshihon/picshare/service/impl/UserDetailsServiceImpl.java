package com.github.hoshihon.picshare.service.impl;

import com.github.hoshihon.picshare.dao.mybatis.UserMapper;
import com.github.hoshihon.picshare.model.LoginUser;
import com.github.hoshihon.picshare.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    /**
     * Locates the user based on the username. In the actual implementation, the search
     * may possibly be case sensitive, or case insensitive depending on how the
     * implementation instance is configured. In this case, the <code>UserDetails</code>
     * object that comes back may have a username that is of a different case than what
     * was actually requested..
     *
     * @param username the username identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     *                                   GrantedAuthority
     */
    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userMapper.findUser(username);
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("登陆失败");
        }

        // TODO: 查询用户权限信息
        List<String> authList = new ArrayList<>(Arrays.asList("user","admin"));


        return new LoginUser(user,authList);
    }


}
