import java.util.Scanner;

public class KnapsackWithoutRepetition {
	
	static int optimalWeight(int W, int[] w) {
        int [][]value = new int [W+1][w.length+1];
        value[0][0]=0;
        int val=0;
        int [] aw=convertArray(w);
        for(int j=1;j<=w.length;j++) {
			  value[0][j]=0;
				}
		  for(int i=1;i<=W;i++) {
				value[i][0]=0;
				}
		  for(int i=1;i<=w.length;i++) {
			 	for(int j=1;j<=W;j++) {
					value[j][i]= value[j][i-1];
					if(aw[i]<=j) {
						val=value[j- aw[i]][i-1]+aw[i];
							if(value[j][i]<val) {
								value[j][i]=val;
						}
				}
			}
		  }
        return value[W][w.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
        scanner.close();
    }
    public static int [] convertArray(int[] s) {
		int [] cs=new int[s.length+2];
		cs[0]=0;
		for(int i=1;i<=s.length;i++) {
			  cs[i]=s[i-1];
		  }
		return cs;
	}
}
