import java.util.Scanner;
import java.util.Random;

public class ScrabbleGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido al juego de Scrabble contra la máquina");
        System.out.println("Ingrese una letra por turno. Para detener el juego, escriba 'stop'.");

        StringBuilder word = new StringBuilder();
        while (true) {
            System.out.print("Ingrese una letra: ");
            String input = sc.nextLine();
            if (input.equals("stop")) {
                break;
            }
            word.append(input);
        }

        int score = calculateScore(word.toString());
        System.out.println("Su palabra es: " + word);
        System.out.println("Su puntuación es: " + score);

        String computerWord = generateRandomWord();
        int computerScore = calculateScore(computerWord);
        System.out.println("La palabra de la máquina es: " + computerWord);
        System.out.println("La puntuación de la máquina es: " + computerScore);

        if (score > computerScore) {
            System.out.println("Felicidades, has ganado!");
        } else if (score < computerScore) {
            System.out.println("Lo siento, la máquina ha ganado.");
        } else {
            System.out.println("Empate.");
        }
    }

    private static int calculateScore(String word) {
        int score = 0;
        for (char c : word.toCharArray()) {
            switch (c) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                case 'l':
                case 'n':
                case 'r':
                case 's':
                case 't':
                    score += 1;
                    break;
                case 'd':
                case 'g':
                    score += 2;
                    break;
                case 'b':
                case 'c':
                case 'm':
                case 'p':
                    score += 3;
                    break;
                case 'f':
                case 'h':
                case 'v':
                case 'w':
                case 'y':
                    score += 4;
                    break;
                case 'k':
                    score += 5;
                    break;
                case 'j':
                case 'x':
                    score += 8;
                    break;
                case 'q':
                case 'z':
                    score += 10;
                    break;
                default:
                    break;
            }
        }
        return score;
    }

    private static String generateRandomWord() {
        String[] words = {
                "casa", "perro", "gato", "ratón", "mesa",
                "silla", "ordenador", "teclado", "ratón", "libro",
                "coche", "bicicleta", "avión", "barco", "tren",
                "teléfono", "reloj", "calculadora", "agua", "comida"
        };

        Random rand = new Random();
        int index = rand.nextInt(words.length);
        return words[index];
    }
}
