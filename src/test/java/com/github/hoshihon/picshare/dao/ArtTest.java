package com.github.hoshihon.picshare.dao;

import com.github.hoshihon.picshare.PicshareApplication;
import com.github.hoshihon.picshare.dao.mybatis.ArtMapper;
import com.github.hoshihon.picshare.dao.mybatis.UserMapper;
import com.github.hoshihon.picshare.dto.ArtProperties;
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
public class ArtTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ArtMapper artMapper;

    @Test
    @Transactional
    public void insertArtTest() {
        User user = new User(1, "user1", "12345", "1111",
                "imglink1", new Date(), "male", new Date(), null);

        userMapper.register(user);
        Art art = new Art("art1", "link1", "cat", 0, 0, new Date(), "cat picture", user.getId());

        artMapper.insert(art);
        Assert.assertNotNull(art.getId());
    }

    @Test
    @Transactional
    public void updateArtTest() {
        User user = new User(1, "user1", "12345", "1111",
                "imglink1", new Date(), "male", new Date(), null);

        userMapper.register(user);
        Assert.assertNotNull(user.getId());

        Art art = new Art("art1", "link1", "cat", 0, 0, new Date(), "cat picture", user.getId());

        artMapper.insert(art);
        Assert.assertNotNull(art.getId());

        {
            art.setTitle("jjs");
            Assert.assertEquals(1, artMapper.update(art));
        }
        {
            art.setImgLink("link2");
            Assert.assertEquals(1, artMapper.update(art));
        }
        {
            art.setTag("dog");
            Assert.assertEquals(1, artMapper.update(art));
        }
        {
            art.setDescription("dog picture");
            Assert.assertEquals(1, artMapper.update(art));
        }
    }

    @Test
    @Transactional
    public void queryArtTest() {
        User user = new User(1, "user1", "12345", "1111",
                "imglink1", new Date(), "male", new Date(), null);
        userMapper.register(user);

        Art art = new Art("art", "link", "cat", 0, 0, new Date(), "cat picture", user.getId());
        Art art1 = new Art("art1", "link1", "cat1", 0, 0, new Date(), "cat picture1", user.getId());
        Art art2 = new Art("art2", "link2", "cat2", 0, 0, new Date(), "cat picture2", user.getId());
        artMapper.insert(art);
        artMapper.insert(art1);
        artMapper.insert(art2);


        {
            List<ArtProperties> query = artMapper.artQuery();
            Assert.assertEquals(3, query.size());
        }

    }
}
