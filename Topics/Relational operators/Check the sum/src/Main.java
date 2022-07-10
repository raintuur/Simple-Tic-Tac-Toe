import java.util.Scanner;

class Main {
    public static final int CHECKSUM = 20;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        final boolean pairOneSumIsChecksum = Math.addExact(a, b) == CHECKSUM;
        final boolean pairTwoSumIsChecksum = Math.addExact(b, c) == CHECKSUM;
        final boolean pairThreeSumIsChecksum = Math.addExact(a, c) == CHECKSUM;

        System.out.println(pairOneSumIsChecksum || pairTwoSumIsChecksum || pairThreeSumIsChecksum);
    }
}