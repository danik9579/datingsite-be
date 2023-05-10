package com.datingsite.dto;

import javax.persistence.Column;

public class LikeDto {
    private long id;
    private int userId;
    private int likedUserId;

    public LikeDto(long id, int userId, int likedUserId) {
        this.id = id;
        this.userId = userId;
        this.likedUserId = likedUserId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getLikedUserId() {
        return likedUserId;
    }

    public void setLikedUserId(int likedUserId) {
        this.likedUserId = likedUserId;
    }
}
