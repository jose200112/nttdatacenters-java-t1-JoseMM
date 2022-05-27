package nttdata.javat1.game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase Score que registra el jugador, la puntuacion y genera un ranking
 * 
 * @author maria
 *
 */
public class Score {

	Scanner sc = new Scanner(System.in);
	private static final Logger LOG = LoggerFactory.getLogger(Score.class);
	private List<String> al = new ArrayList<>();
	private String playerName;
	private int totalScore;

	/**
	 * Metodo que pide un nombre al jugador y lo registra
	 */
	public void recordName() {
		// Pregunta al jugador su nombre
		do {
			LOG.info("Dime tu nombre");
			sc.nextLine();
			playerName = sc.nextLine();

			if (playerName.isEmpty() || playerName.isBlank()) {
				LOG.error("No se puede dejar el nombre vacio, vuelve a intentarlo");
			} else {
				LOG.info("Jugador registrado correctamente");
			}

		} while (playerName.isEmpty() || playerName.isBlank());
		// Registramos el jugador y la puntuacion
		scoreFile();
	}

	/**
	 * Metodo que guarda los jugadores y su puntuacion en un archivo
	 */
	private void scoreFile() {
		try (FileWriter fw = new FileWriter("C://dev//pinball//Score.txt", true)) {

			fw.write(getTotalScore() + " " + playerName + '\n');

		} catch (IOException ex) {
			LOG.error("Se produjo un error al abrir o escribir en el fichero ");
		}
	}

	/**
	 * Metodo que lee el archivo score y hace un ranking de jugadores
	 */
	public void printRecords() {
		try (FileReader fr = new FileReader("C://dev//pinball//Score.txt");
			 BufferedReader br = new BufferedReader(fr);) {
			
			String lines = br.readLine();
			
			// Recorre el archivo y guarda los jugadores en un array
			
			while (lines != null) {
				al.add(lines);
				lines = br.readLine();
			}
			
			//Llama al metodo para ordenar e imprimir resultados
			orderScore();
			
		} catch (FileNotFoundException ex) {
			LOG.error("El fichero " + " no se encuentra");
		} catch (IOException ex) {
			LOG.error("Se produjo un error al leer del fichero ");
		}
	}

	/**
	 * Metodo que ordena los jugadores por puntuacion y los imprime
	 * 
	 * @param leerLinea
	 * @throws IOException
	 */
	private void orderScore() {

		// Ordena el array, lo recorre con un iterador e imprime

		Collections.sort(al, Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();

		int i = 0;
		for (Iterator<String> iter = al.iterator(); iter.hasNext(); i++) {
			String ranking = iter.next();

			// concatena
			sb.delete(0, sb.length());
			sb.append(i+1);
			sb.append(" - ");
			sb.append(ranking);
			String result = sb.toString();
			LOG.info(result);
		}
	}

	/**
	 * Metodo getter de la puntuacion
	 * 
	 * @return score
	 */
	public int getTotalScore() {
		return totalScore;
	}

	/**
	 * Metodo que incrementa la puntuacion
	 */
	public void incrementScore() {
		totalScore = totalScore + 20;
	}

}
