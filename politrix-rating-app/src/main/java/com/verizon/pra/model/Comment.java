package com.verizon.pra.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="Comments")
public class Comment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long cId;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="pId")
	private Politician politician;
	
	@ManyToOne
	@JoinColumn(name = "uId")
	private User user;
	
	private String uComment;
	
	private boolean uLike;
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Comment(Politician politician, User user, String uComment, boolean uLike) {
		super();
		this.politician = politician;
		this.user = user;
		this.uComment = uComment;
		this.uLike = uLike;
	}



	public Politician getPolitician() {
		return politician;
	}

	public void setPolitician(Politician politician) {
		this.politician = politician;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getuComment() {
		return uComment;
	}

	public void setuComment(String uComment) {
		this.uComment = uComment;
	}

	public boolean isuLike() {
		return uLike;
	}

	public void setuLike(boolean uLike) {
		this.uLike = uLike;
	}

	public Long getcId() {
		return cId;
	}

	public void setcId(Long cId) {
		this.cId = cId;
	}
	
	
}


