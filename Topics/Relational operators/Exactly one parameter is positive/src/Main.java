import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int positiveNumberCounter = 0;
        while (scanner.hasNextInt()) {
            if (scanner.nextInt() > 0) {
                positiveNumberCounter++;
            }
        }
        System.out.println(positiveNumberCounter == 1);
    }
}