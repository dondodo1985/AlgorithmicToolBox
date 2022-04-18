package fibonacciNumber;

import java.util.ArrayList;
import java.util.Scanner;

public class FibonacciSumLastDigit {

    private static long getFibonacciSum(long n) {
        if (n <= 2) return n;
        ArrayList<Long> pisanoPeriod = getPisanoPeriod(10);
        long pisanoSum = 0, pisanoPartialSum = 0;
        long pisanoPeriodLength = (long)pisanoPeriod.size();
        long remainder = n % pisanoPeriodLength;
        for (int i = 0; i < pisanoPeriodLength; i++) {
            pisanoSum = (pisanoSum + pisanoPeriod.get(i)) % 10;
            if (i == remainder) {
                pisanoPartialSum = pisanoSum;
            }
        }
        return ((pisanoSum * (n / pisanoPeriodLength)) + pisanoPartialSum) % 10;
    }
    
    private static ArrayList<Long> getPisanoPeriod(int m) {
        ArrayList<Long> pisanoPeriod = new ArrayList<Long>();
        long a = 0, b = 1, c;
        pisanoPeriod.add(a);
        pisanoPeriod.add(b);
        int i = 2;
        while (true) {
            c = (a + b) % m;
            if (c == 1 && b == 0) break;
            pisanoPeriod.add(c);
            a = b;
            b = c;
            i++;
        }
        pisanoPeriod.remove(i - 1);
        return pisanoPeriod;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSum(n);
        System.out.println(s);
        scanner.close();
    }
}
