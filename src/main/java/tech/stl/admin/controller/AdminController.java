package tech.stl.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



import tech.stl.admin.entity.Adminn;
import tech.stl.admin.exception.ResourceNotFoundException;
import tech.stl.admin.service.AdminService;
import tech.stl.admin.value.Employee;
import tech.stl.admin.value.Manager;


@RestController
@CrossOrigin
public class AdminController {
	
	@Autowired
	public AdminService adminService;
	
	@GetMapping("/admin/emailid/{emailId}") 
	public ResponseEntity<List<Adminn>> getByEmailId(@PathVariable("emailId") String emailId)  {
		List<Adminn> list = adminService.getAdminnbyemailId(emailId);
		if (list.size() <= 0) {
			throw new ResourceNotFoundException("No Admin present in the list with the given emailId");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	
	@PostMapping("/employee")
    public ResponseEntity<Employee> addEmployee( @RequestBody Employee employee){
    	return this.adminService.addemployee(employee);
    }
	
	@PostMapping("/manager")
    public ResponseEntity<Manager> addManager( @RequestBody Manager manager){
    	return this.adminService.addmanager(manager);
    }


}

