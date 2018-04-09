package es.fpdual.admin.eadmin.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class ModeloBaseAdministracionElectronicaTest {
	
	class ModeloBaseAdministracionElectronicaFake extends ModeloBaseAdministracionElectronica {
		//Constructor
		public ModeloBaseAdministracionElectronicaFake(Integer codigo, String nombre, Date fechaCreacion,
				Date fechaUltimaModificacion, Boolean publico) {
			super(codigo, nombre, fechaCreacion, fechaCreacion, publico);
			// TODO Auto-generated constructor stub
		}		
		
	}
	
	private static final Integer CODIGO_DOCUMENTO= 1;
	private static final String NOMBRE_DOCUMENTO = "nombre";
	private static final Date FECHA_CREACION= new Date();
	private static final Date FECHA_ULTIMA_MODIFICACION= new Date();
	private static final boolean DOCUMENTO_PUBLICO= true;
	
	
	//Inicializamos el objeto para poder modificarlo
	ModeloBaseAdministracionElectronicaFake modelo;
	
	@Before
	public void Inicializar() {
		modelo =
		new ModeloBaseAdministracionElectronicaFake (CODIGO_DOCUMENTO,NOMBRE_DOCUMENTO,FECHA_CREACION,
				FECHA_ULTIMA_MODIFICACION,DOCUMENTO_PUBLICO);
	}
	
	/*Método que compara parámetros por defecto guardados en constantes, con los parámetros que recoge el constructor */
	@Test
	public void DOCUMENTO_PUBLICO () {
		assertEquals (CODIGO_DOCUMENTO,modelo.getCodigo());
		assertEquals (NOMBRE_DOCUMENTO,modelo.getNombre());
		assertEquals (FECHA_CREACION,modelo.getFechaCreacion());
		assertEquals (FECHA_ULTIMA_MODIFICACION,modelo.getFechaUltimaModificacion());
		assertEquals (DOCUMENTO_PUBLICO,modelo.getPublico());
	}
	
	@Test
	public void deberiaDevolverTrueSiTienenIgualCodigo() {
		final ModeloBaseAdministracionElectronicaFake modelo2 = new ModeloBaseAdministracionElectronicaFake (CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO, null, null, null);
		final Boolean resultado = modelo2.equals(modelo);
		assertTrue(resultado);
	}
	
	@Test
	public void deberiaDevolverFalseSiNoTienenIgualCodigo() {
		final ModeloBaseAdministracionElectronicaFake modelo2 = new ModeloBaseAdministracionElectronicaFake(5, null, null, null, null);

		final Boolean resultado = modelo2.equals(modelo);
		assertFalse(resultado);
	}

	@Test
	public void deberiaDevolverFalseSiNoEsUnDocumento() {
		final boolean resultado = modelo.equals(new Date());
		assertFalse(resultado);
	}
	
	@Test
	public void deberiaDevolverHasCodeDelCodigo () {
		final ModeloBaseAdministracionElectronicaFake modelo3 = new ModeloBaseAdministracionElectronicaFake (CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO, null, null, null );
		final int resultado = modelo.hashCode();
		assertEquals(resultado,modelo3.hashCode());
	}
	
	@Test
	public void deberiaDevolverString () {
		assertNotNull(toString());
	}
}
