package com.datingsite.logic;

import com.datingsite.constants.Constants;
import com.datingsite.dal.ILikesDal;

import com.datingsite.dto.LikeDto;
import com.datingsite.entities.Like;
import com.datingsite.enums.ErrorType;
import com.datingsite.exceptions.ServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikesLogic {
    private ILikesDal likesDal;

    @Autowired
    public LikesLogic(ILikesDal likesDal) {
        this.likesDal = likesDal;
    }

    public void addLike(Like like) throws ServerException {
            try {
                likesDal.save(like);
            }catch (Exception e){
                throw new ServerException("Error in creating like " + like.getId(), ErrorType.GENERAL_ERROR);
            }
        }
    public void removeLike(long likeId) throws ServerException {
        try {
            likesDal.deleteById(likeId);
        }catch (Exception e){
            throw new ServerException("Error in removing like " + likeId, ErrorType.GENERAL_ERROR);
        }
    }
    public LikeDto getLike(long likeId) throws ServerException {
        try {
            LikeDto like = likesDal.findById(likeId);
            return like;
        }catch (Exception e){
            throw new ServerException("Error in getting User" + likeId, ErrorType.GENERAL_ERROR);
        }
    }
    public List<LikeDto> getAllLikes(int page ) throws ServerException {
        Pageable paging = PageRequest.of(page - 1 , Constants.RECORDS_PER_PAGE);
        try {
            List<LikeDto> likes = likesDal.findAll(paging );
            return likes;
        }catch (Exception e){
            throw new ServerException("Error in getting all likes", ErrorType.GENERAL_ERROR);
        }
    }
    }

