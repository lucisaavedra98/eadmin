package es.fpdual.admin.eadmin.modelo;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class DocumentoPropuestaTest {
	private static final Integer CODIGO_DOCUMENTO= 1;
	private static final String NOMBRE_DOCUMENTO = "nombre";
	private static final Date FECHA_CREACION= new Date();
	private static final boolean DOCUMENTO_PUBLICO= true;
	private static final Integer COD_PROPUESTA_DOCUMENTO= 1;
	private static final Integer DOCUMENTO_EJERCICIO= 1;
	private static final String DOCUMENTO_PARTIDO= "IU";
	
		DocumentoPropuesta propuesta;
		
		@Before
		public void Inicializar() {
			propuesta = 
			new DocumentoPropuesta (CODIGO_DOCUMENTO,NOMBRE_DOCUMENTO,FECHA_CREACION,
					DOCUMENTO_PUBLICO,EstadoDocumento.ACTIVO,COD_PROPUESTA_DOCUMENTO,DOCUMENTO_EJERCICIO,DOCUMENTO_PARTIDO);
		}
		
		@Test
		public void DOCUMENTO_PUBLICO () {
			assertEquals (COD_PROPUESTA_DOCUMENTO,propuesta.getCodigoPropuesta());
			assertEquals (DOCUMENTO_EJERCICIO,	propuesta.getEjercicio());
			assertEquals (DOCUMENTO_PARTIDO,	propuesta.getGrupoPolitico());
		}
}
