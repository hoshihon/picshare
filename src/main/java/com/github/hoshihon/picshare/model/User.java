package com.github.hoshihon.picshare.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private static final long serialVersionUID = -40356785423868312L;

    private long id;

    private String username;

    private String password;

    private String nickname;

    private String icon;

    private Date birth;


    private String sex;

    private Date registerDate;

    private Date loginDate;

    public User() {
    }

    public User(long id, String username, String password, String nickname, String icon, Date birth, String sex, Date registerDate, Date loginDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.icon = icon;
        this.birth = birth;
        this.sex = sex;
        this.registerDate = registerDate;
        this.loginDate = loginDate;
    }

    public User(String username, String password) {
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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
