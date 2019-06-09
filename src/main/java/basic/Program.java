package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program {

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void start() throws IOException {
        int f1, f2;
        System.out.println("enter first number of interval:");
        int startNumber = Integer.parseInt(br.readLine());
        System.out.println("and second number of interval:");
        int endNumber = Integer.parseInt(br.readLine());

        if (endNumber % 2 == 0) {
            f2 = endNumber;
            f1 = f2 - 1;
        } else {
            f1 = endNumber;
            f2 = f1 - 1;
        }

        odd(startNumber, endNumber);
        even(startNumber, endNumber);

        System.out.println("enter size of set:");
        int n = Integer.parseInt(br.readLine());

        fibonacci(n, f1, f2);
    }

    private void odd(int startNumber, int endNumber) {
        int sum = 0;
        System.out.print("odd numbers: \n[ ");
        for (int i = startNumber; i < endNumber; i++) {
            if ((i % 2) != 0) {
                System.out.print(i + " ");
                sum += i;
            }
        }
        System.out.println("]\nsum = " + sum);
    }

    private void even(int startNumber, int endNumber) {
        int sum = 0;
        System.out.print("even numbers: \n[ ");
        for (int i = endNumber; i > startNumber; i--) {
            if ((i % 2) == 0) {
                System.out.print(i + " ");
                sum += i;
            }
        }
        System.out.println("]\nsum = " + sum);
    }

    private void fibonacci(int n, int f1, int f2) {
        int f, evenPercent = 0;
        System.out.print("fibonacci numbers: \n[ ");
        for (int i = 0; i < n; i++) {
            f = f1 + f2;
            System.out.print(f + " ");
            if (f % 2 == 0) evenPercent++;
            f1 = f2;
            f2 = f;
        }
        System.out.println("]\n" +
                "percent of even = " + ((evenPercent*1.0) / n) * 100 + "%\n" +
                "percent of odd = " + (100 - (((evenPercent*1.0) / n) * 100)) + "%");
    }
}
