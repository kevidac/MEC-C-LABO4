import java.util.*;

public class Parqueadero {
    static Scanner sc = new Scanner(System.in);
    static List<Vehiculo> vehiculos = new ArrayList<>();
    static Stack<Vehiculo> vehiculos2Ruedas = new Stack<>();
    static Stack<Vehiculo> vehiculos4Ruedas = new Stack<>();
    static int Vehiculos = 0;
    static int valorTotal = 0;

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("Menu");
            System.out.println("1. Ingreso de vehículo");
            System.out.println("2. Visualizar tabla");
            System.out.println("3. ingreso vehículos de 2 ruedas");
            System.out.println("4. ingresp vehículos de 4 ruedas");
            System.out.println("5. Cantidad de vehículos ingresados");
            System.out.println("6. Eliminar vehículo");
            System.out.println("7. Salir");
            System.out.print("Ingrese opcion a elegir: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> Ingresar();
                case 2 -> Tabla();
                case 3 -> Vehiculos2Ruedas();
                case 4 -> Vehiculos4Ruedas();
                case 5 -> Valor();
                case 6 -> eliminarVehiculo();
                case 7 -> System.out.println("Buen viaje.");
                default -> System.out.println("Opción no encontrada.");
            }
        } while (opcion != 7);
    }

    public static void Ingresar() {
        Vehiculos++;
        System.out.print("Ingrese placa: ");
        String placa = sc.next();
        System.out.println("Ingrese el tipo de vehículo (segun corresponda 2-bicicltas, 2 motos y 3 para carros): ");
        int tipo = sc.nextInt();
        System.out.print("Ingrese la hora de ingreso en formato de 24 horas: ");
        int Ingreso = sc.nextInt();
        int valor = 0;
        switch (tipo) {
            case 1 -> valor = 20;
            case 2 -> valor = 30;
            case 3 -> valor = 60;
            default -> {
                System.out.println("Tipo de vehículo no encontrado.");
                return;
            }
        }
        Vehiculo vehiculo = new Vehiculo(Vehiculos, placa, tipo, Ingreso, valor);
        vehiculos.add(vehiculo);
        if (tipo == 1 || tipo == 2) {
            vehiculos2Ruedas.push(vehiculo);
        } else {
            vehiculos4Ruedas.push(vehiculo);
        }
        System.out.println("Vehículo registrado exitosamente");
    }
// parte tomada de chat gpt 
    public static void Tabla() {
        System.out.println("Tabla de vehiculos");
        System.out.println("N°: \tPLACA: \tTIPO: \tHORA DE INGRESO: \tVALOR A PAGAR: ");
        vehiculos.forEach(vehiculo -> {
            System.out.println(vehiculo.getNumero() + "\t" + vehiculo.getPlaca() + "\t" + vehiculo.getTipo() + "\t" + vehiculo.getHoraIngreso() + "\t\t\t" + vehiculo.getValorAPagar());
        });
    }

    public static void Vehiculos2Ruedas() {
        System.out.println("Vehiculos mptorisados de dos ruedas");
        System.out.println("N°: \tPLACA: \tTIPO: \tHORA DE INGRESO: \tVALOR A PAGAR: ");
        while (!vehiculos2Ruedas.empty()) {
            Vehiculo vehiculo = vehiculos2Ruedas.pop();
            System.out.println(vehiculo.getNumero() + "\t" + vehiculo.getPlaca() + "\t" + vehiculo.getTipo() + "\t" + vehiculo.getHoraIngreso() + "\t\t\t" + vehiculo.getValorAPagar());
            valorTotal += vehiculo.getValorAPagar();
        }
    }

    public static void Vehiculos4Ruedas() {
        System.out.println("Vehiculos de 4 ruedas");
        System.out.println("N°: \tPLACA: \tTIPO: \tHORA DE INGRESO: \tVALOR A PAGAR: ");
        while (!vehiculos4Ruedas.empty()) {
            Vehiculo vehiculo = vehiculos4Ruedas.pop();
            System.out.println(vehiculo.getNumero() + "\t" + vehiculo.getPlaca() + "\t" + vehiculo.getTipo() + "\t" + vehiculo.getHoraIngreso() + "\t\t\t" + vehiculo.getValorAPagar());
            valorTotal += vehiculo.getValorAPagar();
        }
    }

    public static void Valor() {
        System.out.println("Cantidad de vehiculos total");
        System.out.println("Cantidad de vehículos en el estableciiento: " + vehiculos.size());
        System.out.println("Valor total a cancelar: " + valorTotal);
    }

    public static void eliminarVehiculo() {
        System.out.print("Ingrese el número del vehículo que tuvo salida: ");
        int numero = sc.nextInt();
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getNumero() == numero) {
                vehiculos.remove(vehiculo);
                System.out.println("Vehículo eliminado del archivo correctamente.");
                return;
            }
        }
        System.out.println("No se encontró ningún vehículo con ese número de registro.");
    }
} // hasta esta parte 

class Vehiculo {
    private final int numero;
    private final String placa;
    private final int tipo;
    private final int horaIngreso;

    public Vehiculo(int numero, String placa, int tipo, int horaIngreso, int valorAPagar) {
        this.numero = numero;
        this.placa = placa;
        this.tipo = tipo;
        this.horaIngreso = horaIngreso;
    }

    public int getNumero() {
        return numero;
    }

    public String getPlaca() {
        return placa;
    }

    public int getTipo() {
        return tipo;
    }

    public int getHoraIngreso() {
        return horaIngreso;
    }

    public int getValorAPagar() {
        int horaActual = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        int minutosTranscurridos = (horaActual - horaIngreso);
        int valorAPagar = 0;
        switch (tipo) {
            case 1 ->
                valorAPagar = minutosTranscurridos * 20;
            case 2 ->
                valorAPagar = minutosTranscurridos * 30;
            case 3 ->
                valorAPagar = minutosTranscurridos * 60;
        }
        return valorAPagar;
    }
}