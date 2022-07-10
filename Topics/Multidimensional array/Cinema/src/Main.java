import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int seats = scanner.nextInt();
        int[][] cinema = createCinemaWithSoldSeats(scanner, rows, seats);
        int ticketsToBuy = scanner.nextInt();
        int availableRow = getAvailableRow(cinema, ticketsToBuy);
        System.out.println(availableRow);
    }

    private static int[][] createCinemaWithSoldSeats(Scanner scanner, int rows, int seats) {
        int[][] cinema = new int[rows][seats];
        for (int r = 0; r < rows; r++) {
            for (int s = 0; s < seats; s++) {
                cinema[r][s] = scanner.nextInt();
            }
        }
        return cinema;
    }

    private static int getAvailableRow(int[][] cinema, int ticketsToBuy) {
        int availableRow = 1;
        for (int[] seatRow : cinema) {
            boolean available = seatRowIsAvailableForTickets(ticketsToBuy, seatRow);
            if (available) {
                return availableRow;
            }
            availableRow++;
        }
        return 0;
    }

    private static boolean seatRowIsAvailableForTickets(int ticketsToBuy, int[] seatRow) {
        boolean available = false;
        for (int seat = 0; seat < seatRow.length; seat++) {
            available = consecutiveSeatsAvailableFromThisSeat(ticketsToBuy, seatRow, seat);
            if (available) {
                break;
            }
        }
        return available;
    }

    private static boolean consecutiveSeatsAvailableFromThisSeat(int ticketsToBuy, int[] seatRow, int fromSeat) {
        int availableSeatCounter = 0;
        for (int seat = fromSeat; seat < seatRow.length; seat++) {
            if (seatRow[seat] == 0) {
                availableSeatCounter++;
                if (availableSeatCounter == ticketsToBuy) {
                    return true;
                }
            } else {
                availableSeatCounter = 0;
            }
        }
        return false;
    }
}