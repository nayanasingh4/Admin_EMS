package tech.stl.admin.entity;

public enum AdminConstant {
	
	ADD_EMPLOYEE("http://localhost:2404/auth/signup/employee"),
	
	ADD_MANAGER("http://localhost:4424/auth/signup/manager");

	public String value;

	AdminConstant(String value) {

		this.value = value;

	}

	public String getValue() {
		return value;
	}

}