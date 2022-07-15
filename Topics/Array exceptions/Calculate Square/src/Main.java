
class FixingExceptions {

    public static void calculateSquare(int[] array, int index) {
        try {
            System.out.println(array[index] * array[index]);
        } catch (Exception e) {
            Sys tem.out.println("Exception!");
        }
    }
}