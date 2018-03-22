package es.fpdual.admin.eadmin.modelo;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import es.fpdual.admin.eadmin.repositorio.impl.RepositorioDocumentoImpl;

public class RepositorioDocumentoImplTest {
	
	private RepositorioDocumentoImpl repositorioDocumento;
	private static final Documento DOCUMENTO=new Documento (1,"prueba",new Date(),true,EstadoDocumento.ACTIVO);
	
	@Before
	public void InicializarEnCadaTest() {
		this.repositorioDocumento = new RepositorioDocumentoImpl();
	}
	
	@Test
	public void pruebaAlta () {		
		this.repositorioDocumento.altaDocumento(DOCUMENTO);
	}
	
	@Test
	public void pruebaAltaError () {		
		this.repositorioDocumento.altaDocumento(DOCUMENTO);
		this.repositorioDocumento.altaDocumento(DOCUMENTO);
	}
	
	@Test
	public void pruebaModificarDocumento () {
		this.repositorioDocumento.getDocumentos().add(DOCUMENTO);
		this.repositorioDocumento.modificarDocumento(DOCUMENTO);
	}
	
	@Test
	public void pruebaModificarDocumentoError () {
		this.repositorioDocumento.modificarDocumento(DOCUMENTO);
	}
	
	@Test
	public void pruebaEliminarDocumento () {
		this.repositorioDocumento.getDocumentos().add(DOCUMENTO);
		this.repositorioDocumento.eliminarDocumento(DOCUMENTO.getCodigo());
		assertTrue(this.repositorioDocumento.getDocumentos().isEmpty());
	}
	
	@Test
	public void pruebaEliminarDocumentoInexistente () {
		this.repositorioDocumento.eliminarDocumento(DOCUMENTO.getCodigo());
		assertTrue(this.repositorioDocumento.getDocumentos().isEmpty());
	}
}
