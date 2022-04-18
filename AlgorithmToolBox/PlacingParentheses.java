import static java.lang.Math.max;
import static java.lang.Math.min;

import java.util.Scanner;


public class PlacingParentheses {
    private static long getMaximValue(String exp) {
       	long[] arrayDigits = digits(exp);
        char[] arrayOperands = operands(exp);
        int size = arrayDigits.length;
    	long[][] minimum = new long [size][size];
    	long[][] Maximum = new long [size][size];
    	for (int i=0; i<size; i++) {
    		minimum[i][i] = arrayDigits[i];
    		Maximum[i][i] = arrayDigits[i];
    				}
    	for (int s=1; s<size; s++) {
    		for (int i=1;i<=(size-s);i++) {
    			int j=i+s;
    			minimum[i-1][j-1]=MinAndMax(i-1,j-1,arrayOperands,Maximum,minimum).getFirst();
    			Maximum[i-1][j-1]=MinAndMax(i-1,j-1,arrayOperands,Maximum,minimum).getSecond();
        		}
    	} 		
             return Maximum[0][size-1];
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
        scanner.close();    
        }
    
    static Result MinAndMax(int i,int j ,char [] arr, long [][]M,long [][]m) {
    	long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
    	for(int k=i;k<=(j-1);k++) {
	    	long a=eval(M[i][k],M[k+1][j],arr[k]);
	    	long b=eval(M[i][k],m[k+1][j],arr[k]);
	    	long c=eval(m[i][k],M[k+1][j],arr[k]);
	    	long d=eval(m[i][k],m[k+1][j],arr[k]);
	    	min=minBetween(min,a,b,c,d);
	    	max=maxBetween(max,a,b,c,d);
       	}
    	
    	return new Result(min,max);
    }
    static long minBetween(long s1,long s2,long s3,long s4 ,long s5) {
		    	return min(s5, min(s4, min(s3, min(s1,s2))));
	}
    
    static long maxBetween(long s1,long s2,long s3,long s4 ,long s5) {
		    	return max(s5, max(s4, max(s3, max(s1,s2))));
	}
    
    private static char[] operands(String exp) {
        char[] operands = new char[exp.length() / 2];
        int counter = 0;
        for (int i = 1; i < exp.length(); i = i + 2) {
            operands[counter++] = exp.charAt(i);
        }
        return operands;
    }

    private static long[] digits(String exp) {
        long[] digits = new long[(exp.length() / 2) + 1];
        int counter = 0;
        for (int i = 0; i < exp.length(); i = i + 2) {
            String s = String.valueOf(exp.charAt(i));
            digits[counter++] = Integer.parseInt(s);
        }
        return digits;
    }
    
    
}

	final class Result{
		private  long first;
		private  long second;
		
		public Result(long first,long second) {
			this.first=first;
			this.second=second;
		}
		
		public long getFirst() {
			return this.first;
		}
		
		public long getSecond() {
			return this.second;
		}
}