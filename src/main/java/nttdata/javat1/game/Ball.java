package nttdata.javat1.game;

/**
 * Interface Ball que realiza los movimientos de la trayectoria
 * @author jose
 *
 */
public interface Ball {


	/**
	 * Metodo que simula el ascenso y descenso de la bola
	 * @param launchY (Eje Y)
	 * @param launchX (Eje X)
	 */
	public void ballMovement(int launchY, int launchX);
	
	/**
	 * Metodo que da puntuacion al jugador si rebota la pelota
	 */
	public void bounce();
	
	/**
	 * Metodo getter de la posicion Y de la bola
	 * 
	 * @return ballRY
	 */
	public int getBallRY();

	/**
	 * Metodo getter de la posicion x de la bola
	 * 
	 * @return ballRX
	 */
	public int getBallRX();

}
