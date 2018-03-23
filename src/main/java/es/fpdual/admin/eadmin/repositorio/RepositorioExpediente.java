package es.fpdual.admin.eadmin.repositorio;

import es.fpdual.admin.eadmin.modelo.Documento;
import es.fpdual.admin.eadmin.modelo.Expediente;

public interface RepositorioExpediente {
	
	void altaExpediente (Expediente expediente);
	
	void modificarExpediente(Expediente expediente);
	
	void eliminarExpediete(Integer codigo);
	
	void asociarDocumentoAlExpediente(Expediente expediente,Documento documento);
	
	void desasociarDocumentoAlExpediente(Expediente expediente,Documento documento);
}
