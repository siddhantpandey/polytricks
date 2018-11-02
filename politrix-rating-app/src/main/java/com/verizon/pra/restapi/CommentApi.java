package com.verizon.pra.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.pra.model.Comment;
import com.verizon.pra.service.CommentService;

@CrossOrigin
@RestController
@RequestMapping("/comments")
public class CommentApi {

	@Autowired
	private CommentService commentService;
	
	
	@GetMapping
	public ResponseEntity<List<Comment>> getAllComments() {
		return new ResponseEntity<>(commentService.getAllComments(), HttpStatus.OK);
	}
	
	
	@GetMapping("/byPolitician/{pId}")
	public ResponseEntity<List<Comment>> getAllCommentsByPolitician(@PathVariable("pId") long politicianId) {
		
		return new ResponseEntity<>(commentService.getAllCommentsByPoliticianId(politicianId), HttpStatus.OK);
	}
	
	
	@GetMapping("/byUser/{uId}")
	public ResponseEntity<List<Comment>> getAllOrdersByUser(@PathVariable("uId") long userId) {
		
		return new ResponseEntity<>(commentService.getAllCommentsByUserId(userId), HttpStatus.OK);
	}
	
	
	@GetMapping("/{cId}")
	public ResponseEntity<Comment> getCommentById(@PathVariable("cId") Long commentId) {
		ResponseEntity<Comment> resp = null;
		
		Comment comment = commentService.getCommentById(commentId);
		
		if(comment!=null)
			resp = new ResponseEntity<>(comment, HttpStatus.OK);
		else
			resp = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return resp;
	}
	
	
	@PostMapping
	public ResponseEntity<Comment> addComment(@RequestBody Comment comment) {
		
		ResponseEntity<Comment> resp = null;
		Comment cmt = commentService.addComment(comment);
		
		if(cmt!=null)
			resp = new ResponseEntity<>(cmt, HttpStatus.OK);
		else
			resp = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		return resp;
		
	}
	
	
	@PutMapping
	public ResponseEntity<Comment> updateComment(@RequestBody Comment comment) {
		
		ResponseEntity<Comment> resp = null;
		Comment cmt = commentService.updateComment(comment);
		
		if(cmt!=null)
			resp = new ResponseEntity<>(cmt, HttpStatus.OK);
		else
			resp = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		return resp;
		
	}
	
	
	@DeleteMapping("/{cId}")
	public ResponseEntity<Void> deleteComment(@PathVariable("cId") long commentId) {
		
		ResponseEntity<Void> resp = null;
		
		if(commentService.deleteCommentById(commentId))
			resp = new ResponseEntity<>(HttpStatus.OK);
		else
			resp = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		return resp;
	}
	
}
