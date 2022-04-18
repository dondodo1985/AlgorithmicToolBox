package fibonacciNumber;

import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib(int n) {
    if (n <= 1)
      return n;

    return fibonacciArray(n);
  }
  
  private static long fibonacciArray(int n) {
	  long [] array= new long[n+1];
	  long result = 0;
	  if(array.length == 0) return -1;
	  if(array.length == 1)
	      {
	          result=1;
	          return 1;
	      }
	  array[0] = 0;
	  array[1] = 1;
	  for (int i = 2;i < array.length; i++) 
	      {
	          array[i] = array[i-1] + array[i-2];
	          result = array[i];
	       }
	  return result;
	  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    System.out.println(calc_fib(n));
    in.close();
  }
}
