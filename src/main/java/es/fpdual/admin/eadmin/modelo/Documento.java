package es.fpdual.admin.eadmin.modelo;

import java.util.Date;

public class Documento extends ModeloBaseAdministracionElectronica {
	
	private final EstadoDocumento estado;

	public Documento(Integer codigo, String nombre, Date fechaCreacion, Date fechaUltimaModificacion,Boolean publico, EstadoDocumento estado) {
		super(codigo, nombre, fechaCreacion, fechaUltimaModificacion, publico);
		this.estado = estado;
	}
	
	public EstadoDocumento getEstado() {
		return estado;
	}

}
