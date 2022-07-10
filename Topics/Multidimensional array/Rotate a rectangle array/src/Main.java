import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] inputArray = createArrayFromInput(scanner, n, m);
        int[][] rotatedArray = createRotatedArray(n, m, inputArray);
        printTwoDimensionalArray(rotatedArray);
    }

    private static int[][] createArrayFromInput(Scanner scanner, int rows, int columns) {
        int[][] inputArray = new int[rows][columns];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                inputArray[r][c] = scanner.nextInt();
            }
        }
        return inputArray;
    }

    private static int[][] createRotatedArray(int n, int m, int[][] inputArray) {
        int[][] rotatedArray = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotatedArray[j][n - 1 - i] = inputArray[i][j];
            }
        }
        return rotatedArray;
    }

    private static void printTwoDimensionalArray(int[][] array) {
        for (int[] rows : array) {
            for (int value : rows) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}