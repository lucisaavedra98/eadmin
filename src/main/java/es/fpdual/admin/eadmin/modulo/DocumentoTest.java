package es.fpdual.admin.eadmin.modulo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class DocumentoTest {
	
	/* Definimos una constante para cada atributo,para posteriormente compararlo
	con los parámetros que recibe el constructor cuando instanciamos un objeto */
	
	private static final Date FECHA_CREACION= new Date();
	private static final String NOMBRE_DOCUMENTO = "nombre";
	private static final boolean DOCUMENTO_PUBLICO= true;
	private static final Integer CODIGO_DOCUMENTO= 1;
	
	//Inicializamos el objeto para poder modificarlo
	Documento doc;
	
	@Before
	public void Inicializar() {
		doc =
		new Documento (CODIGO_DOCUMENTO,NOMBRE_DOCUMENTO,FECHA_CREACION,
				DOCUMENTO_PUBLICO,EstadoDocumento.ACTIVO);
	}
	
	/*Método que compara parámetros por defecto guardados en constantes, con los parámetros que recoge el constructor */
	@Test
	public void DOCUMENTO_PUBLICO () {
		assertEquals (CODIGO_DOCUMENTO,doc.getCodigo());
		assertEquals (NOMBRE_DOCUMENTO,doc.getNombre());
		assertEquals (FECHA_CREACION,doc.getFechaCreacion());
		assertEquals (DOCUMENTO_PUBLICO,doc.getPublico());
		assertEquals (EstadoDocumento.ACTIVO,doc.getEstado());
		
	}
	
	@Test
	public void deberiaDevolverTrueSiTienenIgualCodigo() {
		final Documento doc2 = new Documento(CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO, null, null, null);
		final Boolean resultado = doc2.equals(doc);
		assertTrue(resultado);
	}
	
	@Test
	public void deberiaDevolverFalseSiNoTienenIgualCodigo() {
		final Documento doc2 = new Documento(5, null, null, null, null);

		final Boolean resultado = doc2.equals(doc);
		assertFalse(resultado);
	}

	@Test
	public void deberiaDevolverFalseSiNoEsUnDocumento() {
		final boolean resultado = doc.equals(new Date());
		assertFalse(resultado);
	}
	
	@Test
	public void deberiaDevolverHasCodeDelCodigo () {
		final Documento doc3 = new Documento(CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO, null, null, null);
		final int resultado = doc.hashCode();
		assertEquals(resultado,doc3.hashCode());
	}
	
}
