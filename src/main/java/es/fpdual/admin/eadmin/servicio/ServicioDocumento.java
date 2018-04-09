package es.fpdual.admin.eadmin.servicio;

import java.util.List;

import es.fpdual.admin.eadmin.modelo.Documento;

public interface ServicioDocumento {
	Documento altaDocumento(Documento documento);

	Documento modificarDocumento(Documento documento);

	void eliminarDocumento(int i);
	
	Documento obtenerDocumentoPorCodigo (Integer codigo);
	
	List <Documento>obtenerTodosLosDocumentos();
}
