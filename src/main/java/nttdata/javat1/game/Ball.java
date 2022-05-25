package nttdata.javat1.game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase Ball que realiza los movimientos de la trayectoria
 * 
 * @author jose
 *
 */
public class Ball {
	private int ballRY;
	private int ballRX;
	private static final Logger LOG = LoggerFactory.getLogger(Ball.class);

	/**
	 * Metodo que simula el ascenso y descenso de la bola
	 * @param launchY
	 * @param launchX
	 */
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
	 * 
	 * @return ballRY
	 */
	public int getBallRY() {
		return ballRY;
	}

	/**
	 * Metodo getter de la posicion x de la bola
	 * 
	 * @return ballRX
	 */
	public int getBallRX() {
		return ballRX;
	}

}
