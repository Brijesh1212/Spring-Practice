package com.org.java.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="credentials")
public class Credentials {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer cId;
	
	@Column
	private String email;
	
	@Column
	private String password;
 
	public Integer getcId() {
		return cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Credentials(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public Credentials() {
		super();
	}

}
