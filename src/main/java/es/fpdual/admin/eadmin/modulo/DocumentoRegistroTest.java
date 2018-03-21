package es.fpdual.admin.eadmin.modulo;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class DocumentoRegistroTest {
	private static final Date FECHA_CREACION= new Date();
	private static final String NOMBRE_DOCUMENTO = "nombre";
	private static final boolean DOCUMENTO_PUBLICO= true;
	private static final Integer CODIGO_DOCUMENTO= 1;
	private static final String DOCUMENTO_INTERESADO= "17481797A";
	private static final String DOCUMENTO_CONTROL= "12346";
	
	//Inicializamos el objeto para poder modificarlo
	DocumentoRegistro contable;
	
	@Before
	public void Inicializar() {
		contable = 
		new DocumentoRegistro (CODIGO_DOCUMENTO,NOMBRE_DOCUMENTO,FECHA_CREACION,
				DOCUMENTO_PUBLICO,EstadoDocumento.ACTIVO,DOCUMENTO_INTERESADO,DOCUMENTO_CONTROL);
	}
	
	@Test
	public void DOCUMENTO_PUBLICO () {
		assertEquals (DOCUMENTO_CONTROL,contable.getControlRegistro());
		assertEquals (DOCUMENTO_INTERESADO,	contable.getNifInteresado());
	}
	
}
