import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCups = scanner.nextInt();
        boolean isWeekend = scanner.nextBoolean();
        boolean partySuccessfulWhenWeekday = !isWeekend && numberOfCups >= 10 && numberOfCups <= 20;
        boolean partySuccessfulWhenWeekend = isWeekend && numberOfCups >= 15 && numberOfCups <= 25;
        System.out.println(partySuccessfulWhenWeekday || partySuccessfulWhenWeekend);
    }
}