package es.fpdual.admin.eadmin.repositorio;

import es.fpdual.admin.eadmin.modelo.Documento;

public interface RepositorioDocumento {
	void altaDocumento (Documento documento);
	
	void modificarDocumento(Documento documento);
	
	void eliminarDocumento(Integer codigo);
}
