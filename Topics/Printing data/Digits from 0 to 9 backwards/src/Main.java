class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.print("Number " + i + " on: ");
            if (i % 2 == 0) {
                System.out.println("paaris arv");
            } else {
                System.out.println("paaritu arv");
            }
        }
        System.out.println("Finito!!!");
    }
}