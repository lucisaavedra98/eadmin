package es.fpdual.admin.eadmin.servicio;

import es.fpdual.admin.eadmin.modelo.Expediente;

public interface ServicioExpediente {

	Expediente altaExpediente(Expediente expediente);
	
	Expediente modificarExpediente(Expediente expediente);
	
	void eliminarExpediente(Integer codigoExpediente);
	
	Expediente asociarDocumentoAlExpediente(Integer codigoExpediente);
	
	Expediente desasociarDocumentoAlExpediente(Integer codigoExpediente);
	
}
