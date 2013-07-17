package ru.yaal.project.hhapi.auth;

public class Token {
	private final String accessToken;
	private final String refreshToken;
	
	public Token(String accessToken, String refreshToken){
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

}
