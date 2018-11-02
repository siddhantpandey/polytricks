package com.verizon.pra.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.pra.model.Comment;
import com.verizon.pra.model.Politician;
import com.verizon.pra.model.User;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

	List<Comment> findAllByUser(User users);
	
	List<Comment> findAllByPolitician(Politician politician);
	
}
