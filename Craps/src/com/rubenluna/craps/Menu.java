package com.rubenluna.craps;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
	private int op = 1;
	Files file = new Files();
	private Scanner sc;
	private void printing(){
		System.out.println("                           CRAPS!");
		System.out.println("1. Jugar");
		System.out.println("2. Crear o actualizar un archivo con estadisticas:");
		System.out.println("   - ¿Cuántos juegos se ganan en el primer tiro?");
		System.out.println("   - ¿Cuántos juegos se pierden en el primer tiro?");
		System.out.println("   - Cuantos juegos ganados y perdidos tiene cada jugador y sus porcentajes.");
		System.out.println("3. ¿Cuál es la oportunidad de ganar en Craps primer tiro?");
		System.out.println("4. ¿Cuál es la duración promedio de un juego de craps?");
		System.out.println("5. ¿Mejoran las oportunidades de ganar con la duración del juego?");
		System.out.println("0. Salir \n");
		System.out.print("Presione una opcion: ");
	}
	public void menu() throws FileNotFoundException, IOException{
		while (op != 0){
			Launching launch = new Launching(0, 0, 0, 0);
			printing();
			sc = new Scanner(System.in);
			op = sc.nextInt();
			
			switch (op){
			case 1: launch.launchDices();
					break;
			case 2: file.readFile();
					break;
			default: System.out.println("Presione una opcion valida.");
					 break;
			}
		}
	}
}
