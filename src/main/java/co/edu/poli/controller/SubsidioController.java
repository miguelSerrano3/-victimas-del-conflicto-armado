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

import co.edu.poli.models.Subsidios;
import co.edu.poli.models.User;
import co.edu.poli.repository.SubsidioRepository;
import io.swagger.annotations.Api;

@CrossOrigin(origins = "http://localhost:4200/")
@Api(tags = {"Class: userController"}) //tag defined in SwaggerConfig.java
@RestController // Defines that this class is a spring bean
@RequestMapping("/api/v1/")
public class SubsidioController {

	@Autowired
	private SubsidioRepository subsidioRepository;

	@GetMapping("/Subsidios")
	public List<Subsidios> getSubsidios () {
		return subsidioRepository.findAll();
	}
	
	@PostMapping("/SubsidiosBy")
	public List<Subsidios> getSubsidiosBy (@RequestBody String type, String valor) {
		return subsidioRepository.getSubsidiosBy(type, valor);	
	}
	
	@PostMapping("/Subsidios")
	public Subsidios saveSubsidios (@RequestBody Subsidios sub) {
		subsidioRepository.save(sub);	
		return sub;
	}
	
	@DeleteMapping("/Subsidios/{id}")
	public ResponseEntity<Subsidios> deleteSubsidios(@PathVariable long id) {
		
		if (subsidioRepository.existsById(id)) {
			Subsidios sub = subsidioRepository.findById(id).get();
			subsidioRepository.delete(sub);
			return ResponseEntity.status(HttpStatus.OK).body(sub);
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);

		}
	}
	
	@PutMapping("/Subsidios/{id}")
	public ResponseEntity<Subsidios> updateBook(@PathVariable long id, @RequestBody Subsidios subsidiosUpdate) {
		
		if (subsidioRepository.existsById(id)) {
			Subsidios subsidios = subsidioRepository.findById(id).get();
			subsidios.setNombre_subsidio(subsidiosUpdate.getNombre_subsidio());
			subsidios.setCapacidad(subsidiosUpdate.getCapacidad());
			subsidios.setTipo_subsidio(subsidiosUpdate.getTipo_subsidio());
			subsidios.setDescripcion(subsidiosUpdate.getDescripcion());
			
			
			subsidioRepository.save(subsidios);
			return ResponseEntity.status(HttpStatus.OK).body(subsidios);
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);

		}
	}
}
