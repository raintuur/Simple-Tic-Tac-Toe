import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int minHours = scanner.nextInt();
        int maxHours = scanner.nextInt();
        int sleepHours = scanner.nextInt();

        if (minHours <= sleepHours && sleepHours <= maxHours) {
            System.out.println("Normal");
        } else if (sleepHours < minHours) {
            System.out.println("Deficiency");
        } else {
            System.out.println("Excess");
        }
    }
}