package es.fpdual.admin.eadmin.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class DocumentoTest {
	
	/* Definimos una constante para cada atributo,para posteriormente compararlo
	con los parámetros que recibe el constructor cuando instanciamos un objeto */
	
	private static final Integer CODIGO_DOCUMENTO= 1;
	private static final String NOMBRE_DOCUMENTO = "nombre";
	private static final Date FECHA_CREACION= new Date();
	private static final Date FECHA_ULTIMA_MODIFICACION= new Date(4/12/2018);
	private static final boolean DOCUMENTO_PUBLICO= true;
	
	Documento doc;
	
	@Before
	public void Inicializar() {
		doc =
		new Documento (CODIGO_DOCUMENTO,NOMBRE_DOCUMENTO,FECHA_CREACION,
				FECHA_ULTIMA_MODIFICACION, DOCUMENTO_PUBLICO,EstadoDocumento.ACTIVO);
	}
	
	/*Método que compara parámetros por defecto guardados en constantes, con los parámetros que recoge el constructor */
	@Test
	public void DOCUMENTO_PUBLICO () {
		assertEquals (EstadoDocumento.ACTIVO,doc.getEstado());
		
	}
	
	@Test
	public void deberiaDevolverTrueSiTienenIgualCodigo() {
		final Documento doc2 = new Documento(CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO, null, null, null, null);
		final Boolean resultado = doc2.equals(doc);
		assertTrue(resultado);
	}
	
	@Test
	public void deberiaDevolverFalseSiNoTienenIgualCodigo() {
		final Documento doc2 = new Documento(5, null, null, null, null, null);

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
		final Documento doc3 = new Documento(CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO, null, null, null, null);
		final int resultado = doc.hashCode();
		assertEquals(resultado,doc3.hashCode());
	}
	
	@Test
	public void deberiaDevolverString () {
		assertNotNull(toString());
	}
}
