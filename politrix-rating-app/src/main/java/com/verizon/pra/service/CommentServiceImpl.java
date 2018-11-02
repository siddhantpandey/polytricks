package com.verizon.pra.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.pra.dao.CommentRepository;
import com.verizon.pra.dao.PoliticianRepository;
import com.verizon.pra.dao.UserDao;
import com.verizon.pra.model.Comment;
import com.verizon.pra.model.Politician;
import com.verizon.pra.model.User;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepo;
	
	@Autowired
	private UserDao userRepo;
	
	@Autowired
	private PoliticianRepository politicianRepo;
	
	@Autowired
	private StatisticsService statService;
	
	@Override
	public List<Comment> getAllComments() {
		return commentRepo.findAll();
	}

	
	@Override
	public Comment getCommentById(long commentId) {
		Comment comment = null;
		Optional<Comment> optComment = commentRepo.findById(commentId);
		
		if(optComment.isPresent())
			comment = optComment.get();
		return comment;
	}

	
	@Override
	public Comment addComment(Comment comment) {
		Comment cmt = commentRepo.save(comment);
		statService.setStatisticsByPolitician(comment.getPolitician().getpId());
		return cmt;
	}

	
	@Override
	public Comment updateComment(Comment comment) {
		return commentRepo.save(comment);
	}

	
	@Override
	public boolean deleteCommentById(long commentId) {
		boolean isDeleted = false;
		
		if(commentRepo.existsById(commentId)) {
			commentRepo.deleteById(commentId);
			isDeleted = true;
		}
		
		return isDeleted;
	}

	
	@Override
	public List<Comment> getAllCommentsByUserId(long userId) {
		Optional<User> optUser = userRepo.findById(userId);
		List<Comment> comments = null;
		
		if(optUser.isPresent())
			comments = commentRepo.findAllByUser(optUser.get());
		
		return comments;
	}

	
	@Override
	public List<Comment> getAllCommentsByPoliticianId(long politicianId) {
		Optional<Politician> optPolitician = politicianRepo.findById(politicianId);
		List<Comment> comments = null;
		
		if(optPolitician.isPresent())
			comments = commentRepo.findAllByPolitician(optPolitician.get());
		
		return comments;
	}
	

	@Override
	public long getLikeCountByPolitician(long politicianId) {
		long likeCount = 0;
		
		Optional<Politician> optPolitician = politicianRepo.findById(politicianId);
		List<Comment> comments = null;
		
		if(optPolitician.isPresent()) {
			comments = commentRepo.findAllByPolitician(optPolitician.get());
			for(Comment comment: comments) {
				if(comment.isuLike() == true)
					likeCount++;
			}
		}
		
		return likeCount;
	}

	
	@Override
	public long getDislikeCountByPolitician(long politicianId) {
		long dislikeCount = 0;
		
		Optional<Politician> optPolitician = politicianRepo.findById(politicianId);
		List<Comment> comments = null;
		
		if(optPolitician.isPresent()) {
			comments = commentRepo.findAllByPolitician(optPolitician.get());
			for(Comment comment: comments) {
				if(comment.isuLike() == true)
					dislikeCount++;
			}
		}
		
		return dislikeCount;
	}
	

}

