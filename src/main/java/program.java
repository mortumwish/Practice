package main.java;

public class program {
    public static void main(String[] a) {
        FiboNum(1, 2, 2); // первые два члена последовательности и сумма четных среди 1 и 2
    }

    public static void FiboNum(int num1, int num2, int sum) {
        int fibNum = num1 + num2;
        //System.out.println(fibNum); // отображение последовательности
        if (fibNum % 2 == 0) {
            sum = sum + fibNum;
        }
        if (num2 + fibNum < 4000000) {
            FiboNum(num2, fibNum, sum);
        } else System.out.println("sum of the even-valued terms: " + sum);
    }
}