package fibonacciNumber;

import java.util.*;

public class LCM {
  private static long lcm_recursive(int a, int b) {
    
    return (long) a * b/gcd_recursive(a,b);
  }
  private static int gcd_recursive(int a, int b) {
     if (a == 0)
                return b;
        
    return gcd_recursive(b % a, a);
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    scanner.close();    
    System.out.println(lcm_recursive(a, b));
  }
}

