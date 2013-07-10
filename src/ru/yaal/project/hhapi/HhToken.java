package ru.yaal.project.hhapi;

public class HhToken {
	private final String accessToken;
	private final String refreshToken;
	
	public HhToken(String accessToken, String refreshToken){
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
