package es.fpdual.admin.eadmin.modelo;

import java.util.List;
import java.util.Date;

public class Expediente extends ModeloBaseAdministracionElectronica {

	private final Date fechaArchivado= null;
	private final EstadoExpediente estado;
	
	//creamos una lista de documentos
	private List<Documento> documentos;
	
	//Constructor
	public Expediente(Integer codigo, String nombre, Date fechaCreacion, Date fechaUltimaModificacion, Boolean publico,
			EstadoExpediente estado, List<Documento> documentos) {
		super(codigo, nombre, fechaCreacion, fechaUltimaModificacion, publico);
		this.estado = estado;
		this.documentos = documentos;
	}

	
	/*
	public void archivar() {
		if (fechaArchivado == null) {
			this.estado=EstadoExpediente.ARCHIVADO;
			this.fechaArchivado= new Date();
		}
	}
	*/	
	
	public Date getFechaArchivado() {
		return fechaArchivado;
	}

	public EstadoExpediente getEstado() {
		return estado;
	}

	public List<Documento> getDocumentos() {
		return documentos;
	}


	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}


	/*Para poder crear un expediente deben coincidir todos los campos, menos la lista*/
	@Override
	public int hashCode() {
		return codigo.hashCode() + nombre.hashCode()+ fechaCreacion.hashCode()+
				publico.hashCode()+estado.hashCode();
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Expediente) {
			return codigo.equals(((Expediente) obj).getCodigo()) && 
					nombre.equals(((Expediente) obj).getNombre()) &&  
					fechaCreacion.equals(((Expediente) obj).getFechaCreacion()) &&  
					publico.equals(((Expediente) obj).getPublico()) &&
					estado.equals(((Expediente) obj).getEstado());
		}
		return false;
	}
	
	

}
