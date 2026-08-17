import java.util.Random;
 
public class Diegievolucion{
 
    private String nombre;
    private String tipoEfecto; 
    private int valor;
    private int probabilidad; 
    private Random random;
 
    public Diegievolucion(String nombre, String tipoEfecto, int valor, int probabilidad) {
        this.nombre = nombre;
        this.tipoEfecto = tipoEfecto;
        this.valor = valor;
        this.random = new Random();
        this.probabilidad = probabilidad;
    }

    public boolean intentarActivar() {
        int tiro = random.nextInt(101);
        return tiro <= probabilidad;
    }

    public String getNombre() {
        return nombre;
    }
        public String getTipoEfecto() {
        return tipoEfecto;
    }
 
    public int getValor() {
        return valor;
    }
 
    public int getProbabilidad() {
        return probabilidad;
    }
}
