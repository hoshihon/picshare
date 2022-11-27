package com.github.hoshihon.picshare.dto;

import java.util.Date;

public class ArtProperties {
    private long id;

    private String title;

    private String imgLink;

    private String tag;

    private int likeCount = 0;

    private int starCount = 0;

    private Date uploadTime;

    private String description;

    private long userId;

    public ArtProperties(long id, String title, String imgLink, String tag, int likeCount, int starCount, Date uploadTime, String description, long userId) {
        this.id = id;
        this.title = title;
        this.imgLink = imgLink;
        this.tag = tag;
        this.likeCount = likeCount;
        this.starCount = starCount;
        this.uploadTime = uploadTime;
        this.description = description;
        this.userId = userId;
    }

    public ArtProperties(String title, String imgLink, Date uploadTime, long userId) {
        this.title = title;
        this.imgLink = imgLink;
        this.uploadTime = uploadTime;
        this.userId = userId;
    }

    public ArtProperties(String title, String imgLink, String tag, Date uploadTime, String description, long userId) {
        this.title = title;
        this.imgLink = imgLink;
        this.tag = tag;
        this.uploadTime = uploadTime;
        this.description = description;
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
