package es.fpdual.admin.eadmin.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class DocumentoContableTest {
	private static final Integer CODIGO_DOCUMENTO= 1;
	private static final String NOMBRE_DOCUMENTO = "nombre";
	private static final Date FECHA_CREACION= new Date();
	private static final boolean DOCUMENTO_PUBLICO= true;
	private static final BigDecimal DOCUMENTO_IMPORTE= new java.math.BigDecimal("0");
	private static final String DOCUMENTO_INTERESADO= "17481797A";
	
	DocumentoContable cont;
	
	@Before
	public void Inicializar() {
		cont = 
		new DocumentoContable (CODIGO_DOCUMENTO,NOMBRE_DOCUMENTO,FECHA_CREACION,
				DOCUMENTO_PUBLICO,EstadoDocumento.ACTIVO,DOCUMENTO_IMPORTE,DOCUMENTO_INTERESADO);
	}
	
	@Test
	public void DOCUMENTO_PUBLICO () {
		assertEquals (DOCUMENTO_IMPORTE,cont.getImporte());
		assertEquals (DOCUMENTO_INTERESADO,	cont.getNifInteresado());
	}
	
}

