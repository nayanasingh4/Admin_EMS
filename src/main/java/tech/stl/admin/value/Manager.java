package tech.stl.admin.value;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Manager {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int managerId;
	
	private String managerName;
	
	private String phoneNumber;
	
	private String emailId;
	
	private String password;

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Manager(int managerId, String managerName, String phoneNumber, String emailId, String password) {
		super();
		this.managerId = managerId;
		this.managerName = managerName;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", managerName=" + managerName + ", phoneNumber=" + phoneNumber
				+ ", emailId=" + emailId + ", password=" + password + "]";
	}

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}