package tech.stl.admin.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tech.stl.admin.entity.Adminn;
import tech.stl.admin.repository.AdminRepository;

@Service
@Transactional
public class UserService {
	@Autowired private AdminRepository adminRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	 

	public Adminn save(Adminn adminn) {
	        String rawPassword = adminn.getPassword();
	        String encodedPassword = passwordEncoder.encode(rawPassword);
	        adminn.setPassword(encodedPassword);
	        
	        return adminRepository.save(adminn);
	    }
}
