package co.edu.poli.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.poli.models.City;

public interface CityRepository extends JpaRepository<City, Integer>{

	@Query (value="SELECT city_name FROM city WHERE departamento_id = ?1",nativeQuery = true)
	List<City> cityByDepartamento (int id_dept);
}
