//package com.datingsite.logic;
//
//import com.datingsite.constants.Constants;
//import com.datingsite.dal.IMatchesDal;
//import com.datingsite.dto.LikeDto;
//import com.datingsite.entities.Like;
//import com.datingsite.entities.Match;
//import com.datingsite.enums.ErrorType;
//import com.datingsite.exceptions.ServerException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class MatchesLogic {
//    private IMatchesDal matchesDal;
//
//    @Autowired
//    public MatchesLogic(IMatchesDal matchesDal) {
//        this.matchesDal = matchesDal;
//    }
//
//    public void addMatch(Match match) throws ServerException {
//            try {
//                matchesDal.save(match);
//            }catch (Exception e){
//                throw new ServerException("Error in creating match " + match.getId(), ErrorType.GENERAL_ERROR);
//            }
//        }
//    public void removeMatch(long matchId) throws ServerException {
//        try {
//            matchesDal.deleteById(matchId);
//        }catch (Exception e){
//            throw new ServerException("Error in removing Match " + matchId, ErrorType.GENERAL_ERROR);
//        }
//    }
////    public LikeDto getMatch(long matchId) throws ServerException {
////        try {
////            LikeDto like = matchesDal.findById(matchId);
////            return like;
////        }catch (Exception e){
////            throw new ServerException("Error in getting User" + matchId, ErrorType.GENERAL_ERROR);
////        }
////    }
////    public List<LikeDto> getAllLikes(int page ) throws ServerException {
////        Pageable paging = PageRequest.of(page - 1 , Constants.RECORDS_PER_PAGE);
////        try {
////            List<LikeDto> likes = matchesDal.findAll(paging );
////            return likes;
////        }catch (Exception e){
////            throw new ServerException("Error in getting all likes", ErrorType.GENERAL_ERROR);
////        }
//    }
//
//
