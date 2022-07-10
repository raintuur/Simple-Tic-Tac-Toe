import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int betweenNumber = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(isBetweenTwoNumbers(a, betweenNumber, b)
                || isBetweenTwoNumbers(b, betweenNumber, a));
    }

    private static boolean isBetweenTwoNumbers(int number1, int betweenNumber, int number2) {
        return number1 <= betweenNumber && betweenNumber <= number2;
    }
}