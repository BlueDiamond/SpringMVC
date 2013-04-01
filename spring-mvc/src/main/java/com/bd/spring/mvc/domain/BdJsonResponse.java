package com.bd.spring.mvc.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BdJsonResponse {
	@JsonProperty("UserProfileResponse")
	private UserProfileResponse UserProfileResponse;

	public BdJsonResponse(){
		
	}
	public BdJsonResponse(UserProfileResponse userProfileResponse) {
		super();
		UserProfileResponse = userProfileResponse;
	}

	@Override
	public String toString() {
		return "BdJsonResponse [UserProfileResponse=" + UserProfileResponse + "]";
	}

	public UserProfileResponse getUserProfileResponse() {
		return UserProfileResponse;
	}

	public void setUserProfileResponse(UserProfileResponse userProfileResponse) {
		UserProfileResponse = userProfileResponse;
	}
	
	
}
