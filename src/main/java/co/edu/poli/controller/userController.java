package co.edu.poli.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poli.models.ConsultBy;
import co.edu.poli.models.Mail;
import co.edu.poli.models.User;
import co.edu.poli.repository.MailService;
import co.edu.poli.repository.UserRepository;
import io.swagger.annotations.Api;


@CrossOrigin(origins = "http://localhost:4200/")
@Api(tags = {"Class: userController"}) //tag defined in SwaggerConfig.java
@RestController // Defines that this class is a spring bean
@RequestMapping("/api/v1/")
public class userController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MailService notificationService;
	
	@GetMapping("/users")
	public List<User> getUsers () {
		return userRepository.getUsers();
	}
	
	@PostMapping("/UserBy")
	public List<User> getUserBy (@RequestBody ConsultBy consulta) {
		if(consulta.getType().equals("email") ) {
			return userRepository.getUsersByEmail(consulta.getValor());
		}
		if (consulta.getType().equals("document_number")) {
			return userRepository.getUsersBydocument_number(Integer.parseInt(consulta.getValor()));
		}
		return userRepository.getUsers();
			
	}
	
	@PostMapping("/User")
	public User saveUser (@RequestBody User user) {
		userRepository.save(user);
		return user;
	}
	
	@DeleteMapping("/User/{id}")
	public ResponseEntity<User> deletePerson(@PathVariable long id) {
		
		if (userRepository.existsById(id)) {
			User user = userRepository.findById(id).get();
			userRepository.delete(user);
			return ResponseEntity.status(HttpStatus.OK).body(user);
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);

		}
	}
	
	@PutMapping("/User/{id}")
	public ResponseEntity<User> updateBook(@PathVariable long id, @RequestBody User userNew) {
		
		if (userRepository.existsById(id)) {
			User user = userRepository.findById(id).get();
			user.setName(userNew.getName());
			user.setApellido(userNew.getApellido());
			user.setEmail(userNew.getEmail());
			user.setPassword(userNew.getPassword());
			user.setRol(userNew.getRol());
			user.setBarrio(userNew.getBarrio());
			user.setDireccion(userNew.getDireccion());
			user.setEdad(userNew.getEdad());
			user.setDate_of_birth(userNew.getDate_of_birth());
			user.setDocument_type(userNew.getDocument_type());
			user.setDocument_number(userNew.getDocument_number());
			user.setCity(userNew.getCity());			
			
			userRepository.save(user);
			return ResponseEntity.status(HttpStatus.OK).body(user);
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);

		}
	}
}
