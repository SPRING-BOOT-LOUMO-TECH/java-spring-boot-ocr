package com.loumotech;

import net.sourceforge.tess4j.Tesseract;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavaSpringBootOcrApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringBootOcrApplication.class, args);
	}

	@Bean
	public Tesseract tesseract() {
		Tesseract tesseract = new Tesseract();
		tesseract.setDatapath("src/main/resources/tessdata");
		return tesseract;
	}

}
