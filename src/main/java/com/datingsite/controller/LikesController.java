package com.datingsite.controller;

import com.datingsite.dto.LikeDto;
import com.datingsite.dto.UserDto;
import com.datingsite.entities.Like;
import com.datingsite.exceptions.ServerException;
import com.datingsite.logic.LikesLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/likes")
public class LikesController {

        private LikesLogic likesLogic;

    @Autowired
    public LikesController(LikesLogic likesLogic) {
        this.likesLogic = likesLogic;
    }

        @PostMapping
        public void createLike(@RequestBody Like like) throws ServerException {
            likesLogic.addLike(like);
        }

        @DeleteMapping("{likeId}")
        public void deleteLike(@PathVariable("likeId") int likeId) throws ServerException {
            likesLogic.removeLike(likeId);
        }

        @GetMapping("{likeId}")
        public LikeDto getLike(@PathVariable("LikeId") int likeId) throws ServerException {
            LikeDto like = likesLogic.getLike(likeId);
            return like;
        }
        @GetMapping
        public List<LikeDto> getAllLikes(@RequestParam("page") int page ) throws ServerException {
            List<LikeDto> likes = likesLogic.getAllLikes(page);
            return likes;
        }
    }



