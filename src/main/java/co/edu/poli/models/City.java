package co.edu.poli.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="City")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_city;
	
	@Column(name="city_name")
	private String city_name;
	
	@ManyToOne
    @JoinColumn(name = "departamento_ID")
    @JsonIgnore
    private Departamento departamento;
	
	@OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
	@JsonIgnore
    private Set<User> user;
	
	public City() {
		
	}

	public City(Long id_city, String city_name, Departamento departamento, Set<User> user) {
		super();
		this.id_city = id_city;
		this.city_name = city_name;
		this.departamento = departamento;
		this.user = user;
	}

	public Long getId_city() {
		return id_city;
	}

	public void setId_city(Long id_city) {
		this.id_city = id_city;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

	

	
}
