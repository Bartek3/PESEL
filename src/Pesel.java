import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Wprowadź numer PESEL składający się z 11 cyfr.");
        int controlNumber = 0;
        int[] controlMultipliers = new int[]{1, 3, 7, 9, 1, 3, 7, 9, 1, 3, 1};
        Long input = 0L;

        if (in.hasNextLong()) {
            input = in.nextLong();
        } else {
            System.out.println("Wprowadzono nieprawidłowy numer PESEL!");
            System.exit(1);
        }
        String inputString = input.toString();

        if (inputString.length() != 11) {
            System.out.println("Wprowadzono numer o nieprawidłowej długości!");
            System.exit(1);
        }

        for (int i = 0; i < 11; i++) {
            controlNumber += Character.getNumericValue(inputString.charAt(i)) * controlMultipliers[i];
        }

        if (controlNumber % 10 == 0) {
            System.out.println("Numer PESEL jest poprawny!");
        } else {
            System.out.println("Numer PESEL nie jest poprawny!");
        }
    }
}
