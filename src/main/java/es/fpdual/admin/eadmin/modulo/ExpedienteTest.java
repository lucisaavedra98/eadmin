package es.fpdual.admin.eadmin.modulo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class ExpedienteTest {
	private static final Integer CODIGO_EXPEDIENTE=1;
	private static final String NOMBRE_EXPEDIENTE= "nombre";
	private static final Date FECHA_CREACION = new Date();
	private static final Date FECHA_ARCHIVADO = null;
	private static final boolean EXPEDIENTE_PUBLICO = true;
	
	//Inicializamos el objeto para poder modificarlo
	Expediente exp;
	
	@Before
	public void Inicializar() {
		exp = 
		new Expediente (CODIGO_EXPEDIENTE,NOMBRE_EXPEDIENTE,FECHA_CREACION,
				EXPEDIENTE_PUBLICO,EstadoExpediente.INICIADO);
	}
	
	@Test
	public void DOCUMENTO_PUBLICO () {
		assertEquals (CODIGO_EXPEDIENTE,exp.getCodigo());
		assertEquals (NOMBRE_EXPEDIENTE,exp.getNombre());
		assertEquals (FECHA_CREACION,exp.getFechaCreacion());
		assertEquals (EXPEDIENTE_PUBLICO,exp.getPublico());
		assertEquals (EstadoExpediente.INICIADO,exp.getEstado());
	}
	
	@Test
	public void deberiaDevolverTrueSiTienenIgualCodigo() {
		final Expediente exp2 = new Expediente (CODIGO_EXPEDIENTE,NOMBRE_EXPEDIENTE,FECHA_CREACION
				,EXPEDIENTE_PUBLICO,EstadoExpediente.INICIADO);
		final boolean resultado = exp2.equals(exp);
		assertTrue(resultado);
	}
	
	@Test
	public void deberiaDevolverFalseSiNoTienenIgualCodigo() {
		final Expediente exp2 = new Expediente (2,null,null,null, null);
		final Boolean resultado = exp2.equals(exp);
		assertFalse(resultado);
	}
	
	@Test
	public void deberiaDevolverFalseSiNoEsUnExpediente () {
		final boolean resultado = exp.equals(new Date());
		assertFalse(resultado);
	}
	
	@Test
	public void deberiaDevolverHasCodeDelCodigo () {
		final Expediente exp2 = new Expediente (CODIGO_EXPEDIENTE,NOMBRE_EXPEDIENTE,FECHA_CREACION
				,EXPEDIENTE_PUBLICO,EstadoExpediente.INICIADO);
		final int resultado = exp.hashCode();
		assertEquals(resultado,exp2.hashCode());
	}
	
	
}
