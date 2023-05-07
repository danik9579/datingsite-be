package com.datingsite.dal;

import com.datingsite.dto.SuccessfulLoginData;
import com.datingsite.dto.UserDto;
import com.datingsite.entities.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUsersDal extends CrudRepository<User, Long> {
    @Query("SELECT NEW com.datingsite.dto.SuccessfulLoginData(u.id, u.nickName, u.age , u.gender)" +
            "FROM User u WHERE u.userName= :userName AND u.password= :password")
    SuccessfulLoginData login(@Param("userName")String userName , @Param("password")String password);

    @Query("SELECT NEW com.datingsite.dto.UserDto(u.id, u.userName, u.nickName, u.age , u.gender)" +
            "FROM User u WHERE u.id= :userId")
    UserDto findById(@Param("userId")long userId);

    @Query("SELECT NEW com.datingsite.dto.UserDto(u.id, u.userName, u.nickName, u.age , u.gender)" +
            "FROM User u")
    List<UserDto> findAll(Pageable paging);
    boolean existsByUserName(String userName);

    @Query("select count(u.userName)>0 FROM User u WHERE u.userName= :userName AND u.id!= :id")
    boolean existsByUserNameInDifferentId(@Param("userName")String userName, @Param("id")long id);
}
