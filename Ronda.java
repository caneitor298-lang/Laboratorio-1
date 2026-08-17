public class Ronda {
    
    private Diegimon diegimon1;
    private Diegimon diegimon2;

    private int ataqueTotal1;
    private int ataqueTotal2;

    private int ganador;

    private Entrenador entrenador1;
    private Entrenador entrenador2;

    public Ronda(Diegimon diegimon1, Diegimon diegimon2, Entrenador entrenador1, Entrenador entrenador2) {
        this.diegimon1 = diegimon1;
        this.diegimon2 = diegimon2;
        this.entrenador1 = entrenador1;
        this.entrenador2 = entrenador2;

        this.ataqueTotal1 = 0;
        this.ataqueTotal2 = 0;
        this.ganador = 0;
    }

    public int ejecutarRonda(int accion1, int accion2) {
        
        entrenador1.aplicarEfectoPendiente(diegimon1);
        entrenador2.aplicarEfectoPendiente(diegimon2);

        if (accion1 == 2) {
            
            boolean digievolucionActivada = diegimon1.activarDigievolucion();

            if (digievolucionActivada) {
                entrenador1.guardarEfectoSiguiente(diegimon1.getDigievolucion());
            }
        }

        if (accion2 == 2) {
            boolean digievolucionActivada = diegimon2.activarDigievolucion();
            if (digievolucionActivada) {
                entrenador2.guardarEfectoSiguiente(diegimon2.getDigievolucion());
            }
        }

        ataqueTotal1 = diegimon1.calcularAtaqueTotal(diegimon2);
        ataqueTotal2 = diegimon2.calcularAtaqueTotal(diegimon1);

        if (ataqueTotal1 > ataqueTotal2) {
            ganador = 1;

        } else if (ataqueTotal2 > ataqueTotal1) {
            ganador = 2;

        } else {
            ganador = 0;
        }

        diegimon1.limpiarEfectosTemporales();
        diegimon2.limpiarEfectosTemporales();

        return ganador;
    }

    public int getAtaqueTotal1() {
        return ataqueTotal1;
    }

    public int getAtaqueTotal2() {
        return ataqueTotal2;
    }

    public Diegimon getDiegimon1() {
        return diegimon1;
    }

    public Diegimon getDiegimon2() {
        return diegimon2;
    }

    public int getGanador() {
        return ganador;
    }
}
