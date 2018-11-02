package com.verizon.pra.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    
    @Column
    @NotNull
    private String username;
    
    
    @Column
    @NotEmpty
    private String password;
    
    
    @Column
    @NotEmpty
    private String uName;
    
    

	@Column
    @NotEmpty
    private String uEmailId;
    
    @Column
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Comment> uComments;
    
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuEmailId() {
		return uEmailId;
	}

	public void setuEmailId(String uEmailId) {
		this.uEmailId = uEmailId;
	}

	public List<Comment> getuComments() {
		return uComments;
	}

	public void setuComments(List<Comment> uComments) {
		this.uComments = uComments;
	}
	
	

   
}
