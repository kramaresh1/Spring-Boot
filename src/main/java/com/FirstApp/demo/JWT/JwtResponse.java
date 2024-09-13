package com.FirstApp.demo.JWT;



public class JwtResponse {
	  private String jwtToken;
	  private String username;
	  private String message;
	  public JwtResponse(String jwtToken, String username, String responseMSG) {
		super();
		this.jwtToken = jwtToken;
		this.username = username;
		this.message = responseMSG;
	}
	public String getResponseMSG() {
		return message;
	}
	public void setResponseMSG(String responseMSG) {
		this.message = responseMSG;
	}
	public JwtResponse(String jwtToken, String username) {
		
		this.jwtToken = jwtToken;
		this.username = username;
	}
	public JwtResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JwtResponse(String msg) {
		this.message = msg;
	}
	public String getJwtToken() {
		return jwtToken;
	}
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
