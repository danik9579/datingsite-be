package com.datingsite.dal;

import com.datingsite.dto.LikeDto;
import com.datingsite.entities.Like;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ILikesDal extends CrudRepository<Like, Long> {


    @Query("SELECT NEW com.datingsite.dto.LikeDto(l.id, l.userId, l.likedUserId )" +
            "FROM Like l ")
    List<LikeDto> findAll(Pageable paging );



        @Query("SELECT NEW com.datingsite.dto.LikeDto(l.id, l.userId, l.likedUserId )" +
                "FROM Like l WHERE l.id= :likeId")
        LikeDto findById(@Param("likeId")long likeId);



}
