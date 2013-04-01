package com.bd.spring.mvc.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User_ProfileEntry {
	@JsonProperty("Name")
	private String Name;
	@JsonProperty("Created_TS")
	private String Created_TS;
	@JsonProperty("Relationship_Status")
	private String Relationship_Status;
	@JsonProperty("Lives_in")
	private String Lives_in;
	@JsonProperty("Email_ID")
	private String Email_ID;
	@JsonProperty("Profile_ID")
	private Integer Profile_ID;
	@JsonProperty("Sex")
	private String Sex;
	@JsonProperty("Languages")
	private String Languages;

	@Override
	public String toString() {
		return "User_ProfileEntry [Name=" + Name + ", Created_TS=" + Created_TS + ", Relationship_Status=" + Relationship_Status + ", Lives_in=" + Lives_in
				+ ", Email_ID=" + Email_ID + ", Profile_ID=" + Profile_ID + ", Sex=" + Sex + ", Languages=" + Languages + "]";
	}

	public User_ProfileEntry(){
		
	}
	public User_ProfileEntry(String name, String created_TS, String relationship_Status, String lives_in, String email_ID, Integer profile_ID, String sex,
			String languages) {
		super();
		Name = name;
		Created_TS = created_TS;
		Relationship_Status = relationship_Status;
		Lives_in = lives_in;
		Email_ID = email_ID;
		Profile_ID = profile_ID;
		Sex = sex;
		Languages = languages;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getCreated_TS() {
		return Created_TS;
	}

	public void setCreated_TS(String created_TS) {
		Created_TS = created_TS;
	}

	public String getRelationship_Status() {
		return Relationship_Status;
	}

	public void setRelationship_Status(String relationship_Status) {
		Relationship_Status = relationship_Status;
	}

	public String getLives_in() {
		return Lives_in;
	}

	public void setLives_in(String lives_in) {
		Lives_in = lives_in;
	}

	public String getEmail_ID() {
		return Email_ID;
	}

	public void setEmail_ID(String email_ID) {
		Email_ID = email_ID;
	}

	public Integer getProfile_ID() {
		return Profile_ID;
	}

	public void setProfile_ID(Integer profile_ID) {
		Profile_ID = profile_ID;
	}

	public String getSex() {
		return Sex;
	}

	public void setSex(String sex) {
		Sex = sex;
	}

	public String getLanguages() {
		return Languages;
	}

	public void setLanguages(String languages) {
		Languages = languages;
	}

}
