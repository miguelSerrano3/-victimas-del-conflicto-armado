package co.edu.poli.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poli.models.Login;
import co.edu.poli.models.User;
import co.edu.poli.repository.UserRepository;
import io.swagger.annotations.Api;

@CrossOrigin(origins = "http://localhost:4200/")
@Api(tags = {"Class: userController"}) //tag defined in SwaggerConfig.java
@RestController // Defines that this class is a spring bean
@RequestMapping("/api/v1/")
public class LoginController {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/login")
	public ResponseEntity<User> saveCity (@RequestBody Login user) {
		User userLogin = userRepository.getUserLogin(user.getEmail(),user.getPassword());
		System.out.println(userLogin.getId_user());
		
		if (userLogin.getEmail().equals(user.getEmail())) {
			System.out.println(userLogin.getEmail());
			
			return ResponseEntity.status(HttpStatus.OK).body(userLogin);
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);

		}
	}

}
