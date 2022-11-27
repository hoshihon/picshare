package com.github.hoshihon.picshare.dao;

import com.github.hoshihon.picshare.PicshareApplication;
import com.github.hoshihon.picshare.dao.mybatis.ArtMapper;
import com.github.hoshihon.picshare.dao.mybatis.UserMapper;
import com.github.hoshihon.picshare.dto.UserProfile;
import com.github.hoshihon.picshare.dto.UserProperties;
import com.github.hoshihon.picshare.model.Art;
import com.github.hoshihon.picshare.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PicshareApplication.class)
public class UserTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ArtMapper artMapper;

    @Test
    @Transactional
    public void insertUserTest() {
        User user = new User(1, "user1", "12345", "1111",
                "imglink1", new Date(), "male", new Date(), null);

        userMapper.register(user);
        Assert.assertNotNull(user.getId());
    }

    @Test
    @Transactional
    public void loginUserTest() {
        User user = new User(1, "user1", "12345", "1111",
                "imglink1", new Date(), "male", new Date(), null);

        userMapper.register(user);
        Assert.assertNotNull(user.getId());
        {
            UserProperties userT = new UserProperties("user1", "12345");
            String username = userT.getUsername();
            String password = userT.getPassword();
            User loginUser = userMapper.findUser(username);

            if (loginUser == null) {
                Assert.fail("no user");
            } else {
                if (loginUser.getPassword().equals(password)) {
                    Assert.assertTrue("login", true);
                } else {
                    Assert.fail("wrong password");
                }
            }

        }

    }

    @Test
    @Transactional
    public void updateUserTest() {
        User user = new User(1, "user1", "12345", "1111",
                "imglink1", new Date(), "male", null, null);
        userMapper.register(user);
        Assert.assertNotNull(user.getId());

        {
            user.setSex("female");
            Assert.assertEquals(1, userMapper.update(user));

        }

    }

    @Test
    @Transactional
    public void deleteUserTest() {
        User user = new User(1L, "user1", "12345", "1111",
                "imglink1", new Date(), "male", null, null);
        userMapper.register(user);
        Assert.assertNotNull(user.getId());

        {
            Assert.assertEquals(0, userMapper.delete(1L));
        }

    }

    @Test
    @Transactional
    public void UserProfileTest() {
        User user = new User(1L, "user1", "12345", "1111",
                "imglink1", new Date(), "male", null, null);
        userMapper.register(user);

        Art art = new Art("art1", "link1", "cat", 0, 0, new Date(), "cat picture", user.getId());
        Art art1 = new Art("art2", "link2", "cat", 0, 0, new Date(), "cat picture", user.getId());
        artMapper.insert(art);
        artMapper.insert(art1);

        {
            List<UserProfile> result = userMapper.userProfile(1L);
//            Assert.assertEquals(1,result.size());
            Assert.assertNotNull(result);
        }
    }


}
