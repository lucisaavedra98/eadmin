package es.fpdual.admin.eadmin.servicio.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import es.fpdual.admin.eadmin.modelo.Documento;
import es.fpdual.admin.eadmin.repositorio.RepositorioDocumento;
import es.fpdual.admin.eadmin.servicio.ServicioDocumento;

public class ServicioDocumentoImplTest {
	
	private ServicioDocumento servicioDocumento;
	private static final Documento DOCUMENTO = mock (Documento.class);
	private final RepositorioDocumento repositorioDocumento= mock (RepositorioDocumento.class);
	
	
	@Before
	public void inicializarEnCadaTest() {
		//this.repositorioDocumento = new RepositorioDocumentoImpl();
		this.servicioDocumento = new ServicioDocumentoImpl(repositorioDocumento);
	}
	
	@Test
	public void deberiaAlmacenarUnDocumento () {
				
		when(DOCUMENTO.getCodigo()).thenReturn(1);
		when(DOCUMENTO.getNombre()).thenReturn("nombre");
		when(DOCUMENTO.getFechaCreacion()).thenReturn(new Date(1/1/2018));
		
		
		final Documento resultado = this.servicioDocumento.altaDocumento(DOCUMENTO);

		verify(this.repositorioDocumento).altaDocumento(any());
		assertEquals(Integer.valueOf(1),DOCUMENTO.getCodigo());
		assertEquals(resultado.getNombre(),DOCUMENTO.getNombre());
		assertNotEquals(resultado.getFechaCreacion(),DOCUMENTO.getFechaCreacion());
	}
	
	@Test
	public void deberiaModificarUnDocumento() {
		when(DOCUMENTO.getCodigo()).thenReturn(1);
		when(DOCUMENTO.getNombre()).thenReturn("nombre");
		when(DOCUMENTO.getFechaUltimaModificacion()).thenReturn(null);
		
		
		final Documento resultado = this.servicioDocumento.modificarDocumento(DOCUMENTO);

		verify(this.repositorioDocumento).modificarDocumento(any());
		assertEquals(Integer.valueOf(1),DOCUMENTO.getCodigo());
		assertEquals(resultado.getNombre(),DOCUMENTO.getNombre());
		assertNotEquals(resultado.getFechaUltimaModificacion(),DOCUMENTO.getFechaUltimaModificacion());
		
		/*
		this.servicioDocumento.modificarDocumento(DOCUMENTO);
		
		verify(this.repositorioDocumento).modificarDocumento(DOCUMENTO);*/
	}
	
	@Test
	public void deberiaEliminarUnDocumento() {
		when(DOCUMENTO.getCodigo()).thenReturn(1);
		this.servicioDocumento.eliminarDocumento(DOCUMENTO.getCodigo());
		verify(this.repositorioDocumento).eliminarDocumento(1);
	}
	
}
