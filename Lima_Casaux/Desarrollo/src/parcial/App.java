package parcial;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws IOException{
		
		int cantJugados;
		int cantSets;
		int cantGames;
		int difGames;
		int gamesA = 0, gamesB = 0;
		int setsA = 0, setsB = 0;
		int flag = 0;
		
		String resultados;
		String mypathin = "C:/Users/laboratorios/Desktop/Lima_Casaux/Preparacion de la prueba/Lote de prueba/Entrada/prehistorico5.in";
		String mypathout = "C:/Users/laboratorios/Desktop/Lima_Casaux/Ejecucion de la prueba/prehistorico5.out";
		
		Scanner sc = new Scanner(new File(mypathin));
		
		cantJugados = sc.nextInt();
		cantSets = sc.nextInt();
		cantGames = sc.nextInt();
		difGames = sc.nextInt();
		resultados = sc.next();
		System.out.println(cantJugados);
		System.out.println(cantSets);
		System.out.println(cantGames);
		System.out.println(difGames);
		System.out.println(resultados);
		sc.close();
		
		for (int i = 0; i < resultados.length(); i++) {
			
			if(resultados.charAt(i) == 'A')
				gamesA++;
			else
				gamesB++;
			
			if(gamesA >= cantGames && (gamesA - gamesB) >= difGames){
				setsA++;
				flag = 1;
			}
			if(gamesB >= cantGames && (gamesB - gamesA) >= difGames){
				setsB++;
				flag = 1;
			}
			
			if(flag == 1){
				gamesA = 0;
				gamesB = 0;
				flag = 0;
			}
			
			if(setsA == cantSets || setsB == cantSets)
				break;
		}
		
		PrintWriter pw = new PrintWriter(new File(mypathout));
		
		pw.print(setsA + " "+ setsB);
		
		pw.close();
	}

}