package com.esprit.prestationservice.Services;

import com.esprit.prestationservice.Entities.CommentRoom;

import java.util.List;

public interface ICommentRoomService {
    public List<CommentRoom> getAllComments();


    public void deleteComment(Long commentId, String idUser);

    CommentRoom addComment(CommentRoom commentRoom, String idUser, Long idRoom);

}
