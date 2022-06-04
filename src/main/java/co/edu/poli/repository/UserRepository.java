package co.edu.poli.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.poli.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

	@Query (value="SELECT * FROM user WHERE email = ?1 and password = ?2",nativeQuery = true)
	User getUserLogin (String email, String pass);
	
	@Query (value="SELECT * FROM user WHERE rol = 'Subsidio'",nativeQuery = true)
	List<User> getUsers ();
	
	@Query (value="SELECT * FROM user WHERE document_number = ?1 and rol ='Subsidio'",nativeQuery = true)
	List<User> getUsersBydocument_number (int valor);
	
	@Query (value="SELECT * FROM user WHERE email = ?1 and rol ='Subsidio'",nativeQuery = true)
	List<User> getUsersByEmail(String valor);
}