package nttdata.java1;

import nttdata.java1.game.Score;

import java.util.InputMismatchException;
import java.util.Scanner;

import nttdata.java1.game.Ball;
import nttdata.java1.game.Game;

/**
 * Clase con metodo main
 * 
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
		Scanner dc = new Scanner(System.in);
		Game g = new Game();
		Score s = new Score();
		Ball b = new Ball();

		int option = 0;

		System.out.println("-- Bienvenido --");

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
				s.printRecords();
				break;
			case 3:
				g.changeDifficulty("Dificil");
				System.out.println("Dificultad cambiada a dificil");
				break;
			case 4:
				g.changeDifficulty("Medio");
				System.out.println("Dificultad cambiada a medio");
				break;
			case 5:
				g.changeDifficulty("");
				System.out.println("Dificultad cambiada a facil");
				break;
			default:
				System.out.println("Opcion no encontrada, vuelva a intentarlo");
			}
		} while (option != 1);


		String throwBall;

		do {
			
			System.out.println("Pulsa enter para lanzar (-1 para salir del juego)");
			throwBall = dc.nextLine();

			// Si throwBall tiene -1 no se ejecutara el lanzamiento
			if (!throwBall.contains("-1")) {
				g.launchAndStart();
				b.ballMovement(g.getLaunchY(), g.getLaunchX());
			}

			// rebota y el jugador consigue puntuacion
			if (g.getLaunchX() == g.getWidthR() || g.getLaunchX() == g.getWidthL() || g.getLaunchY() == g.getHeigh()) {
				s.incrementScore();
			}

			// Simula fallar al intentar relanzar la bola
			int fail = (int) (Math.random() * 11);
			if (fail == 10 && !throwBall.contains("-1")) {
				System.out.println("Has fallado");
				throwBall = "-1";
			}
		} while(!throwBall.contains("-1"));

		// Registra el jugador y acaba el juego
		s.recordName();
		g.gameOver();

		sc.close();
		dc.close();
	}

}
