package com.datingsite.entities;

import com.datingsite.enums.Gender;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "USER_NAME" , unique = true , nullable = false)
    private String userName;

    @Column(name = "PASSWORD" , nullable = false)
    private String password;

    @Column(name = "NICKNAME" , nullable = false)
    private String nickName;

    @Column(name = "AGE" , nullable = false)
    private int age;

    @Column(name = "GENDER" , nullable = false)
    private Gender gender;
    @Column(name = "GENDER_OF_INTEREST" , nullable = false)
    private Gender genderOfInterest;

    @ManyToMany
    private List<User> likedUsers;

    @ManyToMany
    private List<User> matches;

    //-1 2
    //user_user_liked
    //2 1
    //user_user_matched
    //1 2

    public User() {
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

    public void setId(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}


