package tech.stl.admin.entity;

public class JwtResponse {

	private Adminn adminn;
	private String jwtToken;

	public Adminn getUser() {
		return adminn;
	}

	public void setUser(Adminn adminn) {
		this.adminn = adminn;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public JwtResponse(Adminn adminn, String jwtToken) {
		super();
		this.adminn = adminn;
		this.jwtToken = jwtToken;
	}

}
