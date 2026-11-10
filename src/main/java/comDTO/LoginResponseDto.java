package comDTO;

public class LoginResponseDto {

	private String token;
    private String tokenType;
    
	public String getToken() {
		return token;
	}
	public LoginResponseDto() {
		super();
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getTokenType() {
		return tokenType;
	}
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	} 
}
