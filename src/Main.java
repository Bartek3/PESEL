import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Wprowadź numer PESEL składający się z 11 cyfr.");
        int controlNumber = 0;
        int[] controlMultipliers = new int[]{1, 3, 7, 9, 1, 3, 7, 9, 1, 3, 1};

        String inputString = in.next();

        if (inputString.length() != 11) {
            System.out.println("Wprowadzono numer o nieprawidłowej długości!");
            System.exit(1);
        }

        for (int i = 0; i < 11; i++) {
            if (Character.isDigit(inputString.charAt(i)))
                controlNumber += Character.getNumericValue(inputString.charAt(i)) * controlMultipliers[i];
            else {
                System.out.println("Wprowadzono błędny numer!");
                System.exit(1);
            }
        }

        if (controlNumber % 10 == 0) {
            System.out.println("Numer PESEL jest poprawny!");
        } else {
            System.out.println("Numer PESEL nie jest poprawny!");
        }
    }
}
