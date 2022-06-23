package main.java.task_1_2;

public class Program {
    public static void main(String[] a) {
        System.out.println("Sum of all the multiples of 3 or 5 below 1000: " + getSumOfNaturalMultiples(3,5));
        System.out.println("Sum of all the multiples of 4 or 7 below 1000: " + getSumOfNaturalMultiples(4,7));
        System.out.println("Sum of even below 100: " + getSumOfEvenFibonacciNumbers(100));
        System.out.println("Sum of even below 4.000.000: " + getSumOfEvenFibonacciNumbers(4_000_000));
    }

    public static int getSumOfNaturalMultiples(int divider1, int divider2){
        int sum = 0;
        for (int i = 0; i < 1000; i++) {

            if (i % divider1 == 0 || i % divider2 == 0) {
                sum = sum + i;
            }
        }
        return sum;
    }

    public static int getSumOfEvenFibonacciNumbers(int maxValueOfFibonacciTerm) {
        int previous = 1;
        int current = 2;
        int next = previous + current;
        int sum = 2;
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