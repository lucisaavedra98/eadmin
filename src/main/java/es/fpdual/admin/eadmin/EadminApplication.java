package es.fpdual.admin.eadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class EadminApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EadminApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Esto es una prueba");
		LOGGER.debug("Depuracion");
		LOGGER.warn("Advertencia");
		LOGGER.error("Error");
		LOGGER.info("Inicio run");
		SpringApplication.run(EadminApplication.class, args);
		LOGGER.info("Fin run");
	}
}
