package com.datingsite.dto;

import com.datingsite.enums.Gender;
import com.datingsite.enums.UserType;

import javax.persistence.Column;

public class SuccessfulLoginData {
    private long id;

    private String nickName;
    private int age;
    private Gender gender;
    private Gender genderOfInterest;

    public SuccessfulLoginData(long id, String nickName, int age, Gender gender, Gender genderOfInterest) {
        this.id = id;
        this.nickName = nickName;
        this.age = age;
        this.gender = gender;
        this.genderOfInterest = genderOfInterest;
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
        return "UserData{" +
                "id=" + id +
                '}';
    }
}
