import java.util.Random;
import java.util.Scanner;

/**
 * Tiros Libres: el desafío
 * Un minijuego de consola en el que intentas conseguir la mejor racha
 * posible desde la línea de tiros libres.
 */
public class TirosLibres {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Random azar = new Random();

        final int TOTAL_TURNOS = 10;
        int puntos = 0;
        int racha = 0;
        int mejorRacha = 0;

        System.out.println("==================================");
        System.out.println("       🏀 TIROS LIBRES: EL RETO");
        System.out.println("==================================");
        System.out.println("Tienes " + TOTAL_TURNOS + " tiros. ¡A por el récord!");
        System.out.println("Pulsa ENTER para lanzar cada tiro.");
        System.out.println();

        for (int tiro = 1; tiro <= TOTAL_TURNOS; tiro++) {
            System.out.print("Tiro " + tiro + "/" + TOTAL_TURNOS + " - ");
            teclado.nextLine();

            // Un número del 1 al 100: cuanto más alto, más difícil encestar.
            int lanzamiento = azar.nextInt(100) + 1;
            boolean canasta = lanzamiento <= 72;

            if (canasta) {
                puntos++;
                racha++;
                mejorRacha = Math.max(mejorRacha, racha);

                String[] celebraciones = {
                    "¡LIMPIO! Ni ha tocado el aro.",
                    "¡CANASTÓN! La red está temblando.",
                    "¡Dentro! Sangre fría de estrella.",
                    "¡CLANK... y para dentro! También cuenta."
                };
                System.out.println(celebraciones[azar.nextInt(celebraciones.length)]);
                System.out.println("🔥 Racha actual: " + racha);
            } else {
                System.out.println("¡UYYY! El balón ha decidido hacer turismo por el aro.");
                if (racha > 0) {
                    System.out.println("Se acabó la racha de " + racha + ". ¡A levantar la cabeza!");
                }
                racha = 0;
            }

            System.out.println("Marcador: " + puntos + " de " + tiro);
            System.out.println("----------------------------------");
        }

        System.out.println();
        System.out.println("=========== FIN DEL PARTIDO ===========");
        System.out.println("Canastas: " + puntos + "/" + TOTAL_TURNOS);
        System.out.println("Porcentaje de acierto: " + (puntos * 10) + "%");
        System.out.println("Mejor racha: " + mejorRacha);

        if (puntos == 10) {
            System.out.println("🏆 ¡PERFECTO! ¡Eres el rey de la línea!");
        } else if (puntos >= 8) {
            System.out.println("⭐ ¡Nivel NBA! ¡Qué muñeca tienes!");
        } else if (puntos >= 5) {
            System.out.println("👏 Buen partido. ¡Un poco más de práctica y listo!");
        } else {
            System.out.println("💪 No pasa nada: hasta las leyendas fallan. ¡Otra ronda!");
        }

        System.out.println("=======================================");
        teclado.close();
    }
}
