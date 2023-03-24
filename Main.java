
 import java.util.ArrayList;
import java.util.Scanner;

public class AsignacionTurnos {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> turnos = new ArrayList<String>();
        int edad;
        String nombre, afiliacion, condicionEspecial, turno;

        while (true) {
            System.out.print("Nombre y apellidos: ");
            nombre = input.nextLine();

            System.out.print("Edad: ");
            edad = input.nextInt();
            input.nextLine();

            System.out.print("Afiliación (POS o PC): ");
            afiliacion = input.nextLine();

            System.out.print("Condición especial (embarazo o limitación motriz): ");
            condicionEspecial = input.nextLine();

            if (edad >= 60 || edad <= 12) {
                turno = "Turno prioritario";
            } else if (condicionEspecial.equals("embarazo")) {
                turno = "Turno prioritario";
            } else if (condicionEspecial.equals("limitación motriz")) {
                turno = "Turno prioritario";
            } else if (afiliacion.equals("PC")) {
                turno = "Turno prioritario";
            } else {
                turno = "Turno regular";
            }

            turnos.add(nombre + " - " + turno);

            System.out.println("Turno asignado: " + turno);
            System.out.print("¿Asignar otro turno? (s/n): ");
            String continuar = input.nextLine();

            if (!continuar.equals("s")) {
                break;
            }
        }

        System.out.println("\nTurnos asignados:");
        for (String t : turnos) {
        }
            System.out.println(t);

            System.out.println("Su número de turno es: " + (colaEspera.size())); 
            System.out.println(" ");

            if (colaEspera.size() == 1) {
              
                turnoActual = 1;
                Thread.sleep(5000); // Espera 5 segundos para llamar al primer paciente
                System.out.println("¡Turno " + turnoActual + "! " + colaEspera.poll() + " puede pasar.");
                System.out.println(" ");
            } else if (colaEspera.size() > 1) {
                
                System.out.println("Turno actual: " + turnoActual);
                System.out.println("Tiempo restante: 6 segundos");
                System.out.println("Turnos pendientes: " + (colaEspera.size() - 1));
                System.out.println(" ");
            }
            while (true) {
                    
                Thread.sleep(6000); 
                    
            }
        }
    }
 }