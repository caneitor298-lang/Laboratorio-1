public class Batalla {
    private Entrenador entrenador1;
    private Entrenador entrenador2;
    private Ronda [] rondas;
    private int CantidadRondas;

    public Batalla(Entrenador entrenador1, Entrenador entrenador2) {
        this.entrenador1 = entrenador1;
        this.entrenador2 = entrenador2;
        this.CantidadRondas = 0;
        this.rondas = new Ronda[4];
    }

    public boolean registrarRonda( Ronda ronda) {
        if (CantidadRondas >= 4) {
            return false;
        }
        rondas[CantidadRondas] = ronda;
        CantidadRondas++;

        if (ronda.getGanador() == 1) {
            entrenador1.sumarRondaGanada();
        } 
        else if (ronda.getGanador() == 2) {
            entrenador2.sumarRondaGanada();
        }
        return true;
    }

    public boolean batallaTerminada() {
        return CantidadRondas == 4;
    }
    
    public int obtenerGanadorBatalla() {
        if (entrenador1.getRondasGanadas() > entrenador2.getRondasGanadas()) {
            return 1;
        } else if (entrenador2.getRondasGanadas() > entrenador1.getRondasGanadas()) {
            return 2;
        } else {
            return 0;
        }
    }

    public Entrenador getEntrenador1() {
        return entrenador1;
    }

    public Entrenador getEntrenador2() {
        return entrenador2;
    }

    public int getCantidadRondas() {
        return CantidadRondas;
    }
}
