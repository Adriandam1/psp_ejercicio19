import java.util.Random;

/**
 * Clase que representa la simulación de la carrera entre la tortuga y la liebre.
 */
public class Carrera {
    public static final int META = 70;  // Número de casillas en la carrera
    private int posicionTortuga = 1;   // Posición inicial de la tortuga
    private int posicionLiebre = 1;    // Posición inicial de la liebre
    private final Random random = new Random();  // Generador de números aleatorios

    /**
     * Metodo que simula el movimiento de la tortuga y la liebre.
     * @throws InterruptedException si el hilo es interrumpido.
     */
    public void simularCarrera() throws InterruptedException {
        System.out.println("¡La carrera ha comenzado entre la tortuga y la liebre!");

        // Mientras ninguno de los dos haya llegado a la meta
        while (posicionTortuga < META && posicionLiebre < META) {
            // Esperamos 1 segundo antes de evaluar los movimientos
            Thread.sleep(1000);

            // Simulamos el movimiento de la tortuga
            moverTortuga();
            // Simulamos el movimiento de la liebre
            moverLiebre();
        }

        // Al finalizar, determinamos el ganador
        if (posicionTortuga >= META && posicionLiebre >= META) {
            System.out.println("¡Es un empate!");
        } else if (posicionTortuga >= META) {
            System.out.println("¡La tortuga ha ganado!");
        } else {
            System.out.println("¡La liebre ha ganado!");
        }
    }

    /**
     * Metodo que evalúa el movimiento de la tortuga según las probabilidades definidas.
     */
    private void moverTortuga() {
        int movimiento = random.nextInt(100) + 1;  // Genera un número aleatorio entre 1 y 100

        if (movimiento <= 50) {  // 50% de probabilidad: Avance rápido (3 casillas)
            posicionTortuga += 3;
        } else if (movimiento <= 70) {  // 20% de probabilidad: Resbalón (6 casillas hacia atrás)
            posicionTortuga -= 6;
            if (posicionTortuga < 1) {
                posicionTortuga = 1;  // Si resbala al principio, vuelve a la casilla 1
            }
        } else {  // 30% de probabilidad: Avance lento (1 casilla)
            posicionTortuga += 1;
        }

        // Aseguramos que no sobrepase la meta
        if (posicionTortuga > META) {
            posicionTortuga = META;
        }

        // Imprimimos la posición de la tortuga
        System.out.println("Tortuga: " + posicionTortuga + " T");
    }

    /**
     * Metodo que evalúa el movimiento de la liebre según las probabilidades definidas.
     */
    private void moverLiebre() {
        int movimiento = random.nextInt(100) + 1;  // Genera un número aleatorio entre 1 y 100

        if (movimiento <= 20) {  // 20% de probabilidad: Duerme (sin movimiento)
            // No hace nada, la liebre duerme.
        } else if (movimiento <= 40) {  // 20% de probabilidad: Gran salto (9 casillas)
            posicionLiebre += 9;
        } else if (movimiento <= 50) {  // 10% de probabilidad: Resbalón grande (12 casillas hacia atrás)
            posicionLiebre -= 12;
            if (posicionLiebre < 1) {
                posicionLiebre = 1;  // Si resbala al principio, vuelve a la casilla 1
            }
        } else if (movimiento <= 80) {  // 30% de probabilidad: Pequeño salto (1 casilla)
            posicionLiebre += 1;
        } else {  // 20% de probabilidad: Resbalón pequeño (2 casillas hacia atrás)
            posicionLiebre -= 2;
            if (posicionLiebre < 1) {
                posicionLiebre = 1;  // Si resbala al principio, vuelve a la casilla 1
            }
        }

        // Aseguramos que no sobrepase la meta
        if (posicionLiebre > META) {
            posicionLiebre = META;
        }

        // Imprimimos la posición de la liebre
        System.out.println("Liebre: " + posicionLiebre + " L");
    }
}
