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
@Table(name="Subsidios")
public class Subsidios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_sub;
	
	@Column(name="nombre_subsidio")
	private String nombre_subsidio;
	
	@Column(name="capacidad")
	private String capacidad;
	
	@Column(name="tipo_subsidio")
	private String tipo_subsidio;
	
	@Column(name="Descripcion")
	private String Descripcion;

	public Subsidios(){
		
	}

	public Subsidios(Long id_sub, String nombre_subsidio, String capacidad, String tipo_subsidio, String descripcion) {
		super();
		this.id_sub = id_sub;
		this.nombre_subsidio = nombre_subsidio;
		this.capacidad = capacidad;
		this.tipo_subsidio = tipo_subsidio;
		Descripcion = descripcion;
	}

	public Long getId_sub() {
		return id_sub;
	}

	public void setId_sub(Long id_sub) {
		this.id_sub = id_sub;
	}

	public String getNombre_subsidio() {
		return nombre_subsidio;
	}

	public void setNombre_subsidio(String nombre_subsidio) {
		this.nombre_subsidio = nombre_subsidio;
	}

	public String getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}

	public String getTipo_subsidio() {
		return tipo_subsidio;
	}

	public void setTipo_subsidio(String tipo_subsidio) {
		this.tipo_subsidio = tipo_subsidio;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	
	
}