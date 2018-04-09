package es.fpdual.admin.eadmin.servicio.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.fpdual.admin.eadmin.modelo.Documento;
import es.fpdual.admin.eadmin.modelo.builder.DocumentoBuilder;
import es.fpdual.admin.eadmin.repositorio.RepositorioDocumento;
import es.fpdual.admin.eadmin.repositorio.impl.RepositorioDocumentoImpl;
import es.fpdual.admin.eadmin.servicio.ServicioDocumento;

@Service
public class ServicioDocumentoImpl implements ServicioDocumento{
	
	RepositorioDocumento repositorioDocumento;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ServicioDocumentoImpl.class);
	
	@Autowired
	public ServicioDocumentoImpl (RepositorioDocumento repositorioDocumento) {
		this.repositorioDocumento = repositorioDocumento;
	}

	@Override
	public Documento altaDocumento(Documento documento) {
		final Documento documentoModificado = 
				obtenerDocumentoConFechaCorrecta(documento);
		
		repositorioDocumento.altaDocumento(documentoModificado);	
		return documentoModificado;
	}

	@Override
	public Documento modificarDocumento(Documento documento) {
		final Documento documentoConUltimaFechaModificada =
				obtenerDocumentoConUltimaFechaModificacion(documento);
		
		repositorioDocumento.modificarDocumento(documentoConUltimaFechaModificada);
		return documentoConUltimaFechaModificada;
	}
	
	@Override
	public void eliminarDocumento(int i) {
		repositorioDocumento.eliminarDocumento(i);			
	}
	
	@Override
	public Documento obtenerDocumentoPorCodigo(Integer codigo) {
		final Documento resultado = repositorioDocumento.obtenerDocumentoPorCodigo(codigo);
		return resultado;
	}

	@Override
	public List<Documento> obtenerTodosLosDocumentos() {
		return repositorioDocumento.obtenerTodosLosDocumentos();
	}
	
	protected Documento obtenerDocumentoConFechaCorrecta(Documento documento) {
		/*return new Documento (documento.getCodigo(),
				documento.getNombre(),
				dameFechaActual(),
				null, documento.getPublico(),
				documento.getEstado()
				);*/
		
		/*return new DocumentoBuilder().
				conCodigo(documento.getCodigo()).
				conNombre(documento.getNombre()).
				conFechaCreacion(documento.getFechaCreacion()).
				conFechaUltimaModificacion(documento.getFechaUltimaModificacion()).
				conPublico(documento.getPublico()).
				conEstado(documento.getEstado()).
				build();*/
		
		return new DocumentoBuilder().
				clonar(documento).
				conFechaCreacion(dameFechaActual()).
				build();
	}
	
	protected Documento obtenerDocumentoConUltimaFechaModificacion(Documento documento) {
		/*return new Documento (documento.getCodigo(),
				documento.getNombre(),
				documento.getFechaCreacion(),
				dameFechaActual(),
				documento.getPublico(),
				documento.getEstado()
				);*/
		return new DocumentoBuilder().
				clonar(documento).
				conFechaUltimaModificacion(dameFechaActual()).
				build();
	}
	
	protected Date dameFechaActual() {
		return new Date();
	}


}
