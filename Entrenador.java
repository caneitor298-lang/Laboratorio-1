public class Entrenador {
    private String nombre;
    private Diegimon[] diegimons;
    private int cantidadActual;
    private int rondasGanadas;
    
    private String efectoPendiente;
    private int valorEfectoPendiente;
    private boolean tieneEfectoPendiente;

    public Entrenador(String nombre) {
        this.nombre = nombre;
        this.diegimons = new Diegimon[4];
        this.cantidadActual = 0;
        this.rondasGanadas = 0;

        this.efectoPendiente = "";
        this.valorEfectoPendiente = 0;
        this.tieneEfectoPendiente = false;
    }

    public void guardarEfectoSiguiente(Diegievolucion digievolucion) {
        this.efectoPendiente = digievolucion.getTipoEfecto();
        this.valorEfectoPendiente = digievolucion.getValor();
        this.tieneEfectoPendiente = true;
    }

    public void aplicarEfectoPendiente(Diegimon diegimon) {
        if (tieneEfectoPendiente) {

            diegimon.aplicarEfectoTemporal(efectoPendiente, valorEfectoPendiente);

            efectoPendiente = "";
            valorEfectoPendiente = 0;
            tieneEfectoPendiente = false;
        }
    }

    public boolean agregarDiegimon(Diegimon diegimon) {

        if (cantidadActual >= 4) {
            return false;
        }

        for (int i = 0; i < cantidadActual; i++) {
            if (diegimons[i].getNombre().equalsIgnoreCase(diegimon.getNombre())) {
                return false;
            }
        }
        
        diegimons[cantidadActual] = diegimon;
        cantidadActual++;
        return true;
    }

    public Diegimon getDiegimon(int posicion) {
        if (posicion >= 0 && posicion < cantidadActual) {
            return diegimons[posicion];
        }
        return null;
    }

    public Diegimon seleccionarDiegimon(int posicion) {
        if (posicion < 0 || posicion >= cantidadActual) {
            return null;
        }
        Diegimon elegido = diegimons[posicion];
        if (!elegido.estaDisponible()) {
            return null;
        }
        elegido.marcarComoUsado();
        return elegido;
    }

    public void sumarRondaGanada() {
        rondasGanadas++;
    }
    
    public String getNombre() {
        return nombre;
    }

    public int getCantidadActual() {
        return cantidadActual;
    }

    public int getRondasGanadas() {
        return rondasGanadas;
    }
}

