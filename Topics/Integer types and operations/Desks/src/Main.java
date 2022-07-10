import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int desksRequired = 0;

        while (scanner.hasNextInt()) {
            int numberOfStudents = scanner.nextInt();
            desksRequired += numberOfStudents / 2;
            if (numberOfStudents % 2 == 1) {
                desksRequired++;
            }
        }
        System.out.println(desksRequired);
    }
}