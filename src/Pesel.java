import java.util.Scanner;

public class Pesel {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] pesel = input(in); //Pobranie numeru PESEL w postaci tablicy jego poszczególnych cyfr
        if (checkCorrectnessOfPesel(pesel)) { //Sprawdzenie, czy numer PESEL jest poprawny (z pomocą odpowiedniej metody)
            System.out.println("This PESEL number is correct!");
        } else {
            System.out.println("This PESEL number is incorrect!");
        }
    }

    //Metoda pobierająca numer PESEL, mający koniecznie 11 cyfr
    private static int[] input(Scanner in) {

        String input = in.next();

        //Warunek, że PESEL musi mieć 11 znaków
        if (input.length() != 11) {
            System.out.println("Input variable is not a valid PESEL number!");
            System.exit(0);
        }

        char[] inputArray = input.toCharArray();

        //Warunek, że każdy znak numeru PESEL musi być cyfrą
        for (int i = 0; i < 11; i++) {
            if (!Character.isDigit(inputArray[i])) {
                System.out.println("Input variable is not a valid PESEL number!");
                System.exit(0);
            }
        }

        //Konwersja tablicy znaków na tablicę integerów
        int[] pesel = new int[11];
        for (int i = 0; i < 11; i++) {
            pesel[i] = Character.getNumericValue(inputArray[i]);
        }

        return pesel; //Zwrócenie tablicy integerów zawierającej numer PESEL
    }

    //Metoda sprawdzająca poprawność wprowadzonego numeru PESEL
    private static boolean checkCorrectnessOfPesel(int[] pesel) {
        int controlNumber = (pesel[0]
                + pesel[1] * 3
                + pesel[2] * 7
                + pesel[3] * 9
                + pesel[4]
                + pesel[5] * 3
                + pesel[6] * 7
                + pesel[7] * 9
                + pesel[8]
                + pesel[9] * 3
                + pesel[10]);

        //Jeśli PESEL jest poprawny, to utworzona liczba jest podzielna przez 10
        if (controlNumber % 10 == 0) {
            return true;
        }

        return false;
    }
}
