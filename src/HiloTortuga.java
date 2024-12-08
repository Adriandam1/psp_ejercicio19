/**
 * Hilo que implementa el movimiento de la tortuga en la carrera.
 */
public class HiloTortuga extends Thread {
    private final Carrera carrera;

    /**
     * Constructor que recibe la instancia de la clase Carrera.
     * @param carrera instancia de la clase Carrera.
     */
    public HiloTortuga(Carrera carrera) {
        this.carrera = carrera;
    }

    /**
     * Metodo que ejecuta la simulación de la carrera.
     */
    @Override
    public void run() {
        try {
            carrera.simularCarrera();
        } catch (InterruptedException e) {
            System.out.println("La carrera fue interrumpida.");
        }
    }
}
