package es.fpdual.admin.eadmin.repositorio.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import es.fpdual.admin.eadmin.EadminApplication;
import es.fpdual.admin.eadmin.modelo.Documento;
import es.fpdual.admin.eadmin.repositorio.RepositorioDocumento;

@Repository
public class RepositorioDocumentoImpl implements RepositorioDocumento {

	private static final Logger LOGGER = LoggerFactory.getLogger(RepositorioDocumentoImpl.class);

	private List<Documento> documentos = new ArrayList<>();

	public List<Documento> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}

	@Override
	public void altaDocumento(Documento documento) {
		LOGGER.info("Entrando al método " + Thread.currentThread().getStackTrace()[1].getMethodName());
		if (documentos.contains(documento)) {
			throw new IllegalArgumentException("El documento ya existe");
		}
		documentos.add(documento);
		LOGGER.info(documento.toString() + " se ha creado correctamente.");
		LOGGER.info("Salieno del método " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@Override
	public void modificarDocumento(Documento documento) {
		LOGGER.info("Entrando al método " + Thread.currentThread().getStackTrace()[1].getMethodName());
		if (!documentos.contains(documento)) {
			throw new IllegalArgumentException("El documento a modificar no existe");
		}
		documentos.set(documentos.indexOf(documento), documento);
		LOGGER.info(documento.toString() + " ha sido modificado correctamente.");
		LOGGER.info("Salieno del método " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@Override
	public void eliminarDocumento(Integer codigo) {
		LOGGER.info("Entrando al método " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Documento documentoEncontrado = documentos.stream().filter(d -> tieneIgualCodigo(d, codigo)).findFirst()
				.orElseGet(null);

		/*
		 * Documento documentoEncontrado = documentos.stream(). filter(d->
		 * d.getCodigo().equals(codigo)). findFirst().orElseGet(null);
		 * 
		 * OPCION NO VIABLE Documento documentoEncontrado = null;
		 * 
		 * for (int i=0; i < documentos.size();i++) { if
		 * (documentos.get(i).getCodigo().equals(codigo)) { documentoEncontrado =
		 * documentos.get(i); break; } }
		 */

		if (Objects.nonNull(documentoEncontrado)) {
			documentos.remove(documentoEncontrado);
			LOGGER.info(documentoEncontrado.toString() + " ha sido eliminado correctamente.");
		}
		LOGGER.info("Salieno del método " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@Override
	public Documento obtenerDocumentoPorCodigo(Integer codigo) {
		LOGGER.info("Entrando al método " + Thread.currentThread().getStackTrace()[1].getMethodName());
		LOGGER.info("LOCALIZANDO DOCUMENTO POR CÓDIGO:");
		Optional<Documento> documentoEncontrado = documentos.stream().filter(d -> tieneIgualCodigo(d, codigo))
				.findFirst();

		if (documentoEncontrado.isPresent()) {
			LOGGER.info("DOCUMENTO ENCONTRADO:");
			LOGGER.info("**************************************************************************");
			LOGGER.info("Documento:" + documentoEncontrado.get().getCodigo());
			LOGGER.info("Nombre:" + documentoEncontrado.get().getNombre());
			LOGGER.info("Fecha de creación:" + documentoEncontrado.get().getFechaCreacion());
			LOGGER.info("Fecha de última modificación:" + documentoEncontrado.get().getFechaUltimaModificacion());
			LOGGER.info("Público:" + documentoEncontrado.get().getPublico());
			LOGGER.info("Estado:" + documentoEncontrado.get().getEstado());
			LOGGER.info("**************************************************************************");
			LOGGER.info("Salieno del método " + Thread.currentThread().getStackTrace()[1].getMethodName());
			return documentoEncontrado.get();
		}

		LOGGER.info("Salieno del método " + Thread.currentThread().getStackTrace()[1].getMethodName());
		return null;
	}

	@Override
	public List<Documento> obtenerTodosLosDocumentos() {
		LOGGER.info("Entrando al método " + Thread.currentThread().getStackTrace()[1].getMethodName());
		LOGGER.info("MOSTRANDO TODOS LOS DOCUMENTOS:");
		LOGGER.info("");
		LOGGER.info("**************************************************************************");
		for (Documento documento : documentos) {
			LOGGER.info("Documento:" + documento.getCodigo());
			LOGGER.info("Nombre:" + documento.getNombre());
			LOGGER.info("Fecha de creación:" + documento.getFechaCreacion());
			LOGGER.info("Fecha de última modificación:" + documento.getFechaUltimaModificacion());
			LOGGER.info("Público:" + documento.getPublico());
			LOGGER.info("Estado:" + documento.getEstado());
			LOGGER.info("");
			LOGGER.info("**************************************************************************");

		}
		LOGGER.info("TODOS LOS DOCUMENTOS LISTADOS");
		LOGGER.info("FIN");
		LOGGER.info("Salieno del método " + Thread.currentThread().getStackTrace()[1].getMethodName());
		return documentos;
	}

	public void guardarDocumentosEnArchivoTexto() {
		LOGGER.info("Entrando al método " + Thread.currentThread().getStackTrace()[1].getMethodName());

		String ruta = "ListaDeTodosLosDocumentos.txt";
		File archivo = new File(ruta);
		FileWriter file = null;
		PrintWriter pw = null;

		System.out.println("INICIANDO");

		LOGGER.info("Iniciando escritura de fichero...");
		if (archivo.exists()) {
			LOGGER.info("Modificando fichero existente...");
		}

		else {
			LOGGER.info("Creando fichero nuevo...");
		}

		try {
			file = new FileWriter(ruta, true);
			pw = new PrintWriter(file);

			for (Documento documento : documentos) {
				pw.println(documento.devolverDatos());
			}

			pw.println("++++++++++++++++++++++++++++++++++++++++++++++++");
			pw.close();
			LOGGER.info("Fin escritura de fichero...");
		} catch (IOException e) {
			e.printStackTrace();
			pw.close();
			LOGGER.info("Fin escritura de fichero...");
		}
		LOGGER.info("Salieno del método " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@Override
	public void escribirAltaDocumento(Documento documento) {
		LOGGER.info("Entrando al método " + Thread.currentThread().getStackTrace()[1].getMethodName());
		if (documentos.contains(documento)) {
			throw new IllegalArgumentException("El documento ya existe");
		}

		else {
			documentos.add(documento);
			exportExcel("Alta",documento, Thread.currentThread().getStackTrace()[1].getMethodName()+".xlsx");
			LOGGER.info(documento.toString() + " se ha creado correctamente.");

			System.out.println("INICIANDO ESCRITURA EN ALTA..");
			LOGGER.info("Iniciando escritura de fichero...");

			String ruta = "AltaDocumento.txt";
			File archivo = new File(ruta);
			FileWriter file = null;
			PrintWriter pw = null;

			if (archivo.exists()) {
				LOGGER.info("Modificando fichero existente...");
			}

			else {
				LOGGER.info("Creando fichero nuevo...");
			}
			try {
				file = new FileWriter(ruta, true);
				pw = new PrintWriter(file);
				pw.println(documento.devolverDatos());
				pw.close();
				LOGGER.info("Fin escritura de fichero...");
			} catch (IOException e) {
				e.printStackTrace();
				pw.close();
				LOGGER.info("Fin escritura de fichero...");
			}
		}
		LOGGER.info("Salieno del método " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public void escribirModificarDocumento(Documento documento) {
		LOGGER.info("Entrando al método " + Thread.currentThread().getStackTrace()[1].getMethodName());
		if (!documentos.contains(documento)) {
			throw new IllegalArgumentException("El documento a modificar no existe");
		}

		else {
			documentos.set(documentos.indexOf(documento), documento);
			exportExcel("Modificar",documento, Thread.currentThread().getStackTrace()[1].getMethodName()+".xlsx");
			LOGGER.info(documento.toString() + " ha sido modificado correctamente.");

			System.out.println("INICIANDO ESCRITURA EN MODIFICACIÓN..");
			LOGGER.info("Iniciando escritura de fichero...");

			String ruta = "ModificarDocumento.txt";
			File archivo = new File(ruta);
			FileWriter file = null;
			PrintWriter pw = null;

			if (archivo.exists()) {
				LOGGER.info("Modificando fichero existente...");
			}

			else {
				LOGGER.info("Creando fichero nuevo...");
			}
			try {
				file = new FileWriter(ruta, true);
				pw = new PrintWriter(file);
				pw.println(documento.devolverDatos());
				pw.close();
				LOGGER.info("Fin escritura de fichero...");
			} catch (IOException e) {
				e.printStackTrace();
				pw.close();
				LOGGER.info("Fin escritura de fichero...");
			}

		}
		LOGGER.info("Salieno del método " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@Override
	public void escribirEliminarDocumento(Integer codigo) {
		LOGGER.info("Entrando al método " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Documento documentoEncontrado = documentos.stream().filter(d -> tieneIgualCodigo(d, codigo)).findFirst()
				.orElseGet(null);

		if (Objects.nonNull(documentoEncontrado)) {
			documentos.remove(documentoEncontrado);
			exportExcel("Eliminar",documentoEncontrado, Thread.currentThread().getStackTrace()[1].getMethodName()+".xlsx");
			LOGGER.info(documentoEncontrado.toString() + " ha sido eliminado correctamente.");

			System.out.println("INICIANDO ESCRITURA EN ELIMINAR..");
			LOGGER.info("Iniciando escritura de fichero...");

			String ruta = "EliminarDocumento.txt";
			File archivo = new File(ruta);
			FileWriter file = null;
			PrintWriter pw = null;

			if (archivo.exists()) {
				LOGGER.info("Modificando fichero existente...");
			}

			else {
				LOGGER.info("Creando fichero nuevo...");
			}
			try {
				file = new FileWriter(ruta, true);
				pw = new PrintWriter(file);
				pw.println(documentoEncontrado.devolverDatos());
				pw.close();
				LOGGER.info("Fin escritura de fichero...");
			} catch (IOException e) {
				e.printStackTrace();
				pw.close();
				LOGGER.info("Fin escritura de fichero...");
			}
		}

		LOGGER.info("Salieno del método " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public static boolean exportExcel(String nombreHoja, Documento documento, String fileName) {
		Map<String, Object[]> documentos = new TreeMap<String, Object[]>();
		Integer numeroLineas = 0;

		File archivoExcel = new File(fileName);
		if (!archivoExcel.exists()) {
			documentos.put("0", new Object[] { "ID", "Nombre", "Fecha Creación", "Fecha Última Modificación", "Público","Estado" });
			numeroLineas++;
		} else {
			ArrayList<String[]> datosExcel = importExcel(fileName, 6);
			ListIterator<String[]> it = datosExcel.listIterator();

			while (it.hasNext()) {
				numeroLineas++;
				String[] datos = it.next();
				documentos.put(numeroLineas.toString(), datos);
			}
		}

		numeroLineas++;
		documentos.put(numeroLineas.toString(),
				new Object[] { documento.getCodigo(), documento.getNombre(), documento.getFechaCreacion().toString(),
						documento.getFechaUltimaModificacion().toString(), documento.getPublico().toString(),
						documento.getEstado() + "" });

		// Creamos el libro de trabajo
		XSSFWorkbook libro = new XSSFWorkbook();

		// Creacion de Hoja
		XSSFSheet hoja = libro.createSheet(nombreHoja);

		// Iteramos el map e insertamos los datos
		Set<String> keyset = documentos.keySet();
		int rownum = 0;
		for (String key : keyset) {
			// cramos la fila
			Row row = hoja.createRow(rownum++);
			// obtenemos los datos de la fila
			Object[] objArr = documentos.get(key);
			int cellnum = 0;
			// iteramos cada dato de la fila
			for (Object obj : objArr) {
				// Creamos la celda
				Cell cell = row.createCell(cellnum++);
				// Setteamos el valor con el tipo de dato correspondiente
				if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Integer)
					cell.setCellValue((Integer) obj);
			}
		}
		try {
			// Escribimos en fichero
			FileOutputStream out = new FileOutputStream(new File(fileName));
			libro.write(out);
			// cerramos el fichero y el libro
			out.close();
			libro.close();
			System.out.println("Excel exportado correctamente\n");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean exportarExcelEnUnSoloArchivo (String nombreHoja, Documento documento, String fileName) {
		
		Map<String, Object[]> documentos = new TreeMap<String, Object[]>();
		Integer numeroLineas = 0;

		File archivoExcel = new File(fileName);
		if (!archivoExcel.exists()) {
			documentos.put("0", new Object[] { "ID", "Nombre", "Fecha Creación", "Fecha Última Modificación", "Público","Estado" });
			numeroLineas++;
		} else {
			ArrayList<String[]> datosExcel = importExcel(fileName, 6);
			ListIterator<String[]> it = datosExcel.listIterator();

			while (it.hasNext()) {
				numeroLineas++;
				String[] datos = it.next();
				documentos.put(numeroLineas.toString(), datos);
			}
		}

		numeroLineas++;
		documentos.put(numeroLineas.toString(),
				new Object[] { documento.getCodigo(), documento.getNombre(), documento.getFechaCreacion().toString(),
						documento.getFechaUltimaModificacion().toString(), documento.getPublico().toString(),
						documento.getEstado() + "" });
		
		// Creamos el libro de trabajo
		XSSFWorkbook libro = new XSSFWorkbook();
		/*
		// Creacion de Hoja
		if (libro.getSheetAt(0) == null) {
		XSSFSheet hoja = libro.createSheet(nombreHoja);
		}
		*/

		XSSFSheet hoja = libro.createSheet(nombreHoja);
		
		// Iteramos el map e insertamos los datos
		Set<String> keyset = documentos.keySet();
		int rownum = 0;
		for (String key : keyset) {
			// cramos la fila
			Row row= hoja.createRow(rownum++);
			// obtenemos los datos de la fila
			Object[] objArr = documentos.get(key);
			int cellnum = 0;
			// iteramos cada dato de la fila
			for (Object obj : objArr) {
				// Creamos la celda
				Cell cell = row.createCell(cellnum++);
				// Setteamos el valor con el tipo de dato correspondiente
				if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Integer)
					cell.setCellValue((Integer) obj);
			}
		}
		try {
			// Escribimos en fichero
			FileOutputStream out = new FileOutputStream(new File(fileName));
			libro.write(out);			
			// cerramos el fichero y el libro
			out.close();
			libro.close();
			System.out.println("Excel exportado correctamente\n");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static ArrayList<String[]> importExcel(String fileName, int numColums) {

		// ArrayList donde guardaremos todos los datos del excel
		ArrayList<String[]> data = new ArrayList<>();

		try {
			// Acceso al fichero xlsx
			FileInputStream file = new FileInputStream(new File(fileName));

			// Creamos la referencia al libro del directorio dado
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Obtenemos la primera hoja
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Iterador de filas
			Iterator<Row> rowIterator = sheet.iterator();

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				// Iterador de celdas
				Iterator<Cell> cellIterator = row.cellIterator();
				// contador para el array donde guardamos los datos de cada fila
				int contador = 0;
				// Array para guardar los datos de cada fila
				// y añadirlo al ArrayList
				String[] fila = new String[numColums];
				// iteramos las celdas de la fila
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

					// Guardamos los datos de la celda segun su tipo
					switch (cell.getCellType()) {
					// si es numerico
					case Cell.CELL_TYPE_NUMERIC:
						fila[contador] = (int) cell.getNumericCellValue() + "";
						break;
					// si es cadena de texto
					case Cell.CELL_TYPE_STRING:
						fila[contador] = cell.getStringCellValue() + "";
						break;
					}
					// Si hemos terminado con la ultima celda de la fila
					if ((contador + 1) % numColums == 0) {
						// Añadimos la fila al ArrayList con todos los datos
						data.add(fila);
					}
					// Incrementamos el contador
					// con cada fila terminada al redeclarar arriba el contador,
					// no obtenemos excepciones de ArrayIndexOfBounds
					contador++;
				}
			}
			// Cerramos el fichero y workbook
			file.close();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Excel importado correctamente\n");

		return data;
	}
	
	protected boolean tieneIgualCodigo(Documento documento, Integer codigo) {
		return documento.getCodigo().equals(codigo);
	}

}
