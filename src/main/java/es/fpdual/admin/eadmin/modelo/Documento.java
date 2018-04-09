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

	@Override
	public String toString() {
		return "Documento con código "+codigo;
	}
		
	public String devolverDatos () {
		return "**************************************************************************"
				+ "\n Documento:" + this.getCodigo()
				+"\n Nombre:" + this.getNombre()
				+"\n Fecha de creación:" + this.getFechaCreacion()
				+"\n Fecha de última modificación:" + this.getFechaUltimaModificacion()
				+"\n Público:" + this.getPublico()
				+"\n Estado:" + this.getEstado()
				+"\n **************************************************************************";
	}

}
