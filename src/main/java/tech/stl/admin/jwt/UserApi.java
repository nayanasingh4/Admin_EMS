package tech.stl.admin.jwt;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tech.stl.admin.entity.Adminn;
import tech.stl.admin.repository.AdminRepository;

@RestController
public class UserApi {
	
@Autowired private AdminRepository adminRepository;
    
    @PutMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody  Adminn adminn) {
    	Adminn createdUser = adminRepository.save(adminn);
        URI uri = URI.create("/users/" + createdUser.getAdminId());
        
        UserDto userDto = new UserDto (createdUser.getAdminId(), createdUser.getEmailId());
        
        return ResponseEntity.created(uri).body(userDto);
    }

}
