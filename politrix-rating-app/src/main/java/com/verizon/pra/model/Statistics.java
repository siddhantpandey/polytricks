
package com.verizon.pra.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Table
@Entity(name = "Statistics")
public class Statistics {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long statId;

	@OneToOne
	@JoinColumn(unique = true)
	@JsonBackReference
	private Politician politician;

	private double likeCount;

	private double dislikeCount;

	private double popularityIndex;

	public Statistics() {
		// TODO Auto-generated constructor stub
	}

	public Statistics(Politician politicianId, double likeCount, double dislikeCount, double popularityIndex) {
		super();
		this.politician = politicianId;
		this.likeCount = likeCount;
		this.dislikeCount = dislikeCount;
		this.popularityIndex = popularityIndex;
	}

	public long getStatId() {
		return statId;
	}

	public void setStatId(long statId) {
		this.statId = statId;
	}

	public double getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(double likeCount) {
		this.likeCount = likeCount;
	}

	public double getDislikeCount() {
		return dislikeCount;
	}

	public void setDislikeCount(double dislikeCount) {
		this.dislikeCount = dislikeCount;
	}

	public double getPopularityIndex() {
		return popularityIndex;
	}

	public void setPopularityIndex(double popularityIndex) {
		this.popularityIndex = popularityIndex;
	}

	public Politician getPolitician() {
		return politician;
	}

	public void setPolitician(Politician politician) {
		this.politician = politician;
	}


}