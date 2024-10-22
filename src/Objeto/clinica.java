package Objeto;

import java.util.Scanner;

public class clinica {
	
	
	public int huecosTotales = 10;
	public int[] huecosM = new int[huecosTotales]; // arrays
	public int[] huecosT = new int[huecosTotales]; // arrays
	private int numConsulta;
	private String tipoConsulta;
	private String nombreMedico;
	private int dni;
	private String franja; // dia o tarde

	
	public clinica(int huecosTotales, int[] huecosM, int[] huecosT, int numConsulta,
			String tipoConsulta, String nombreMedico, int dni, String franja) {
		
		this.huecosTotales = huecosTotales;
		this.huecosM = huecosM;
		this.huecosT = huecosT;
		this.numConsulta = numConsulta;
		this.tipoConsulta = tipoConsulta;
		this.nombreMedico = nombreMedico;
		this.dni = dni;
		this.franja = franja;
	}
	
	
	public clinica()	{
		
	}

	public String getnombreMedico() {
		return nombreMedico;
	}

	public int getnumConsulta() {
		return numConsulta;	
	}
	
	public String gettipoConsulta() {
		return tipoConsulta;
	}
	
	
	public int[] gethuecosM() {
		return huecosM;	
	}
	
	public int[] gethuecosT() {
		return huecosT;	
	}
	
	public int getdni() {
		return dni;
	}
	
	
	public String getfranja() {
		return franja;
	}
	
	
	public void reserva() {
		
		Scanner scanner = new Scanner(System.in);
		
		//Ingresar el DNI
		System.out.println("Ingrese su DNI (8 numeros): ");
		
		this.dni = scanner.nextInt();
		
		// Seleccionar el tipo de consulta
		System.out.println("Tipo de consulta: \n"
				+ "1.- Revision\n"
				+ "2.- Tratamiento\n" );
		
		int opcion2 = scanner.nextInt();

		if (opcion2 == 1) {
			
			// Si op2 es igual a 1 Reservar cita en revision
			// inicializamos un boolean en true, la cual le indicara al uruario si tieneCitaReservada
			boolean tieneCitaReservada = true;
			
			//recorremos el array
			for (int i = 0; i < huecosM.length; i++) {
				
				// utilice el dni como el numero el cual se guardara en el array
				// por tal razon si huecosM es diferente que 0 significa que un usuario ya tiene 
				// una cita reservada, ademas tambien comprueba si los numeros en el array huecosM es igual 
				// al numero ingresado por el usuario :0
				if (huecosM[i] != 0 && huecosM[i] == this.dni) {
					
					// se cambia a false indicando que el paciento ahora ya tiene una cita reservada
					tieneCitaReservada = false;
					
					// para salir del bucle se usa el break, lo de toda la vida
					break;
				}
			}
			
			
			//eleccionde franja
			System.out.println("Franja de la consulta: \n"
					+ "1.- Dia\n"
					+ "2.- Tarde\n" );
			
			int opcion3 = scanner.nextInt();
			
			
			if (opcion3 == 1) {
				
				//si la opcion es igual a 1 salen los hucos de dia
				System.out.println("Huecos de Dia: \n");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				System.out.println(
						"1.-  9:00 ~ 9:30\n"
						+ "2.-  9:30 ~ 10:00\n"
						+ "3.-  10:00 ~ 10:30\n"
						+ "4.-  10:30 ~ 11:00\n"
						+ "5.-  11:00 ~ 11:30\n"
						+ "6.-  11:30 ~ 12:00\n"
						+ "7.-  12:00 ~ 12:30\n"
						+ "8.-  12:30 ~ 13:00\n"
						+ "9.-  13:00 ~ 13:30\n"
						+ "10.-  13:30 ~ 14:00"
						);
				
				int huecoRevision = scanner.nextInt();
				
				// los arrays inican en 0 por tal razon se le resta el -1 para que 
				// el numero correcto por decirlo asi este entre los corchetes del array
				// Si es igual a cero significa que esta libre el hueco y se puede reservar la cita
				if (huecosM[huecoRevision - 1] == 0) {
					
					
					// entonces el numero colocado en el array huecosM sera el dni del usuario
					huecosM[huecoRevision - 1] = this.dni;
					
					System.out.println("La cita ha sido reservada con exito.");
					
				} else {
					
					// Es una comprobacion si el usuario tiene una cita reservada en ese hueco
					// por tal razon se le resta el numero ingresado para dar el numero exacto en el array
					// y se le iguala a dni del usuario para hacer la comprobacion
					if (huecosT[huecoRevision - 1] == this.dni) {
						
						System.out.println("Ya tiene una cita reservada en este hueco.");
						
					} else {
						
						System.out.println("El hueco ya esta reservado. Elija otro porfavor.");
					}
				}
			} else if (opcion3 == 2) {
				
				System.out.println("Huecos de Tarde: \n");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				System.out.println(
						"1.-  16:00 ~ 16:30 \n"
						+ "2.-  16:30 ~ 17:00 \n"
						+ "3.-  17:00 ~ 17:30\n"
						+ "4.-  17:30 ~ 18:00\n"
						+ "5.-  18:00 ~ 18:30\n"
						+ "6.-  18:30 ~ 19:00\n"
						+ "7.-  19:00 ~ 19:30\n"
						+ "8.-  19:30 ~ 20:00\n"
						+ "9.-  20:00 ~ 20:30\n"
						+ "10.-  20:30 ~ 21:00\n"
						);
				int huecoTratamiento = scanner.nextInt();

				if (opcion3 == 2) {
					// como explique anteriormente esto: huecosT[huecoTratamiento - 1] == 0 , comprueba si el hueco esta libre
					// y esto: huecosT[huecoTratamiento - 1] == this.dni, esto comprueba si esta reservado por el paciente
					if (huecosT[huecoTratamiento - 1] == 0 || huecosT[huecoTratamiento - 1] == this.dni) {
						
						// explicado anteriormente
						huecosT[huecoTratamiento - 1] = this.dni;
						
						System.out.println("La cita ha sido reservada con éxito.");
						
					} else {
						
						// explicado anteriormente
						if (huecosM[huecoTratamiento - 1] == this.dni) {
							
							System.out.println("Ya tiene una cita reservada en este hueco.");
							
						} else {
							
							System.out.println("El hueco ya esta reservado.");
						}
					}
				}
			} else {
				System.out.println("Error, opcion incorrecta.");
			}

			
		} if (opcion2 == 2) {
			
			// EXPLICADO ANTERIORMTE 
			
			boolean tieneCitaReservada = true;
			
			for (int i = 0; i < huecosM.length; i++) {
				
				if (huecosM[i] != 0 && huecosM[i] == this.dni) {
					
					tieneCitaReservada = false;
					
					break;
				}
			}

			System.out.println("Franja de la consulta: \n"
					+ "1.- Dia\n"
					+ "2.- Tarde\n" );
			
			int opcion3 = scanner.nextInt();

			if (opcion3 == 1) {
				
				System.out.println("Huecos de Dia: \n");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				System.out.println(
						"1.-  9:00 ~ 9:30\n"
						+ "2.-  9:30 ~ 10:00\n"
						+ "3.-  10:00 ~ 10:30\n"
						+ "4.-  10:30 ~ 11:00\n"
						+ "5.-  11:00 ~ 11:30\n"
						+ "6.-  11:30 ~ 12:00\n"
						+ "7.-  12:00 ~ 12:30\n"
						+ "8.-  12:30 ~ 13:00\n"
						+ "9.-  13:00 ~ 13:30\n"
						+ "10.-  13:30 ~ 14:00"
						);
				
				int huecoTratamiento = scanner.nextInt();
				
				// EXPLICADO ANTERIORMTE 
				if (huecosM[huecoTratamiento - 1] == 0) {
					
					huecosM[huecoTratamiento - 1] = this.dni;
					
					System.out.println("La cita ha sido reservada con exito.");
					
				} else {
					
					if (huecosT[huecoTratamiento - 1] == this.dni) {
						
						System.out.println("Ya tiene una cita reservada en este hueco.");
						
					} else {
						
						System.out.println("El hueco ya esta reservado.");
						
					}
				}
				
			} else if (opcion3 == 2) {
				
				System.out.println("Huecos de Tarde: \n");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println(
						"1.-  16:00 ~ 16:30 \n"
						+ "2.-  16:30 ~ 17:00 \n"
						+ "3.-  17:00 ~ 17:30\n"
						+ "4.-  17:30 ~ 18:00\n"
						+ "5.-  18:00 ~ 18:30\n"
						+ "6.-  18:30 ~ 19:00\n"
						+ "7.-  19:00 ~ 19:30\n"
						+ "8.-  19:30 ~ 20:00\n"
						+ "9.-  20:00 ~ 20:30\n"
						+ "10.-  20:30 ~ 21:00\n"
						);
				
				int huecoTratamiento = scanner.nextInt();

				if (opcion3 == 2) {
					
					// explicado anteriormente
					if (huecosT[huecoTratamiento - 1] == 0 || huecosT[huecoTratamiento - 1] == this.dni) {
						
						huecosT[huecoTratamiento - 1] = this.dni;
						
						System.out.println("La cita ha sido reservada con éxito.");
					} else {
						
						// explicado anteriormente
						if (huecosM[huecoTratamiento - 1] == this.dni) {
							
							System.out.println("Ya tiene una cita reservada en este hueco.");
							
						} else {
							
							System.out.println("El hueco ya esta reservado.");
						}
					}
				}
			} else {
				
				System.out.println("Error, opcion incorrecta.");
			}

			
		}
			
	}	
	
	

	public void cambiarCita() {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Ingrese su DNI: ");
		
		int dni = scanner.nextInt();

		
		for (int i = 0; i < huecosM.length; i++) {
			
			// y busca el dni del usuario para eliminarlo 
			if (huecosM[i] == dni) {
				
				// Se elimina cambiamndolo a 0, el cual sera utilizado por un proximo usuario
				huecosM[i] = 0;
				
				break;
				
			}
		}
	
		
		System.out.println("Tipo de consulta: \n"
				+ "1.- Revision\n"
				+ "2.- Tratamiento\n" );
		
		int tipoConsulta = scanner.nextInt();

			// control de errores
			if (tipoConsulta != 1 && tipoConsulta != 2) {
				
				System.out.println("Error, opción incorrecta.");
				
				//para finalizar la ejecucion
				return;
			}

		// Seleccionar franja horaria
		System.out.println("Franja de la consulta: \n"
				+ "1.- Dia\n"
				+ "2.- Tarde"
				);
		
		int franja = scanner.nextInt();
		
		
			// control de errores
			if (franja != 1 && franja != 2) {
				
				System.out.println("Error, opción incorrecta.");
				
				return;
			}

			switch (franja) {
			
			case 1: 
				
				// Mañana
				// Buscar hueco disponible en la mañana
				
	
				// Buscar la cita del usuario
				// se recorre el array
				for (int i = 0; i < huecosM.length; i++) {
					
					// y busca el dni del usuario para eliminarlo 
					if (huecosM[i] == dni) {
						
						// Se elimina cambiamndolo a 0, el cual sera utilizado por un proximo usuario
						huecosM[i] = 0;
						break;
					}
				}
	
				// Seleccionar hueco
				for (int i = 0; i < huecosM.length; i++) {
					
					System.out.println("Huecos de Dia: \n");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
					System.out.println(
							"1.-  9:00 ~ 9:30\n"
							+ "2.-  9:30 ~ 10:00\n"
							+ "3.-  10:00 ~ 10:30\n"
							+ "4.-  10:30 ~ 11:00\n"
							+ "5.-  11:00 ~ 11:30\n"
							+ "6.-  11:30 ~ 12:00\n"
							+ "7.-  12:00 ~ 12:30\n"
							+ "8.-  12:30 ~ 13:00\n"
							+ "9.-  13:00 ~ 13:30\n"
							+ "10.-  13:30 ~ 14:00"
							);
					
					int opcion = scanner.nextInt();
					
					// esto compruba que la opcion del usuario sea de la longitud del array osea un control de errores
					if (opcion > 0 && opcion <= huecosM.length) {
						
						// comprueba que el hueco esta disponible, primero ve si el hueco esta vacio 
						// y que no esta reservado por alguien 
						if (huecosM[i] == 0 && (tipoConsulta == 1 || tipoConsulta == 2)) {
							
							// coloca el dni del usuario en el array
							huecosM[i] = dni;
							
							System.out.println("La cita ha sido cambiada con éxito para una revisión.");
							
							break;
							
						// explicado anteriormente
						} else if (huecosM[i] != 0 && huecosM[i] != dni) {
							
							// El hueco está reservado por otro usuario
							System.out.println("El hueco " + opcion + " ya está reservado por otro usuario.");
						}
						
					} else {
						System.out.println("Opción incorrecta.");
						
						return;
					}
				}
				
				break;
				
			case 2:
				
				// explicado anteriormente
				for (int i = 0; i < huecosM.length; i++) {
					
					if (huecosM[i] == dni) {
						
						// Eliminar la cita anterior
						huecosM[i] = 0;
						
						break;
					}
					
				}
				for (int i = 0; i < huecosM.length; i++) {
					
					System.out.println("Huecos de Tarde: \n");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
					System.out.println(
							"1.-  16:00 ~ 16:30 \n"
							+ "2.-  16:30 ~ 17:00 \n"
							+ "3.-  17:00 ~ 17:30\n"
							+ "4.-  17:30 ~ 18:00\n"
							+ "5.-  18:00 ~ 18:30\n"
							+ "6.-  18:30 ~ 19:00\n"
							+ "7.-  19:00 ~ 19:30\n"
							+ "8.-  19:30 ~ 20:00\n"
							+ "9.-  20:00 ~ 20:30\n"
							+ "10.-  20:30 ~ 21:00\n"
							);
					
					int opcion = scanner.nextInt();
					
					
					//EXPLICADO ANTERIORMENTE
					if (opcion > 0 && opcion <= huecosT.length) {
						
						if (huecosT[i] == 0 && (tipoConsulta == 1 || tipoConsulta == 2)) {
							
							// El hueco está disponible
							huecosT[i] = dni;
							
							System.out.println("La cita ha sido cambiada con éxito para una revisión.");
							
							break;
							
						} else if (huecosT[i] != 0 && huecosT[i] != dni) {
							
							// El hueco está reservado por otro usuario
							System.out.println("El hueco " + opcion + " ya está reservado por otro usuario.");
							
						}
						
					} else {
						
						System.out.println("Opción incorrecta.");
						
						return;
						
					}
				}
				
				break;
			}

	}
	
	
}
