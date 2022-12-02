package com.github.hoshihon.picshare.model;

import java.util.Date;
import java.util.List;

public class Profile extends User {
    protected List<Art> userArt;

    public Profile() {
    }

    public Profile(long id, String username, String password, String nickname, String icon, Date birth, String sex, Date registerDate, Date loginDate) {
        super(id, username, password, nickname, icon, birth, sex, registerDate, loginDate);
    }

    public Profile(long id, String username, String password, String nickname, String icon, Date birth, String sex, Date registerDate, Date loginDate, List<Art> userArt) {
        super(id, username, password, nickname, icon, birth, sex, registerDate, loginDate);
        this.userArt = userArt;
    }

    public List<Art> getUserArt() {
        return userArt;
    }

    public void setUserArt(List<Art> userArt) {
        this.userArt = userArt;
    }
}
