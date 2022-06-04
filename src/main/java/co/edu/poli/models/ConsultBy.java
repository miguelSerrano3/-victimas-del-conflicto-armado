package co.edu.poli.models;

public class ConsultBy {
	
	private String type;
	private String valor;
	
	
	public ConsultBy() {
		
	}


	public ConsultBy(String type, String valor) {
		super();
		this.type = type;
		this.valor = valor;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getValor() {
		return valor;
	}


	public void setValor(String valor) {
		this.valor = valor;
	}
	
	
}
