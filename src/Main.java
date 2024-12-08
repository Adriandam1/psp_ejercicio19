//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Creamos la instancia de la carrera
        Carrera carrera = new Carrera();

        // Creamos los hilos para la tortuga y la liebre
        HiloTortuga hiloTortuga = new HiloTortuga(carrera);
        HiloLiebre hiloLiebre = new HiloLiebre(carrera);

        // Iniciamos los hilos
        hiloTortuga.start();
        hiloLiebre.start();
    }
}
