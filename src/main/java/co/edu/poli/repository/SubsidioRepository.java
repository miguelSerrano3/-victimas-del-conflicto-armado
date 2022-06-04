package co.edu.poli.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.poli.models.Subsidios;
import co.edu.poli.models.User;

public interface SubsidioRepository extends JpaRepository<Subsidios, Long> {

	@Query (value="SELECT * FROM Subsidios",nativeQuery = true)
	Subsidios getSubsidios ();
	
	@Query (value="SELECT * FROM user WHERE ?1 = ?2",nativeQuery = true)
	List<Subsidios> getSubsidiosBy (String item, String valor);
}
