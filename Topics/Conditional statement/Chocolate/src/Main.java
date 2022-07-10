import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = scanner.nextInt();
        int height = scanner.nextInt();
        int requiredPieceSize = scanner.nextInt();
        int totalPieces = width * height;
        int remainingPieces = totalPieces - requiredPieceSize;

        if (requiredPieceSize > totalPieces) {
            System.out.println("NO");
        } else if (remainingPieces % width == 0 || remainingPieces % height == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}