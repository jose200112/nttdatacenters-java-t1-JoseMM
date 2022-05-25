package nttdata.javat1.game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase Game que lanza la pelota hacia un punto
 * 
 * @author jose
 *
 */
public class Game {
	private int launchX;
	private int launchY;
	private int heigh = 15;
	private int widthR = 10;
	private int widthL = -10;

	private static final Logger LOG = LoggerFactory.getLogger(Game.class);

	/**
	 * Metodo que lanza la bola y comienza el juego
	 */
	public void launchAndStart() {
		launchY = (int) (Math.random() * heigh + 1);
		launchX = (int) (Math.random() * (widthR + 1) + widthL);
		LOG.info("La pelota es lanzada a la direccion X:{} Y:{}", launchX, launchY);

	}

	/**
	 * Cambia la dificultad del juego
	 * @param difficulty
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

}
