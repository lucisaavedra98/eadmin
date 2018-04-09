package es.fpdual.admin.eadmin.servicio.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.fpdual.admin.eadmin.modelo.Documento;
import es.fpdual.admin.eadmin.repositorio.RepositorioDocumento;
import es.fpdual.admin.eadmin.servicio.ServicioDocumento;

public class ServicioDocumentoImplTest {
	
	private ServicioDocumentoImpl servicioDocumento;
	private static final Documento DOCUMENTO = mock (Documento.class);
	private final RepositorioDocumento repositorioDocumento= mock (RepositorioDocumento.class);
	
	
	@Before
	public void inicializarEnCadaTest() {
		//this.repositorioDocumento = new RepositorioDocumentoImpl();
		this.servicioDocumento = spy (new ServicioDocumentoImpl(repositorioDocumento));
	}
	
	@Test
	public void deberiaAlmacenarUnDocumento () {
		final Documento documentoModificado = mock (Documento.class);
		
		doReturn(documentoModificado).
		when(this.servicioDocumento).obtenerDocumentoConFechaCorrecta(DOCUMENTO);
		
		final Documento resultado = this.servicioDocumento.altaDocumento(DOCUMENTO);
		
		verify(this.repositorioDocumento).altaDocumento(documentoModificado);
		assertSame(resultado,documentoModificado);
	}

	@Test
	public void deberiaModificarUnDocumento() {
		final Documento documentoModificado = mock (Documento.class);
		
		doReturn(documentoModificado).
		when(this.servicioDocumento).obtenerDocumentoConUltimaFechaModificacion(DOCUMENTO);
		
		final Documento resultado = this.servicioDocumento.modificarDocumento(DOCUMENTO);
		
		verify(this.repositorioDocumento).modificarDocumento(documentoModificado);
		assertSame(resultado,documentoModificado);
	}
	
	@Test
	public void deberiaEliminarUnDocumento() {
		when(DOCUMENTO.getCodigo()).thenReturn(1);
		this.servicioDocumento.eliminarDocumento(DOCUMENTO.getCodigo());
		verify(this.repositorioDocumento).eliminarDocumento(1);
	}
	
	@Test
	public void deberiaObtenerDocumentoPorCodigo () {
		when(repositorioDocumento.obtenerDocumentoPorCodigo(1)).thenReturn (DOCUMENTO);
		final Documento resultado = servicioDocumento.obtenerDocumentoPorCodigo(1);
		assertSame(resultado,DOCUMENTO);
	}
	
	@Test
	public void deberiaObtenerTodosLosDocumentos () {
		final List<Documento> documentos2 = new ArrayList<>();
		when(repositorioDocumento.obtenerTodosLosDocumentos()).thenReturn(documentos2);
		final List <Documento> resultado = servicioDocumento.obtenerTodosLosDocumentos();
		assertSame(resultado,documentos2);
	}
	
}
