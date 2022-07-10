import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        if (input.charAt(0) == input.charAt(3) && input.charAt(1) == input.charAt(2)) {
            System.out.println(1);
        } else {
            System.out.println(37);
        }
    }
}