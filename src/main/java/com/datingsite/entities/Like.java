package com.datingsite.entities;

import javax.persistence.*;


@Entity
@Table(name="likes")
public class Like {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "USER_ID" , unique = true , nullable = false)
    private int userId;

    @Column(name = "LIKED_USER_ID" , nullable = false)
    private int likedUserId;

    public Like() {
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
