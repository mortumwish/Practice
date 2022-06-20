package main.java;

public class Program {
    public static void main(String[] a) {
        sumOfMultiplies();
        fibonacciEvenSum();
    }

    public static void sumOfMultiplies(){
        int sum3and5 = 0;
        int sum4and7 = 0;
        for (int i = 0; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum3and5 = sum3and5 + i;
            } else if (i % 4 == 0 || i % 7 == 0) {
                sum4and7 = sum4and7 + i;
            }
        }
        System.out.println("Sum of 3 and 5: " + sum3and5);
        System.out.println("Sum of 4 and 7: " + sum4and7 + "\n");
    }

    public static void fibonacciEvenSum() {
        int previous = 0;
        int current = 1;
        int sum = 0;
        for (int next; (previous + current) < 4_000_000; ) {
            next = previous + current;
            if (next > 100 && current < 100) {
                System.out.println("sum of even below 100: " + sum);
            }
            if (next % 2 == 0) {
                sum = sum + next;
            }
            previous = current;
            current = next;
        }
        System.out.println("sum of even below 4.000.000: " + sum);
    }
}
