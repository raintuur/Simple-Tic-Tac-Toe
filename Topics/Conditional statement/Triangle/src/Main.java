import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        boolean conditionOneOk = a + b > c;
        boolean conditionTwoOk = a + c > b;
        boolean conditionThreeOk = b + c > a;

        if (conditionOneOk && conditionTwoOk && conditionThreeOk) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}