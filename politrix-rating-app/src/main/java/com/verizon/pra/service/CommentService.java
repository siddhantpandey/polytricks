package com.verizon.pra.service;

import java.util.List;

import com.verizon.pra.model.Comment;

public interface CommentService {

	List<Comment> getAllComments();
	
	Comment getCommentById(long commentId);
	
	Comment addComment(Comment comment);
	
	Comment updateComment(Comment comment);
	
	boolean deleteCommentById(long commentId);
	
	
	List<Comment> getAllCommentsByUserId(long userId);
	
	List<Comment> getAllCommentsByPoliticianId(long politicianId);
	
	
	long getLikeCountByPolitician(long politicianId);
	
	long getDislikeCountByPolitician(long politicianId);
	
}
