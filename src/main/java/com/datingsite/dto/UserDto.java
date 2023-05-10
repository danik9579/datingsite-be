package com.datingsite.dto;

import com.datingsite.enums.Gender;

public class UserDto {
    private long id;

    private String userName;

    private String nickName;

    private int age;
    private Gender gender;
    private Gender genderOfInterest;


    public UserDto(long id, String userName, String nickName, int age, Gender gender, Gender genderOfInterest) {
        this.id = id;
        this.userName = userName;
        this.nickName = nickName;
        this.age = age;
        this.gender = gender;
        this.genderOfInterest = genderOfInterest;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Gender getGenderOfInterest() {
        return genderOfInterest;
    }

    public void setGenderOfInterest(Gender genderOfInterest) {
        this.genderOfInterest = genderOfInterest;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", genderOfInterest=" + genderOfInterest +
                '}';
    }
}
