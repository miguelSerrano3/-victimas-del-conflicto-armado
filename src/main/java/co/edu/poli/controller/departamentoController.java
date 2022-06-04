package co.edu.poli.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poli.models.Departamento;
import co.edu.poli.repository.DepartamentoRepository;
import io.swagger.annotations.Api;

@CrossOrigin(origins = "http://localhost:4200/")
@Api(tags = {"Class: departamentoController"}) //tag defined in SwaggerConfig.java
@RestController // Defines that this class is a spring bean
@RequestMapping("/api/v1/")
public class departamentoController {
	
	@Autowired
	private DepartamentoRepository departamentoRepository;

	@GetMapping("/departamentos")
	public List<Departamento> getDepartamento () {
		return departamentoRepository.findAll();
	}
	
	@GetMapping("/departamento/{id}")
	public Departamento getDepartamentoByID(@PathVariable int id) {
		Departamento  dept = departamentoRepository.getById(id);
		return dept;
	}
	
	@PostMapping("/departamento")
	public Departamento saveDepartamento (@RequestBody Departamento dept) {
		departamentoRepository.save(dept);	
		return dept;
	}
	
	@PostMapping("/departamentos")
	public String saveDepartamentos (@RequestBody List<Departamento> departamentosList) {
		departamentoRepository.saveAll(departamentosList);	
		return "done";
	}
	
	@PutMapping("/departamento/{idDepartamentos}")
	public Departamento updateDept(@PathVariable int idDepartamentos, @RequestBody Departamento departamento){
		
		Departamento dept = departamentoRepository.getById(idDepartamentos);
		
		dept.setDepartamento_name(departamento.getDepartamento_name());
		
		departamentoRepository.save(dept);
		return dept;
	}
}
