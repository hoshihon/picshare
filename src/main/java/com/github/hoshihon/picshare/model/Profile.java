package com.github.hoshihon.picshare.model;

import java.util.Date;

public class Profile extends User {

    protected long artId;
    protected String title;
    protected String imgLink;

    protected Art art;

    public Profile() {
    }

    public Profile(long id, String username, String password, String nickname, String icon, Date birth, String sex, Date registerDate, Date loginDate) {
        super(id, username, password, nickname, icon, birth, sex, registerDate, loginDate);
    }

    public Profile(long id, String username, String password, String nickname, String icon, Date birth, String sex, Date registerDate, Date loginDate, long artId, String title, String imgLink) {
        super(id, username, password, nickname, icon, birth, sex, registerDate, loginDate);
        this.artId = artId;
        this.title = title;
        this.imgLink = imgLink;
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
