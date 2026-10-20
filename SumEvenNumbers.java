public class SumEvenNumbers {
    public static void main(String[] args) {

        int i = 2;
        int sum = 0;

        while (i <= 50) {
            sum = sum + i;
            i = i + 2;
        }

        System.out.println("Sum = " + sum);
    }
}