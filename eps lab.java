import java.util.*;

 class Main {
    public static void main(String[] args) {
        ArrayList<Paciente> pacientes = new ArrayList<Paciente>();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Nombre : ");
            String nombre = scanner.nextLine();
            if (nombre.equals("fin")) {
                break;
            }
            System.out.print("Edad ");
            int edad = Integer.parseInt(scanner.nextLine());
            System.out.print("Afiliación del usuarios POS o PC: ");
            String afiliacion = scanner.nextLine();
            System.out.print("Condición especial (primera letra) : ");
            String condicionEspecial = scanner.nextLine();

            Paciente paciente = new Paciente(nombre, edad, afiliacion, condicionEspecial);
            pacientes.add(paciente);
        }

        pacientes.sort((p1, p2) -> p1.getOrdenLlegada() - p2.getOrdenLlegada());

        int turno = 1;
        for (Paciente paciente : pacientes) {
            if (paciente.tienePrioridad()) {
                paciente.setTurno("Turno prioritario " + turno);
                turno++;
            } else {
                paciente.setTurno("Turno numero " + turno);
                turno++;
            }
        }

        for (Paciente paciente : pacientes) {
            System.out.println(paciente.getNombre() + ": " + paciente.getTurno());
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                public void run() {
                    System.out.println("siguiente turno:" + paciente.getTurno());
                }
            };
            timer.schedule(task, 5000);
        }
    }
}
class Paciente {
    private static int contador = 1;

    private int ordenLlegada;
    private String nombre;
    private int edad;
    private String afiliacion;
    private String condicionEspecial;
    private String turno;

    public Paciente(String nombre, int edad, String afiliacion, String condicionEspecial) {
        this.ordenLlegada = contador;
        contador++;
        this.nombre = nombre;
        this.edad = edad;
        this.afiliacion = afiliacion;
        this.condicionEspecial = condicionEspecial;
    }

    public int getOrdenLlegada() {
        return ordenLlegada;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAfiliacion() {
        return afiliacion;
    }

    public String getCondicionEspecial() {
        return condicionEspecial;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public boolean tienePrioridad() {
        return edad < 11 || edad >= 60 || afiliacion.equals("PC") || condicionEspecial.equals("E") || condicionEspecial.equals("L");
    }
}