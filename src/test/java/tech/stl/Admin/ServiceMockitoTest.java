package tech.stl.Admin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import tech.stl.admin.entity.AdminConstant;
import tech.stl.admin.entity.Adminn;
import tech.stl.admin.repository.AdminRepository;
import tech.stl.admin.service.AdminService;
import tech.stl.admin.value.Employee;
import tech.stl.admin.value.Manager;

@SpringBootTest(classes= {ServiceMockitoTest.class})
public class ServiceMockitoTest {
	
	@Mock
    private AdminRepository adminRepository;
	
	@Mock
	private RestTemplate restTemplate;
	
    @InjectMocks
    private AdminService adminService;
    
    @Test
    public void test_addEmployee() {
    	Employee emp = new Employee(1, "Nikhil", "8787678767", 1, "nik@gmail.com","12345");
    	ResponseEntity response = new ResponseEntity<Employee>(emp, HttpStatus.OK);
    	when(restTemplate.postForEntity(AdminConstant.ADD_EMPLOYEE.getValue(),emp,Employee.class)).thenReturn(new ResponseEntity<Employee>(emp, HttpStatus.OK));
    	assertEquals(response, new ResponseEntity<Employee>(emp, HttpStatus.OK));
    }
    
    @Test
    public void test_addmanager() {
    	Manager manager = new Manager(1, "Nikhil", "8787678767", "nik@gmail.com","12345");
    	ResponseEntity response = new ResponseEntity<Manager>(manager, HttpStatus.OK);
    	when(restTemplate.postForEntity(AdminConstant.ADD_MANAGER.getValue(),manager,Manager.class)).thenReturn(new ResponseEntity<Manager>(manager, HttpStatus.OK));
    	assertEquals(response, new ResponseEntity<Manager>(manager, HttpStatus.OK));
    	
    }

}
