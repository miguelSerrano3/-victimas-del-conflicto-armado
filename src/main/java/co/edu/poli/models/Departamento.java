package co.edu.poli.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Departamento")
public class Departamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_departamento;
	
	@Column(name="departamento_name")
	private String departamento_name;
	
	@OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
	@JsonIgnore
    private Set<City> city;
	
	public Departamento() {
		
	}

	public Departamento(Long id_departamento, String continente_name, Set<City> city) {
		super();
		this.id_departamento = id_departamento;
		this.departamento_name = continente_name;
		this.city = city;
	}

	public Long getId_departamento() {
		return id_departamento;
	}

	public void setId_departamento(Long id_departamento) {
		this.id_departamento = id_departamento;
	}

	public String getDepartamento_name() {
		return departamento_name;
	}

	public void setDepartamento_name(String continente_name) {
		this.departamento_name = continente_name;
	}

	public Set<City> getCity() {
		return city;
	}

	public void setCity(Set<City> city) {
		this.city = city;
	}

	
}
