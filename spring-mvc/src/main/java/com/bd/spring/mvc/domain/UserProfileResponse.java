package com.bd.spring.mvc.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserProfileResponse {
	@JsonProperty("User_Profile")
	private List<User_ProfileEntry> User_Profile;

	public UserProfileResponse(){
		
	}
	public UserProfileResponse(List<User_ProfileEntry> user_Profile) {
		super();
		User_Profile = user_Profile;
	}


	@Override
	public String toString() {
		return "UserProfileResponse [User_Profile=" + User_Profile + "]";
	}


	public List<User_ProfileEntry> getUser_Profile() {
		return User_Profile;
	}


	public void setUser_Profile(List<User_ProfileEntry> user_Profile) {
		User_Profile = user_Profile;
	}
	
	
}
