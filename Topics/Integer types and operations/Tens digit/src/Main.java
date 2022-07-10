import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        if (number.length() > 1) {
            System.out.println(number.charAt(number.length() - 2));
        } else {
            System.out.println(0);
        }
    }
}