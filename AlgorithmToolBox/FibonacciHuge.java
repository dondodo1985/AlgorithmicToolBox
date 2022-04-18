package fibonacciNumber;

import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) {
			// Getting the period
		long pisanoPeriod = pisano(m);
		 
		n = n % pisanoPeriod;
		 
		long prev = 0;
		long curr = 1;
		 
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		 
		for(int i = 0; i < n - 1; i++)
		{
			long temp = 0;
			temp = curr;
			curr = (prev + curr) % m;
			prev = temp;
		}
		return curr % m;
    }
	
	public static long pisano(long m)
{
		long prev = 0;
		long curr = 1;
		long res = 0;
		 
		for(int i = 0; i < m * m; i++)
		{
			long temp = 0;
			temp = curr;
			curr = (prev + curr) % m;
			prev = temp;
			 
			if (prev == 0 && curr == 1)
				res= i + 1;
		}
		//System.out.println("res"+res);
		//if (res>9) res = res %10;
		return res;
}
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        scanner.close();;
        System.out.println(getFibonacciHugeNaive(n, m));
    }
}

