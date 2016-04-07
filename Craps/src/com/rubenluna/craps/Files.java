package com.rubenluna.craps;
import java.io.*;
public class Files {
	
	final String route = "/home/derot/Java/Craps/src/com/rubenluna/file.txt";
	final String $route = "/home/derot/Java/Craps/src/com/rubenluna/statistics.txt";
	public void writeFile(int sum, boolean carry, int counter){
		FileWriter $file = null;
        PrintWriter pw = null;
        try{
            $file = new FileWriter(route, true);
            pw = new PrintWriter($file);
            if (counter == 99){
            	if (!carry) pw.println(); 
            	if (sum == 1) pw.println("Gana Jugador");
            	else pw.println("Gana Casa");
            	carry = false;
            }
            if (carry) pw.println("Nuevo Juego");
            if (counter == 0) pw.print(sum+" ");
            else if(counter < 3) pw.println(sum+" ");
        } 
        catch (Exception e) {
            e.printStackTrace();
        } 
        finally {
           try { // Nuevamente aprovechamos el finally para // asegurarnos que se cierra el fichero.
        	   if (null != $file)
        		   $file.close();
           } 
           catch (Exception e2) {
              e2.printStackTrace();
           }
        }	
	}
	
	public void writeElements(int turns, int carry, int win, int loser, int player, int computer){
		FileWriter $file = null;
        PrintWriter pw = null;
        try{
            $file = new FileWriter($route);
            pw = new PrintWriter($file);
            pw.println("Ganados primer tiro " + win); 
            pw.println("Perdidos primer tiro " + loser); 
            pw.println("Ganados persona " + player);
            pw.println("Porcentaje persona " + (int)(player*100/carry) + "%");
            pw.println("Ganados computador " + computer);
            pw.println("Porcentaje computador " + (int)(computer*100/carry) + "%");
        } 
        catch (Exception e) {
            e.printStackTrace();
        } 
        finally {
           try { // Nuevamente aprovechamos el finally para // asegurarnos que se cierra el fichero.
        	   if (null != $file)
        		   $file.close();
           } 
           catch (Exception e2) {
              e2.printStackTrace();
           }
        }	
	}
	
	void readFile() throws FileNotFoundException, IOException {
	      String content = null, $carry = null; boolean flag = false; 
	      int turns = 0, player = 0, computer = 0, carry = 0, win = 0, loser = 0, divider = 0;
	      FileReader $file = new FileReader(route);
	      BufferedReader br = new BufferedReader($file);
	      while((content = br.readLine()) != null){
	    	  if (content.compareTo("Nuevo Juego") == 0){
	     		 if ((carry == 1)){
	     			 if (flag && $carry.length() < 4) win ++;
	     			 else if(flag && $carry.length() >= 4) loser ++;
	     			 else if(!flag && ($carry.length() < 4 || $carry.compareTo("12  ") == 0)) loser ++;
	     			 else if(!flag && $carry.length() >= 4) win ++;
	     		 }
	     		 carry = 0;
	     		 divider ++;
	     	  }
	     	  else if (content.compareTo("Gana Jugador") == 0){   		  
	     		  flag = true;
	     		  player ++;
	     	  }
	     	  else if (content.compareTo("Gana Casa") == 0){   		  
	     		  flag = false;
	     		  computer ++;
	     	  }
	     	  else {
	     		  $carry = content;
	     		  carry ++;
	     		  turns ++;
	     	  }
	      }
	      br.close();
	      writeElements(turns, divider, win, loser, player, computer);
	      System.out.println();
	      System.out.println("El archivo se ha creado o actualizado con exito.");
	      System.out.println();
	      
	}
	/*Se lanzan las excepciones FileNotFoundException y 
	 * IOException en caso de que no se encuentre el archivo o haya un error en la lectura.*/
}
