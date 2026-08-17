import java.util.Random;
import java.util.Scanner;
public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---Batalla de Diegimons---");
        
        System.out.print("Ingrese el nombre del primer entrenador: ");
        String nombreEntrenador1 = scanner.nextLine();

        System.out.print("Ingrese el nombre del segundo entrenador: ");
        String nombreEntrenador2 = scanner.nextLine();

        Entrenador entrenador1 = new Entrenador(nombreEntrenador1);
        Entrenador entrenador2 = new Entrenador(nombreEntrenador2);
        
        //Diegievoluciones

        Diegievolucion evoAguamon = new Diegievolucion("Aguamon", "ATAQUE", 15, 50);
        
        Diegievolucion evoGabumon = new Diegievolucion("Gabumon", "DEFENSA", 20, 30);

        Diegievolucion evoPalmon = new Diegievolucion("Palmon", "DAÑO", 10, 50);

        Diegievolucion evoTentomon = new Diegievolucion("Tentomon", "DEFENSA", 15, 40);
        
        //Diegimons entrenador 1
        
        Diegimon aguamon = new Diegimon("Aguamon", "Agua", 50, 30, evoAguamon);

        Diegimon gabumon = new Diegimon("Gabumon", "Fuego", 40, 40, evoGabumon);

        Diegimon palmon = new Diegimon("Palmon", "Planta", 30, 50, evoPalmon);

        Diegimon tentomon = new Diegimon("Tentomon", "Electrico", 35, 45, evoTentomon);

        //Diegimons entrenador 2

        Diegimon aguamon2 = new Diegimon("Aguamon", "Agua", 60, 30, evoAguamon);

        Diegimon gabumon2 = new Diegimon("Gabumon", "Fuego", 55, 35, evoGabumon);
    
        Diegimon palmon2 = new Diegimon("Palmon", "Planta", 50, 40, evoPalmon);

        Diegimon tentomon2 = new Diegimon("Tentomon", "Electrico", 58, 32, evoTentomon);

        //agregar diegimons a los entrenadores

        entrenador1.agregarDiegimon(aguamon);
        entrenador1.agregarDiegimon(gabumon);
        entrenador1.agregarDiegimon(palmon);
        entrenador1.agregarDiegimon(tentomon);

        entrenador2.agregarDiegimon(aguamon2);
        entrenador2.agregarDiegimon(gabumon2);
        entrenador2.agregarDiegimon(palmon2);
        entrenador2.agregarDiegimon(tentomon2);

        //crear batalla

        Batalla batalla = new Batalla(entrenador1, entrenador2);

        // 4 Rondas

        for (int numeroRonda = 1; numeroRonda <= 4; numeroRonda++) {

            System.out.println();
            System.out.println("========== RONDA " + numeroRonda + " ==========");

            // Mostrar Digimon disponibles del entrenador 1
            System.out.println();
            System.out.println(nombreEntrenador1 + ", elige tu Digimon:");

            for (int i = 0; i < 4; i++) {

                Diegimon d = entrenador1.getDiegimon(i);

                if (d.estaDisponible()) {
                    System.out.println((i + 1) + ". "
                            + d.getNombre() + " - " + d.getTipo());
                }
            }
            // Elegir Digimon
            Diegimon elegido1 = null;

            while (elegido1 == null) {

                System.out.print("Opcion: ");
                int opcion1 = scanner.nextInt();

                elegido1 =
                        entrenador1.seleccionarDiegimon(opcion1 - 1);

                if (elegido1 == null) {
                    System.out.println(
                            "Opcion invalida o ese Digimon ya fue utilizado.");
                }
            }

            //mostrar Digimon disponibles del entrenador 2
            System.out.println();
            System.out.println(nombreEntrenador2 + ", elige tu Digimon:");

            for (int i = 0; i < 4; i++) {

                Diegimon d = entrenador2.getDiegimon(i);

                if (d.estaDisponible()) {
                    System.out.println((i + 1) + ". "
                            + d.getNombre() + " - " + d.getTipo());
                }
            }

            // Elegir Digimon
            Diegimon elegido2 = null;

            while (elegido2 == null) {

                System.out.print("Opcion: ");
                int opcion2 = scanner.nextInt();

                elegido2 =
                        entrenador2.seleccionarDiegimon(opcion2 - 1);

                if (elegido2 == null) {
                    System.out.println(
                            "Opcion invalida o ese Digimon ya fue utilizado.");
                }
            }
            
            System.out.println();
            System.out.println(nombreEntrenador1 + " eligio a " + elegido1.getNombre());
            System.out.println("1. Atacar");
            System.out.println("2. Usar Digievolucion");

            int accion1 = 0;

            while (accion1 != 1 && accion1 != 2) {

                System.out.print("Opcion: ");
                accion1 = scanner.nextInt();

                if (accion1 != 1 && accion1 != 2) {
                    System.out.println("Opcion invalida.");
                }
            }

            System.out.println();
            System.out.println(nombreEntrenador2 + " eligio a " + elegido2.getNombre());
            System.out.println("1. Atacar");
            System.out.println("2. Usar Digievolucion");

            int accion2 = 0;

            while (accion2 != 1 && accion2 != 2) {

                System.out.print("Opcion: ");
                accion2 = scanner.nextInt();

                if (accion2 != 1 && accion2 != 2) {
                    System.out.println("Opcion invalida.");
                }
            }
            
            Ronda ronda = new Ronda(elegido1, elegido2, entrenador1, entrenador2);

            int ganadorRonda = ronda.ejecutarRonda(accion1, accion2);

            batalla.registrarRonda(ronda);


            // Mostrar resultado de la ronda
            System.out.println();
            System.out.println("----- RESULTADO DE LA RONDA -----");

            System.out.println(
                    elegido1.getNombre()
                    + " - Ataque total: "
                    + ronda.getAtaqueTotal1());

            System.out.println(
                    elegido2.getNombre()
                    + " - Ataque total: "
                    + ronda.getAtaqueTotal2());


            if (ganadorRonda == 1) {

                System.out.println(
                        "Ganador: " + nombreEntrenador1
                        + " con " + elegido1.getNombre());

            } else if (ganadorRonda == 2) {

                System.out.println(
                        "Ganador: " + nombreEntrenador2
                        + " con " + elegido2.getNombre());

            } else {

                System.out.println("La ronda termino en empate.");
            }

        } 
        System.out.println();
        System.out.println("========== RESULTADO FINAL ==========");

        System.out.println(
                nombreEntrenador1 + " gano "
                + entrenador1.getRondasGanadas()
                + " rondas.");

        System.out.println(
                nombreEntrenador2 + " gano "
                + entrenador2.getRondasGanadas()
                + " rondas.");

        int ganadorBatalla = batalla.obtenerGanadorBatalla();

        if (ganadorBatalla == 1) {

            System.out.println(
                    "Ganador de la batalla: " + nombreEntrenador1);

        } else if (ganadorBatalla == 2) {

            System.out.println(
                    "Ganador de la batalla: " + nombreEntrenador2);

        } else {

            System.out.println("La batalla termino en empate.");
        }

        scanner.close();
    }
}
