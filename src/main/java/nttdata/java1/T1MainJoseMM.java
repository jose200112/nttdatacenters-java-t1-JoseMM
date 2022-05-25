package nttdata.java1;

import nttdata.java1.game.Score;

import java.util.Scanner;

import nttdata.java1.game.Ball;
import nttdata.java1.game.Game;

/**
 * Clase con metodo main
 * @author jose
 *
 */
public class T1MainJoseMM {
	/**
	 * Metodo main que orquesta los objetos para generar el pinball
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Game g = new Game();
		Score s = new Score();
		Ball b = new Ball();

		String throwBall;
		
		System.out.println("-- Bienvenido --");
		
		do {
			
			System.out.println("Pulsa enter para lanzar (-1 para salir del juego)");
			throwBall = sc.nextLine();
			
			//Si throwBall tiene -1 no se ejecutara el lanzamiento
			if(!throwBall.contains("-1")) {
				g.launchAndStart();
				b.ballMovement(g.getLaunchY(), g.getLaunchX());
			}

			// rebota y el jugador consigue puntuacion
			if (g.getLaunchX() == g.getWidthR() || g.getLaunchX() == g.getWidthL() || g.getLaunchY() == g.getHeigh()) {
				s.incrementScore();
			}
			
			// Simula fallar al intentar relanzar la bola
			int fail = (int) (Math.random() * 10);
				if (fail == 10 && !throwBall.contains("-1")) {
					System.out.println("Has fallado");
					throwBall = "-1";
				}	
				
		} while (!throwBall.contains("-1"));
		
		//Acaba el juego, se guarda la puntuacion y genera un ranking
		g.gameOver();
		s.recordName();
		s.printRecords();
		sc.close();
	}

}
