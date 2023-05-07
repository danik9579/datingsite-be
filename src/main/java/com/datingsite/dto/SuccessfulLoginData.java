package com.datingsite.dto;

import com.datingsite.enums.UserType;

import javax.persistence.Column;

public class SuccessfulLoginData {
    private long id;

    private String nickName;
    private int age;
    private String gender;

    public SuccessfulLoginData(Long id,String nickName, int age , String gender) {
        this.id = id;
        this.nickName = nickName;
        this.age = age;
        this.gender = gender;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                '}';
    }
}
