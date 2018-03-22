package es.fpdual.admin.eadmin.servicio;

import es.fpdual.admin.eadmin.modelo.Documento;

public interface ServicioDocumento {
	Documento altaDocumento(Documento documento);

	Documento modificarDocumento(Documento documento);

	void eliminarDocumento(int i);
}
