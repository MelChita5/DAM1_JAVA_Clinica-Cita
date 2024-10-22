package Main;


import java.util.Scanner;

import Objeto.clinica;

public class main {

	public static void main(String[] args) {
		
	
		clinica clinica = new clinica();
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			
			System.out.println(
					
					"----------------------------------------------\n"
					+ " Bienvenido a la Clinica AMC >> \n" 
					+ " 	1.- Reservar Cita  \n"
					+ " 	2.- Cambiar Cita\n"
					+ "----------------------------------------------"
					);
			
			
			int opcion1 = scanner.nextInt();
			
				switch(opcion1) {
				
				case 1:
					
					clinica.reserva();
				
					break;

				case 2:
					 clinica.cambiarCita();
					 
					break;
				}
					
			
		}
			
		
		
	}

}
