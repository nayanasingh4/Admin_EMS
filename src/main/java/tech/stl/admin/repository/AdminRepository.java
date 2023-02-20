package tech.stl.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.stl.admin.entity.Adminn;


public interface AdminRepository extends JpaRepository<Adminn, Integer> {

	List<Adminn> findByemailId(String emailId);
	
	public Adminn findByEmailId(String emailId);

}