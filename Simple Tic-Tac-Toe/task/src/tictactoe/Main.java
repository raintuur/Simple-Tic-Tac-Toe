package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] matrix = createEmptyTicTacToeMatrix();
        printTicTacToeMatrix(matrix);
        playGame(matrix);
    }

    private static char[][] createEmptyTicTacToeMatrix() {
        return new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
    }

    private static void printTicTacToeMatrix(char[][] matrix) {
        printHorizontalBorder();
        printGameFields(matrix);
        printHorizontalBorder();
    }

    private static void printHorizontalBorder() {
        System.out.println("---------");
    }

    private static void printGameFields(char[][] matrix) {
        for (char[] row : matrix) {
            System.out.println("| " + row[0] + " " + row[1] + " " + row[2] + " |");
        }
    }

    private static void playGame(char[][] matrix) {
        char player = 'X';
        while (true) {
            int[] coordinates = getPlayerValidInput(matrix);
            placePlayerInputToMatrix(player, coordinates, matrix);
            printTicTacToeMatrix(matrix);
            String result = getGameResult(matrix, player);
            if (result.equals("Game not finished")) {
                player = player == 'X' ? 'O' : 'X';
            } else {
                System.out.println(result);
                break;
            }
        }
    }

    private static int[] getPlayerValidInput(char[][] matrix) {
        Scanner scanner = new Scanner(System.in);
        int[] coordinates = new int[2];
        boolean validCoordinatesInserted = false;
        while (!validCoordinatesInserted) {
            System.out.print("Enter the coordinates: ");
            validCoordinatesInserted = setValidNumericCoordinates(scanner, coordinates);
            if (!validCoordinatesInserted) {
                System.out.println("You should enter numbers!");
                scanner.nextLine();
                continue;
            }

            validCoordinatesInserted = areCoordinatesWithinBoundaries(coordinates);
            if (!validCoordinatesInserted) {
                System.out.println("Coordinates should be from 1 to 3!");
                scanner.nextLine();
                continue;
            }

            validCoordinatesInserted = isCellAvailable(coordinates, matrix);
            if (!validCoordinatesInserted) {
                System.out.println("This cell is occupied! Choose another one!");
                scanner.nextLine();
                continue;
            }
        }
        return coordinates;
    }

    private static boolean setValidNumericCoordinates(Scanner scanner, int[] coordinates) {
        if (scanner.hasNextInt()) {
            coordinates[0] = scanner.nextInt();
            coordinates[1] = scanner.nextInt();
            return true;
        }
        return false;
    }

    private static boolean areCoordinatesWithinBoundaries(int[] coordinates) {
        return isPositionWithinBoundaries(coordinates[0]) && isPositionWithinBoundaries(coordinates[1]);
    }

    private static boolean isCellAvailable(int[] coordinates, char[][] matrix) {
        int row = coordinates[0] - 1;
        int column = coordinates[1] - 1;
        int cellValue = matrix[row][column];
        return cellValue == ' ' || cellValue == '_';
    }

    private static boolean isPositionWithinBoundaries(int position) {
        return 1 <= position && position <= 3;
    }

    private static void placePlayerInputToMatrix(char player, int[] coordinates, char[][] matrix) {
        int row = coordinates[0] - 1;
        int column = coordinates[1] - 1;
        matrix[row][column] = player;
    }

    private static String getGameResult(char[][] matrix, char player) {
        boolean playerWon = validatePlayerWon(matrix, player);
        boolean isDraw = validateIsDraw(matrix);

        if (playerWon) {
            return player + " wins";
        } else if (isDraw) {
            return "Draw";
        } else {
            return "Game not finished";
        }
    }

    private static boolean validatePlayerWon(char[][] matrix, char player) {
        return isHorizontalWin(matrix, player)
                || isVerticalWin(matrix, player)
                || isDiagonalWin(matrix, player);
    }

    private static boolean isHorizontalWin(char[][] matrix, char player) {
        for (char[] row : matrix) {
            if (winInRow(row, player)) {
                return true;
            }
        }
        return false;
    }

    private static boolean winInRow(char[] rowValues, char player) {
        int hitCount = 0;
        for (char value : rowValues) {
            if (value == player) {
                hitCount++;
            }
        }
        return hitCount == 3;
    }

    private static boolean isVerticalWin(char[][] matrix, char player) {
        for (int column = 0; column < 3; column++) {
            int hitCount = 0;
            for (int row = 0; row < 3; row++) {
                if (matrix[row][column] == player) {
                    hitCount++;
                }
                if (hitCount == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isDiagonalWin(char[][] matrix, char player) {
        boolean isWinDiagonal1 = isWinDiagonal1(matrix, player);
        boolean isWinDiagonal2 = isWinDiagonal2(matrix, player);
        return isWinDiagonal1 || isWinDiagonal2;
    }

    private static boolean isWinDiagonal1(char[][] matrix, char player) {
        int hitCount = 0;
        for (int i = 0; i < 3; i++) {
            if (matrix[i][i] == player) {
                hitCount++;
            }
        }
        return hitCount == 3;
    }

    private static boolean isWinDiagonal2(char[][] matrix, char player) {
        return matrix[0][2] == player && matrix[1][1] == player && matrix[2][0] == player;
    }

    private static boolean validateIsDraw(char[][] matrix) {
        int xCount = getCountPerPlayer(matrix, 'X');
        int oCount = getCountPerPlayer(matrix, 'O');
        return xCount + oCount == 9;
    }

    private static int getCountPerPlayer(char[][] matrix, char player) {
        int count = 0;
        for (char[] row : matrix) {
            for (char value : row) {
                if (value == player) {
                    count++;
                }
            }
        }
        return count;
    }
}

