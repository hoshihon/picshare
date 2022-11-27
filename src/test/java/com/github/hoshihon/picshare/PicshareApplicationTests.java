package com.github.hoshihon.picshare;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PicshareApplication.class)
public class PicshareApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    DataSource dataSource;

    @Test
    public void jdbcConnectionTest() {
        new JdbcTemplate(dataSource).query("SELECT 1", resultSet -> {
            Assert.assertEquals(resultSet.getInt(1), 1);
        });
    }

}
