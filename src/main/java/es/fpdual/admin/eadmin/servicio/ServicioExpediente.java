package es.fpdual.admin.eadmin.servicio;

import java.util.List;

import es.fpdual.admin.eadmin.modelo.Documento;
import es.fpdual.admin.eadmin.modelo.Expediente;

public interface ServicioExpediente {

	Expediente altaExpediente(Expediente expediente);
	
	Expediente modificarExpediente(Expediente expediente);
	
	void eliminarExpediente(Integer codigoExpediente);
	
	Expediente asociarDocumentoAlExpediente(Integer codigoExpediente,Documento documento);
	
	Expediente desasociarDocumentoAlExpediente(Integer codigoExpedientes,Integer codigoDocumento);
	
	Expediente obtenerExpedientePorCodigo (Integer codigo);
	
	List <Expediente> obtenerTodosLosExpedientes();
}

	

	
