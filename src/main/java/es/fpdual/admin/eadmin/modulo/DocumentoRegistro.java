package es.fpdual.admin.eadmin.modulo;

import java.util.Date;

public class DocumentoRegistro extends Documento{
	private String nifInteresado;
	private String controlRegistro;
	
	//Constructor
	public DocumentoRegistro(Integer codigo, String nombre, Date fechaCreacion, Boolean publico, EstadoDocumento estado,
			String nifInteresado, String controlRegistro) {
		super(codigo, nombre, fechaCreacion, publico, estado);
		this.nifInteresado = nifInteresado;
		this.controlRegistro = controlRegistro;
	}

	public String getNifInteresado() {
		return nifInteresado;
	}

	public String getControlRegistro() {
		return controlRegistro;
	}
	
}
