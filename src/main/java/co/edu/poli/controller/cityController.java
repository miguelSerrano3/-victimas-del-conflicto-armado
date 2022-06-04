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

import co.edu.poli.models.City;
import co.edu.poli.repository.CityRepository;
import io.swagger.annotations.Api;


@CrossOrigin(origins = "http://localhost:4200/")
@Api(tags = {"Class: cityController"}) //tag defined in SwaggerConfig.java
@RestController // Defines that this class is a spring bean
@RequestMapping("/api/v1/")
public class cityController {

	@Autowired
	private CityRepository cityRepository;

	@GetMapping("/City")
	public List<City> getCity () {
		return cityRepository.findAll();
	}
	
	@GetMapping("/city/{id}")
	public City getCityByID(@PathVariable int id) {
		City  city = cityRepository.getById(id);
		return city;
	}
	
	@PostMapping("/City")
	public City saveCity (@RequestBody City City) {
		cityRepository.save(City);	
		return City;
	}
	
	@PostMapping("/Citys")
	public String saveCity (@RequestBody List<City> cityList) {
		cityRepository.saveAll(cityList);	
		return "done";
	}
	
	@PutMapping("/City/{idCity}")
	public City updateCity(@PathVariable int idCity, @RequestBody City City){
		
		City _city = cityRepository.getById(idCity);
		
		_city.setCity_name(City.getCity_name());
		_city.setDepartamento(City.getDepartamento());
		
		cityRepository.save(_city);
		return _city;
	}
	
	
	//@uery
	
	@PostMapping("/CityByDept/{id_dept}")
	public List<City> getCityByDept (@PathVariable int id_dept) {
		return cityRepository.cityByDepartamento(id_dept);
	}
}
