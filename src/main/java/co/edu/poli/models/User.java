package co.edu.poli.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_user;
	
	@Column(name="user_name")
	private String name;
	
	@Column(name="user_surname")
	private String apellido;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="rol")
	private String rol;
	
	@Column(name="barrio")
	private String barrio;
	
	@Column(name="address")
	private String direccion;
	
	@Column(name="ega")
	private int edad;
	
	@Column(name="date_of_birth")
	private String date_of_birth;
	
	@Column(name="document_type")
	private String document_type;
	
	@Column(name="document_number")
	private int document_number;
	
	@ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
	
	public User () {
		
	}

	public User(Long id_user, String name, String apellido, String email, String password, String rol, String barrio,
			String direccion, int edad, String date_of_birth, String document_type, int document_number, City city) {
		super();
		this.id_user = id_user;
		this.name = name;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.rol = rol;
		this.barrio = barrio;
		this.direccion = direccion;
		this.edad = edad;
		this.date_of_birth = date_of_birth;
		this.document_type = document_type;
		this.document_number = document_number;
		this.city = city;
	}

	public Long getId_user() {
		return id_user;
	}

	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getDocument_type() {
		return document_type;
	}

	public void setDocument_type(String document_type) {
		this.document_type = document_type;
	}

	public int getDocument_number() {
		return document_number;
	}

	public void setDocument_number(int document_number) {
		this.document_number = document_number;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	
}
