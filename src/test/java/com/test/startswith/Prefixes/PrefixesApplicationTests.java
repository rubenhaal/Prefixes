package com.test.startswith.Prefixes;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@SpringBootTest
class PrefixesApplicationTests {

	@Test
	void contextLoads() {
		int numCombinaciones = 10000;  // Número de combinaciones únicas
		int longitudPalabra = 6;       // Longitud de cada combinación
		String archivoSalida = "combinaciones.txt";
		Set<String> combinaciones = generarCombinacionesUnicas(numCombinaciones, longitudPalabra);

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoSalida))) {
			for (String combinacion : combinaciones) {
				writer.write(combinacion);
				writer.newLine();
			}
			System.out.println("Archivo '" + archivoSalida + "' creado con " + numCombinaciones + " combinaciones únicas de longitud " + longitudPalabra + ".");
			System.out.println(new java.io.File("combinaciones.txt").getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	Set<String> generarCombinacionesUnicas(int numCombinaciones, int longitudPalabra) {
		Set<String> combinaciones = new HashSet<>();
		Random random = new Random();

		while (combinaciones.size() < numCombinaciones) {
			StringBuilder combinacion = new StringBuilder();
			for (int i = 0; i < longitudPalabra; i++) {
				char letra = (char) ('a' + random.nextInt(26));  // Genera una letra aleatoria entre 'a' y 'z'
				combinacion.append(letra);
			}
			combinaciones.add(combinacion.toString());
		}
		return combinaciones;
	}
}
