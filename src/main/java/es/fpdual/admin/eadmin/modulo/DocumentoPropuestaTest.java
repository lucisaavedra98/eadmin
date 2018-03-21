package es.fpdual.admin.eadmin.modulo;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class DocumentoPropuestaTest {
	private static final Date FECHA_CREACION= new Date();
	private static final String NOMBRE_DOCUMENTO = "nombre";
	private static final boolean DOCUMENTO_PUBLICO= true;
	private static final Integer CODIGO_DOCUMENTO= 1;
	private static final Integer COD_CONTROL_DOCUMENTO= 1;
	private static final Integer EJERCICIO_DOCUMENTO= 1;
	private static final String GRUPO_DOCUMENTO= "IU";
	
	//Inicializamos el objeto para poder modificarlo
		DocumentoPropuesta propuesta;
		
		@Before
		public void Inicializar() {
			propuesta = 
			new DocumentoPropuesta (CODIGO_DOCUMENTO,COD_CONTROL_DOCUMENTO,GRUPO_DOCUMENTO);
		}
		
		@Test
		public void DOCUMENTO_PUBLICO () {
			assertEquals (COD_CONTROL_DOCUMENTO,propuesta.getCodigoPropuesta());
			assertEquals (EJERCICIO_DOCUMENTO,	propuesta.getEjercicio());
			assertEquals (GRUPO_DOCUMENTO,	propuesta.getGrupoPolitico());
		}
	
}
