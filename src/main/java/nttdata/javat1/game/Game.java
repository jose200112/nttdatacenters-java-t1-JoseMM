package nttdata.javat1.game;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase Game que comienza el juego y lanza la pelota
 * 
 * @author jose
 *
 */
public class Game extends Score implements Ball {
	Scanner dc = new Scanner(System.in);
	Scanner sc = new Scanner(System.in);
	private int launchX;
	private int launchY;
	private int heigh = 15;
	private int widthR = 10;
	private int widthL = -10;
	private String throwBall;
	private int ballRY;
	private int ballRX;
	private int option;

	private static final Logger LOG = LoggerFactory.getLogger(Game.class);

	/**
	 * Metodo que lanza la bola y comienza el juego
	 */
	public void launchAndStart() {
		pinballMenu();
		do{
			System.out.println("Pulsa enter para lanzar (-1 para salir del juego)");
			throwBall = dc.nextLine();
			if(!throwBall.contains("-1")) {
				launching();
				ballMovement(getLaunchY(), getLaunchX());
				bounce();
				fail();
			}
		}while(!throwBall.contains("-1"));
		recordName();
		gameOver();
	}
	
	/**
	 * Metodo que da puntuacion al jugador si rebota
	 */
	public void bounce() {
		if (getLaunchX() == getWidthR() || getLaunchX() == getWidthL() || getLaunchY() == getHeigh()) {
			incrementScore();
		}
	}

	/**
	 * Metodo que simula el fracaso del jugador al lanzar la bola
	 */
	public void fail() {
		int fail = (int) (Math.random() * 11);
		if (fail == 10) {
			System.out.println("Has fallado");
			throwBall = "-1";
		}
	}
	
	/**
	 * Metodo que genera el punto de lanzamiento
	 */
	public void launching() {
		launchY = (int) (Math.random() * heigh + 1);
		int rangeX = (widthR - widthL) + 1;
		launchX = (int) (Math.random() * rangeX) + widthL;
		LOG.info("La pelota es lanzada a la direccion X:{} Y:{}", launchX, launchY);
	}
	
	/**
	 * Menu del pinball
	 */
	public void pinballMenu() {
		do {
			System.out.println("-- Menu Pinball --");
			System.out.println("1 - Comenzar juego");
			System.out.println("2 - Ver ranking");
			System.out.println("3 - Cambiar dificultad a dificil");
			System.out.println("4 - Cambiar dificultad a medio");
			System.out.println("5 - Cambiar dificultad a facil");

			// Atrapa posible excepcion
			try {
				option = sc.nextInt();
			} catch (InputMismatchException e) {
				sc.nextLine();
			}

			switch (option) {
			case 1:
				break;
			case 2:
				printRecords();
				break;
			case 3:
				changeDifficulty("Dificil");
				System.out.println("Dificultad cambiada a dificil");
				break;
			case 4:
				changeDifficulty("Medio");
				System.out.println("Dificultad cambiada a medio");
				break;
			case 5:
				changeDifficulty("");
				System.out.println("Dificultad cambiada a facil");
				break;
			default:
				System.out.println("Opcion no encontrada, vuelva a intentarlo");
			}
		} while (option != 1);
	}

	/**
	 * Cambia la dificultad del juego
	 * @param difficulty (dificultad)
	 */
	public void changeDifficulty(String difficulty) {
		if (difficulty.equalsIgnoreCase("Dificil")) {
			heigh = 35;
			widthR = 30;
			widthL = -30;
			LOG.info("Dificultad cambiada a dificil");
		} else if (difficulty.equalsIgnoreCase("Medio")) {
			heigh = 20;
			widthR = 15;
			widthL = -15;
			LOG.info("Dificultad cambiada a medio");
		} else {
			heigh = 15;
			widthR = 10;
			widthL = -10;
			LOG.info("Dificultad cambiada a facil");
		}
	}

	/**
	 * Metodo que indica el final del juego
	 */
	public void gameOver() {
		System.out.println("-- Game Over --");
	}

	/**
	 * Metodo getter del lanzamiento X
	 * 
	 * @return launchX
	 */
	public int getLaunchX() {
		return launchX;
	}

	/**
	 * Metodo getter del lanzamiento Y
	 * 
	 * @return lunchY
	 */
	public int getLaunchY() {
		return launchY;
	}

	/**
	 * Metodo getter del limite de altura
	 * 
	 * @return heigh 
	 */
	public int getHeigh() {
		return heigh;
	}

	/**
	 * Metodo getter del limite de anchura izquierda
	 * 
	 * @return widthL
	 */
	public int getWidthL() {
		return widthL;
	}

	/**
	 * Metodo getter del limite de anchura derecha
	 * 
	 * @return widthR
	 */
	public int getWidthR() {
		return widthR;
	}

	/**
	 * Metodo que hace mover la pelota
	 */
	@Override
	public void ballMovement(int launchY, int launchX) {
		// Ascenso de la pelota
		while (ballRY < launchY || ballRX < launchX) {

			if (ballRY < launchY) {
				ballRY++;
			}

			if (ballRX < launchX) {
				ballRX++;
			}

			if (ballRX > launchX) {
				ballRX--;
			}

			LOG.info("Movimiento ascendente, X:{} Y:{}", getBallRX(), getBallRY());
		}

		// Descenso de la pelota
		while (ballRY > 0 || ballRX > 0) {

			if (ballRY > 0) {
				ballRY--;
			}

			if (ballRX > 0) {
				ballRX--;
			}

			if (ballRX < 0) {
				ballRX++;
			}

			LOG.info("Movimiento descendente, X:{} Y:{}", getBallRX(), getBallRY());
		}
		
	}
	
	/**
	 * Metodo getter de la posicion Y de la bola
	 */
	@Override
	public int getBallRY() {
		// TODO Auto-generated method stub
		return ballRY;
	}

	/**
	 * Metodo getter de la posicion X de la bola
	 */
	@Override
	public int getBallRX() {
		// TODO Auto-generated method stub
		return ballRX;
	}

}
