package es.fpdual.eadmin.eadmin.controlador;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.fpdual.admin.eadmin.controlador.ControladorEadmin;
import es.fpdual.admin.eadmin.modelo.Documento;
import es.fpdual.admin.eadmin.modelo.EstadoDocumento;
import es.fpdual.admin.eadmin.servicio.ServicioDocumento;

public class ControladorEadminTest {
	private ControladorEadmin controlador;
	private final ServicioDocumento servicio = mock(ServicioDocumento.class);
	private static final Documento DOCUMENTO= mock (Documento.class);
	
	@Before
	public void inicializarEnCadaTest() {
		this.controlador = new ControladorEadmin(servicio);
	}
	
	@Test
	public void deberiaDevolverTodosLosDocumentos() {
		final List<Documento>documentos = new ArrayList<>();
		when(this.servicio.obtenerTodosLosDocumentos()).thenReturn(documentos);
		
		List<Documento>resultado=this.controlador.getTodosDocumentos().getBody();
		
		assertSame(documentos,resultado);
	}
		
	@Test
	public void deberiaDevolverDocumentoPorCodigo() {
		when(this.servicio.obtenerDocumentoPorCodigo(1)).thenReturn(DOCUMENTO);
		
		Documento otroDocumento = this.controlador.getDocumentoPorCodigo(1).getBody();
		
		assertSame(DOCUMENTO,otroDocumento);
	}
	
	@Test
	public void noDeberiaDevolverDocumentoPorCodigo() {
		when(this.servicio.obtenerDocumentoPorCodigo(1)).thenReturn(DOCUMENTO);
		ResponseEntity<Documento> otroDocumento = this.controlador.getDocumentoPorCodigo(1);
		
		verify(this.controlador.getDocumentoPorCodigo(DOCUMENTO.getCodigo()));
		
		assertSame(HttpStatus.NOT_FOUND,otroDocumento.getStatusCode());
	}
	
	@Test
	public void deberiaEliminarDocumento() {
		verify(this.controlador.eliminarDocumento(1));
		}
}
