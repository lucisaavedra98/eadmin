package es.fpdual.admin.eadmin.modulo;

public class DocumentoPropuesta {
	private Integer codigoPropuesta;
	private Integer ejercicio;
	private String grupoPolitico;
	
	//Constructor
	public DocumentoPropuesta(Integer codigoPropuesta, Integer ejercicio, String grupoPolitico) {
		super();
		this.codigoPropuesta = codigoPropuesta;
		this.ejercicio = ejercicio;
		this.grupoPolitico = grupoPolitico;
	}

	public Integer getCodigoPropuesta() {
		return codigoPropuesta;
	}

	public Integer getEjercicio() {
		return ejercicio;
	}

	public String getGrupoPolitico() {
		return grupoPolitico;
	}
	
	
}
