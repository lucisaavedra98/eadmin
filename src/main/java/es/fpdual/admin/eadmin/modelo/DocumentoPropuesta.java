package es.fpdual.admin.eadmin.modelo;

import java.util.Date;

public class DocumentoPropuesta extends Documento {
	private final Integer codigoPropuesta;
	private final Integer ejercicio;
	private final String grupoPolitico;
	
	//Constructor
	public DocumentoPropuesta(Integer codigo, String nombre, Date fechaCreacion, Date fechaUltimaModificacion,
			Boolean publico, EstadoDocumento estado, Integer codigoPropuesta, Integer ejercicio, String grupoPolitico) {
		super(codigo, nombre, fechaCreacion, fechaUltimaModificacion, publico, estado);
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
