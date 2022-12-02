package com.github.hoshihon.picshare.dto;

import java.util.Date;
import java.util.List;

public class UserProfile extends UserProperties {

    protected List<ArtProperties> userArt;

    public UserProfile(long id, String username, String password, String nickname, String icon, Date birth, String sex, Date registerDate, Date loginDate) {
        super(id, username, password, nickname, icon, birth, sex, registerDate, loginDate);
    }

    public UserProfile(String username, String password, List<ArtProperties> userArt) {
        super(username, password);
        this.userArt = userArt;
    }

    public UserProfile() {
    }

    public List<ArtProperties> getUserArt() {
        return userArt;
    }

    public void setUserArt(List<ArtProperties> userArt) {
        this.userArt = userArt;
    }
}
