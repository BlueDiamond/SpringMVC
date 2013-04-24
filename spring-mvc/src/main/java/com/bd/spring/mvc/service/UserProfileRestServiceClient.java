package com.bd.spring.mvc.service;

import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bd.spring.mvc.domain.BdJsonResponse;
import com.bd.spring.mvc.domain.User_ProfileEntry;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserProfileRestServiceClient {

	private static Logger logger = LoggerFactory.getLogger(UserProfileRestServiceClient.class);

	public int createUserProfileJson(String payload) {

		DefaultHttpClient httpClient = new DefaultHttpClient();
		int output = 0;
		try {

			HttpPost httpPostRequest = new HttpPost("http://localhost:2021/mule-esb/rest/createuserprofile");
			httpPostRequest.addHeader("accept", "application/json");

			StringEntity body = new StringEntity(payload);
			body.setContentType("application/json");
			httpPostRequest.setEntity(body);

			HttpResponse response = httpClient.execute(httpPostRequest);
			String rawOutput = IOUtils.toString(response.getEntity().getContent());
			logger.debug("Raw Output from REST Servie: " + rawOutput);
			
			
			output = Integer.valueOf(rawOutput);

			logger.debug("int Output from REST Servie: " + output);

		} catch (Exception e) {
			logger.debug("Exception received while connecting to rest service: ", e);
		} finally {
			if (httpClient != null && httpClient.getConnectionManager() != null) {
				httpClient.getConnectionManager().shutdown();
			}
		}
		return output;
	}

	public String getUserProfileJson() {

		DefaultHttpClient httpClient = new DefaultHttpClient();
		String output = null;
		try {

			// HttpGet httpGetRequest = new HttpGet("http://localhost:9090/spring-rest-service/rest/userprofiles");
			// HttpGet httpGetRequest = new HttpGet("http://localhost:2020/mule-esb/rest/userprofiles");
			HttpGet httpGetRequest = new HttpGet("http://localhost:2021/mule-esb/rest/userprofiles");

			httpGetRequest.addHeader("accept", "application/json");

			HttpResponse response = httpClient.execute(httpGetRequest);

			output = IOUtils.toString(response.getEntity().getContent());

			logger.debug("Raw Output from REST Servie: : \n");
			logger.debug(output);

		} catch (Exception e) {

			logger.debug("Exception received whileconnecting to rest service: ", e);

		} finally {

			if (httpClient != null && httpClient.getConnectionManager() != null) {
				httpClient.getConnectionManager().shutdown();
			}

		}
		return output;

	}
	
	public List<User_ProfileEntry> getAllUserProfiles() {

		List<User_ProfileEntry> userProfileList = null;

		try {

			String outputJsonString = getUserProfileJson();

			ObjectMapper mapper = new ObjectMapper();

			BdJsonResponse bdJsonResponse = mapper.readValue(outputJsonString, BdJsonResponse.class);

			if (bdJsonResponse != null && bdJsonResponse.getUserProfileResponse() != null) {
				userProfileList = bdJsonResponse.getUserProfileResponse().getUser_Profile();
			}

			logger.debug("BdJsonResponse : " + bdJsonResponse);

		} catch (Exception e) {
			logger.error("Exception received: ", e);
		}

		return userProfileList;

	}
	
	public String getUserProfileXmlToJsonTransformed() {

		DefaultHttpClient httpClient = new DefaultHttpClient();
		String output = null;
		try {

			HttpGet httpGetRequest = new HttpGet("http://localhost:2022/mule-esb/rest/userprofiles");

			httpGetRequest.addHeader("accept", "application/json");

			HttpResponse response = httpClient.execute(httpGetRequest);

			output = IOUtils.toString(response.getEntity().getContent());

			logger.debug("Raw Output from REST Servie: : \n");
			logger.debug(output);

		} catch (Exception e) {

			logger.debug("Exception received whileconnecting to rest service: ", e);

		} finally {

			if (httpClient != null && httpClient.getConnectionManager() != null) {
				httpClient.getConnectionManager().shutdown();
			}

		}
		return output;

	}

	public List<User_ProfileEntry> getAllUserProfilesXmlToJsonTransformed() {

		List<User_ProfileEntry> userProfileList = null;

		try {

			String outputJsonString = getUserProfileXmlToJsonTransformed();

			ObjectMapper mapper = new ObjectMapper();

			BdJsonResponse bdJsonResponse = mapper.readValue(outputJsonString, BdJsonResponse.class);

			if (bdJsonResponse != null && bdJsonResponse.getUserProfileResponse() != null) {
				userProfileList = bdJsonResponse.getUserProfileResponse().getUser_Profile();
			}

			logger.debug("BdJsonResponse : " + bdJsonResponse);

		} catch (Exception e) {
			logger.error("Exception received: ", e);
		}

		return userProfileList;

	}

	public static void main(String args[]) {
		UserProfileRestServiceClient userProfileRestServiceClient = new UserProfileRestServiceClient();

		try {

			List<User_ProfileEntry> userProfileList = userProfileRestServiceClient.getAllUserProfiles();

			logger.debug("userProfileList : " + userProfileList);

		} catch (Exception e) {
			logger.error("Exception received: ", e);
		}
	}

}
