package main.java;

public class Program {
    public static void main(String[] a) {
        System.out.println("Sum of all the multiples of 3 or 5 below 1000: " + sumOfMultipliers(3,5));
        System.out.println("Sum of all the multiples of 4 or 7 below 1000: " + sumOfMultipliers(4,7));
        System.out.println("Sum of even below 100: " + fibonacciEvenSum(100));
        System.out.println("Sum of even below 4.000.000: " + fibonacciEvenSum(4_000_000));
    }

    public static int sumOfMultipliers(int multiplie1, int multiplie2){
        int sum = 0;
        for (int i = 0; i < 1000; i++) {

            if (i % multiplie1 == 0 || i % multiplie2 == 0) {
                sum = sum + i;
            }
        }
        return sum;
    }

    public static int fibonacciEvenSum(int maxValueOfFibonacciTerm) {
        int previous = 0;
        int current = 1;
        int next = 0;
        int sum = 0;
        while (previous + current < maxValueOfFibonacciTerm){
            next = previous + current;
            if (next % 2 == 0) {
                sum = sum + next;
            }
            previous = current;
            current = next;
        }
        return sum;
    }
}