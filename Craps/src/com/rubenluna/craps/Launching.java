package com.rubenluna.craps;
import java.util.Scanner;
import java.util.Random;

public class Launching{
	private int dice;
	private int $dice;
	private int point;
	private int $point;
	
	public Launching(int dice, int $dice, int point, int $point) {
		super();
		this.dice = dice;
		this.$dice = $dice;
		this.point = point;
		this.$point = $point;
	}
	
	Rules rules = new Rules();
	Files file = new Files();
	
	Scanner sc = new Scanner(System.in); // crea objeto para leer datos
	Random rdm = new Random(); // crea objeto para numeros random
	
	public void launch(){
		System.out.println("Presione (t) para tira los dados.");
	}
	
	public void points(){
		System.out.println(); System.out.println();
		System.out.print(point + " Punto Persona    ");
		System.out.println($point + " Punto Computador");
	}
	
	public void goFile(int sum, int point, int counter){
		if (point == 0) file.writeFile(sum, true, counter);
		else file.writeFile(sum, false, counter);
	}
	
	public void launchDices(){
		int counter, sum = 1, $sum = 1, exit = 1;
		String launch = "";
		String t = "t";
		boolean flag = false, $flag = false;
		
		while (!flag){
			counter = 0;
			points();
			while (counter < 2){
				sum = 0; dice = 0; $dice = 0;
				if (counter == 0){ //turno del jugador
					launch();
					launch = sc.next();
				}
				else { //turno de maquina
					System.out.println("Es el turno del computador");
					launch = "t";
				}
				if (launch.compareTo(t) == 0){ //dados random
					dice = (int)(rdm.nextDouble() * 6 + 1);
					System.out.println("Dado 1 = " + dice);
					$dice = (int)(rdm.nextDouble() * 6 + 1);
					System.out.println("Dado 2 = " + $dice);
					if (counter == 0){
						sum = dice + $dice;
						goFile(sum, point, counter);
						System.out.print(sum);
						if(!$flag) point = rules.instructions(sum, point, counter);
						else exit = rules.instructions(sum, point, counter);
					}
					else {
						$sum = dice + $dice;
						goFile($sum, point, counter);
						System.out.print($sum);
						if (!$flag ) $point = rules.instructions($sum, $point, counter);
						else exit = rules.instructions($sum, $point, counter);
					}
					counter ++;
					if (point == 0 || exit == 0) {
						flag = true;
						break;
					}
					if (counter > 1 && $point == 0){
						flag = true;
						break;
					}
					if (counter > 1) $flag = true; 
				}
				else{
					System.out.println("Intente de nuevo tirar sus dados.");
					points();
				}
			}			
		}	
	}
}
