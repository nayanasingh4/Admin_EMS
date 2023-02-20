package tech.stl.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import tech.stl.admin.entity.AdminConstant;
import tech.stl.admin.entity.Adminn;
import tech.stl.admin.repository.AdminRepository;
import tech.stl.admin.value.Employee;
import tech.stl.admin.value.Manager;


@Service
public class AdminService {
	
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private AdminRepository adminRepository;
	
	// find adminn by emailId
	public List<Adminn> getAdminnbyemailId(String emailId) {
		return this.adminRepository.findByemailId(emailId);
}
	
	public ResponseEntity<Employee> addemployee(Employee employee) {
		return restTemplate.postForEntity(AdminConstant.ADD_EMPLOYEE.getValue(),employee,Employee.class);

	}
	
	public ResponseEntity<Manager> addmanager(Manager manager) {
		return restTemplate.postForEntity(AdminConstant.ADD_MANAGER.getValue(),manager,Manager.class);

	}


	
	

}