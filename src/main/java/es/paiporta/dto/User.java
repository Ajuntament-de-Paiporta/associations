package es.paiporta.dto;

public class User {
	private int id;
	private String email;
	private String password;
	private int rol;
	private String tokenId;
	private String tokenCreationTime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getRol() {
		return rol;
	}
	public void setRol(int rol) {
		this.rol = rol;
	}
	public String getTokenId() {
		return tokenId;
	}
	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}
	public String getTokenCreationTime() {
		return tokenCreationTime;
	}
	public void setTokenCreationTime(String tokenCreationTime) {
		this.tokenCreationTime = tokenCreationTime;
	}	
}
