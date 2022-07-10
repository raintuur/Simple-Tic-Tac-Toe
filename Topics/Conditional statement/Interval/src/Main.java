import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        if (-15 < i && i <= 12) {
            System.out.println("True");
        } else if (14 < i && i < 17) {
            System.out.println("True");
        } else if (19 <= i) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}