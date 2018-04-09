package es.fpdual.admin.eadmin.repositorio;

import java.util.List;

import es.fpdual.admin.eadmin.modelo.Documento;
import es.fpdual.admin.eadmin.modelo.Expediente;

public interface RepositorioExpediente {
	
	void altaExpediente (Expediente expediente);
	
	void modificarExpediente(Expediente expediente);
	
	void eliminarExpediente(Integer codigo);
	
	Expediente asociarDocumentoAlExpediente(Integer codigoExpediente,Documento documento);
	
	Expediente desasociarDocumentoAlExpediente(Integer codigoExpediente,Integer codigoDocumento);

	Expediente obtenerExpedientePorCodigo (Integer codigo);
	
	List <Expediente>obtenerTodosLosExpedientes();
	
	void guardarExpedientesEnArchivoTexto();
	
	void escribirEnArchivoAltaExpediente (Expediente expediente);
	
	void escribirEnArchivoModificarExpediente(Expediente expediente);
	
	void escribirEnArchivoEliminarExpediente(Integer codigo);
}
