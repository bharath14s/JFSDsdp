package com.klef.jfsd.sdpproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="analyst_table")
public class Analyst 
{
	@Id
	@Column(name ="analyst_username",length = 50)
	private String username;
	@Column(name="analyst_password",length = 50,nullable = false)
	private String password;
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
}
