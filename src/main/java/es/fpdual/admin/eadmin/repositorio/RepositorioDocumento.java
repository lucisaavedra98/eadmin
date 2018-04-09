package es.fpdual.admin.eadmin.repositorio;

import java.util.List;

import es.fpdual.admin.eadmin.modelo.Documento;

public interface RepositorioDocumento {
	void altaDocumento (Documento documento);
	
	void modificarDocumento(Documento documento);
	
	void eliminarDocumento(Integer codigo);
	
	Documento obtenerDocumentoPorCodigo (Integer codigo);
	
	List <Documento>obtenerTodosLosDocumentos();
	
	void guardarDocumentosEnArchivoTexto();
	
	void escribirAltaDocumento(Documento documento);
	
	void escribirModificarDocumento(Documento documento);
	
	void escribirEliminarDocumento(Integer codigo);
	
}
