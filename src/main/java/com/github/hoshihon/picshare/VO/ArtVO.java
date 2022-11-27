package com.github.hoshihon.picshare.VO;

import java.util.Date;

public class ArtVO {

    private int id;

    private String title;

    private String imgLink;

    private String tag;

    private int likeCount = 0;

    private int starCount = 0;

    private Date uploadTime;

    private String description;

    private int user_id;

    public ArtVO(int id, String title, String imgLink, String tag, Date uploadTime, String description, int user_id) {
        this.id = id;
        this.title = title;
        this.imgLink = imgLink;
        this.tag = tag;
        this.uploadTime = uploadTime;
        this.description = description;
        this.user_id = user_id;
    }

    public ArtVO(int id, String title, String imgLink, String tag, int user_id) {
        this.id = id;
        this.title = title;
        this.imgLink = imgLink;
        this.tag = tag;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getStarCount() {
        return starCount;
    }

    public void setStarCount(int starCount) {
        this.starCount = starCount;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
