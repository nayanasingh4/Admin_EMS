package tech.stl.admin.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tech.stl.admin.entity.Adminn;
import tech.stl.admin.repository.AdminRepository;
import tech.stl.admin.util.JwtTokenUtil;


@RestController
public class AuthApi {
	
	@Autowired AuthenticationManager authManager;
    @Autowired JwtTokenUtil jwtUtil;
    
    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(), request.getPassword())
            );
            
            Adminn user = (Adminn) authentication.getPrincipal();
            String accessToken = jwtUtil.generateAccessToken(user);
            AuthResponse response = new AuthResponse(user.getEmailId(), accessToken);
            
            return ResponseEntity.ok().body(response);
            
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
    
    
    @Autowired AdminRepository adminRepository;
    @Autowired PasswordEncoder passwordEncoder;
    
    @PostMapping("/auth/signup/admin")
    public Adminn signin(@RequestBody Adminn adminn) {
        //patient.addRole(new Role(1,"Patient"));
        String rawPassword = adminn.getPassword();
        String encodedPassword = passwordEncoder.encode(rawPassword);
        adminn.setPassword(encodedPassword);
        adminRepository.save(adminn);
        return adminn;
    }

}