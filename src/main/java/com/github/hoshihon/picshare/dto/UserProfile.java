package com.github.hoshihon.picshare.dto;

import com.github.hoshihon.picshare.model.Art;
import com.github.hoshihon.picshare.model.User;

import java.util.Date;

public class UserProfile extends UserProperties{

    private long artId;
    private String title;
    private String imgLink;
    private Art art;

    public UserProfile(long id, String username, String password, String nickname, String icon, Date birth, String sex, Date registerDate, Date loginDate) {
        super(id, username, password, nickname, icon, birth, sex, registerDate, loginDate);
    }

    public UserProfile(long id, String username, String password, String nickname, String icon, Date birth, String sex, Date registerDate, Date loginDate, long artId, String title, String imgLink) {
        super(id, username, password, nickname, icon, birth, sex, registerDate, loginDate);
        this.artId = artId;
        this.title = art.getTitle();
        this.imgLink = imgLink;
    }

    public UserProfile() {
    }

    public long getArtId() {
        return artId;
    }

    public void setArtId(long artId) {
        this.artId = artId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public Art getArt() {
        return art;
    }

    public void setArt(Art art) {
        this.art = art;
    }
}
