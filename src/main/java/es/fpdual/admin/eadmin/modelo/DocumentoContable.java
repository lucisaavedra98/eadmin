package es.fpdual.admin.eadmin.modelo;

import java.math.BigDecimal;
import java.util.Date;

public class DocumentoContable extends Documento {
	//Atributos especificos de la clase Contable
	private BigDecimal importe;
	private String nifInteresado;
	
	//Constructor
	public DocumentoContable(Integer codigo, String nombre, Date fechaCreacion,Date fechaUltimaModificacion,Boolean publico, EstadoDocumento estado,
			BigDecimal importe, String nifInteresado) {
		super(codigo, nombre, fechaCreacion, fechaUltimaModificacion, publico, estado);
		this.importe = importe;
		this.nifInteresado = nifInteresado;
	}
	
	public BigDecimal getImporte() {
		return importe;
	}
	
	public String getNifInteresado() {
		return nifInteresado;
	}

	@Override
	public String toString() {
		return "DocumentoContable [importe=" + importe + ", nifInteresado=" + nifInteresado + "]";
	}

}
