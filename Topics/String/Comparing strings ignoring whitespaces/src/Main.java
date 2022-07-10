import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine().replace(" ", "");
        String b = scanner.nextLine().replace(" ", "");
        System.out.println(a.equals(b));
    }
}