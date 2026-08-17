public class Diegimon {
    
    private String nombre;
    private String tipo;
    private int ataque;
    private int defensa;
    private Diegievolucion diegievolucion;

    private boolean usado;
    private int bonusDefensa;
    private int bonusAtaque;
    private int dañoAlRival;

        public Diegimon(String nombre, String tipo, int ataque, int defensa, Diegievolucion digievolucion) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.diegievolucion = digievolucion;
        this.usado = false;
        this.bonusAtaque = 0;
        this.bonusDefensa = 0;
        this.dañoAlRival = 0;
    }
 

    public int calcularEfectoTipo(Diegimon rival) {
        String tipoRival = rival.getTipo();
        int efecto = 0;
 
        if (tipo.equals("Fuego") && tipoRival.equals("Planta")) {
            efecto = 20;
        } else if (tipo.equals("Planta") && tipoRival.equals("Agua")) {
            efecto = 20;
        } else if (tipo.equals("Agua") && tipoRival.equals("Fuego")) {
            efecto = 20;
        } else if (tipo.equals("Electrico") && tipoRival.equals("Agua")) {
            efecto = 20;
        } else if (tipo.equals("Planta") && tipoRival.equals("Fuego")) {
            efecto = -10;
        } else if (tipo.equals("Agua") && tipoRival.equals("Planta")) {
            efecto = -10;
        } else if (tipo.equals("Fuego") && tipoRival.equals("Agua")) {
            efecto = -10;
        } else if (tipo.equals("Agua") && tipoRival.equals("Electrico")) {
            efecto = -10;
        }
 
        return efecto;
    }

    public boolean activarDigievolucion() {
        boolean activada = diegievolucion.intentarActivar();
 
        if (activada) {
            if (diegievolucion.getTipoEfecto().equals("ATAQUE")) {
                bonusAtaque = bonusAtaque + diegievolucion.getValor();
            } else if (diegievolucion.getTipoEfecto().equals("DEFENSA")) {
                bonusDefensa = bonusDefensa + diegievolucion.getValor();
            } else {
                dañoAlRival = dañoAlRival + diegievolucion.getValor();
            }
        }
        return activada;
    }
 
    public void aplicarEfectoTemporal(String tipoEfecto, int valor) {
        if (tipoEfecto.equals("ATAQUE")) {
            bonusAtaque += valor;
        } else if (tipoEfecto.equals("DEFENSA")) {
            bonusDefensa += valor;
        } else {
            dañoAlRival += valor;
        }
    }

    public void limpiarEfectosTemporales() {
        bonusAtaque = 0;
        bonusDefensa = 0;
        dañoAlRival = 0;
    }

    public int calcularAtaqueTotal(Diegimon rival) {
        int total = ataque + bonusAtaque + calcularEfectoTipo(rival);
        total = total - (rival.getDefensa() + rival.getBonusDefensa());
        total = total - rival.getDanioAlRival();
        return total;
    }

    public void marcarComoUsado() {
        usado = true;
    }
 
    public boolean estaDisponible() {
        return !usado;
    }
 
    public String getNombre() {
        return nombre;
    }
 
    public String getTipo() {
        return tipo;
    }
 
    public int getAtaque() {
        return ataque;
    }
 
    public int getDefensa() {
        return defensa;
    }
 
    public Diegievolucion getDigievolucion() {
        return diegievolucion;
    }
 
    public int getBonusAtaque() {
        return bonusAtaque;
    }
 
    public int getBonusDefensa() {
        return bonusDefensa;
    }
 
    public int getDanioAlRival() {
        return dañoAlRival;
    }
}
