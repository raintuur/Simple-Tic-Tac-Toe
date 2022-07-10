import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfUnits = scanner.nextInt();

        if (numberOfUnits < 1) {
            System.out.println("no army");
        } else if (1 <= numberOfUnits && numberOfUnits <= 19) {
            System.out.println("pack");
        } else if (20 <= numberOfUnits && numberOfUnits <= 249) {
            System.out.println("throng");
        } else if (250 <= numberOfUnits && numberOfUnits <= 999) {
            System.out.println("zounds");
        } else {
            System.out.println("legion");
        }
    }
}