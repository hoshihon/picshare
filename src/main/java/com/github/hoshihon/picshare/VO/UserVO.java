package com.github.hoshihon.picshare.VO;

import java.util.Date;

public class UserVO {

    private long id;

    private String username;

    private String password;

    private String icon;

    private Date birth;


    private String sex;

    private Date registerDate;

    private Date loginDate;

    public UserVO(long id, String username, String password, String icon, Date birth, String sex, Date registerDate, Date loginDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.icon = icon;
        this.birth = birth;
        this.sex = sex;
        this.registerDate = registerDate;
        this.loginDate = loginDate;
    }

    public UserVO(String username, String password) {

        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }
}
