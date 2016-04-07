package com.rubenluna.craps;

public class Rules {
	Files file = new Files();
	int instructions(int sum, int point, int counter){
		if (point == 0){
			if (sum == 7 || sum == 11){
				if (counter == 0) {System.out.println(" Jugador Gana!"); file.writeFile(1, false, 99);}
				else {System.out.println(" La Casa Gana!"); file.writeFile(2, true, 99);}
				point = 0;
			}
			else if (sum == 2 || sum == 3 || sum == 12){
				System.out.println(" CRAPS!");
				if (counter == 0) {System.out.println("La Casa Gana!"); file.writeFile(2, false, 99);}
				else {System.out.println("Jugador Gana!"); file.writeFile(1, true, 99);}
				point = 0;
			}
			else{
				System.out.println(" Se ha obtenido punto!");
				point = sum;
			}
		}
		else {
			if (sum == point){
				if (counter == 0){System.out.println(" Jugador Gana!"); file.writeFile(1, false, 99);}
				else {System.out.println(" La Casa Gana!"); file.writeFile(2, true, 99);}
				point = 0;
			}
			else if (sum == 7){
				if (counter == 0){System.out.println(" La Casa Gana!"); file.writeFile(2, false, 99);}
				else {System.out.println(" Jugador Gana!"); file.writeFile(1, true, 99);}
				point = 0;
			}
			else
				System.out.println(" Se debe tirar de nuevo.");
		}
		return point;
	}
}
