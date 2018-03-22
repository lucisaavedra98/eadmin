package es.fpdual.admin.eadmin.servicio.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import es.fpdual.admin.eadmin.modelo.Documento;
import es.fpdual.admin.eadmin.repositorio.RepositorioDocumento;
import es.fpdual.admin.eadmin.servicio.ServicioDocumento;

public class ServicioDocumentoImpl implements ServicioDocumento{
	
	RepositorioDocumento repositorioDocumento;
	
	@Autowired
	public ServicioDocumentoImpl (RepositorioDocumento repositorioDocumento) {
		this.repositorioDocumento = repositorioDocumento;
	}

	@Override
	public Documento altaDocumento(Documento documento) {
		final Documento documentoModificado = 
				ObtenerDocumentoConFechaCorrecta(documento);
		
		repositorioDocumento.altaDocumento(documentoModificado);	
		return documentoModificado;
	}

	@Override
	public Documento modificarDocumento(Documento documento) {
		final Documento documentoConUltimaFechaModificada =
				ObtenerDocumentoConUltimaFechaModificacion(documento);
		
		repositorioDocumento.modificarDocumento(documento);
		return documentoConUltimaFechaModificada;
	}

	@Override
	public void eliminarDocumento(int i) {
		repositorioDocumento.eliminarDocumento(i);			
	}
	
	protected Documento ObtenerDocumentoConFechaCorrecta(Documento documento) {
		return new Documento (documento.getCodigo(),
				documento.getNombre(),
				dameFechaActual(),
				null, documento.getPublico(),
				documento.getEstado()
				);
	}
	
	protected Documento ObtenerDocumentoConUltimaFechaModificacion(Documento documento) {
		return new Documento (documento.getCodigo(),
				documento.getNombre(),
				documento.getFechaCreacion(),
				dameFechaActual(),
				documento.getPublico(),
				documento.getEstado()
				);
	}
	protected Date dameFechaActual() {
		return new Date();
	}

}
