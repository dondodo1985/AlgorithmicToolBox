import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
            return a[left];
        }
        //write your code here
        int low = 0, high = a.length,count=0,result=-1;
        double mid=(double)a.length/2;
        //write your code here
        Arrays.sort(a);
        for(int i=0;i<a.length;i++) {
        	count=countDuplicates(a ,low,high,a[i]) ;
        	//System.out.println(count);
        	if(count>mid) return result=1;
        }
        return result;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
 public static int binarySearchComplete(int[]a,int low,int high,int x) {
    	
    	if(high==low)/*(high<1)*/ return -1;
   	 	int mid=low +(high-low)/2;
   	 	if (x==a[mid]) return mid;
   	 	else if(x<a[mid]) return binarySearchComplete(a,low,mid-1,x);
   	 	return binarySearchComplete(a,mid+1,high,x);
   	 
   	 }
    public static int countDuplicates(int[]a ,int low,int high,int x) {
    	int count=0;
    	int index=binarySearchComplete(a,low,high-1,x);
    	if (index==-1) return count;
    	count=1;
    	int highAux=index-1;
    	while(highAux>=0 && a[highAux]==x) {
    		highAux--;
    		count++;
       	}
    	int lowAux=index+1;
    	while(lowAux<a.length && a[lowAux]==x) {
    		count++;
    		lowAux++;
       	}
    	return count;
    }
}

