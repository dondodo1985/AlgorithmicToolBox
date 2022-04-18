import java.util.Scanner;

public class ChangeDP {
	static final int INF=10000;
    private static int getChange(int m) {
        //write your code here
		int [] coins= {1,3,4};
		//ArrayList<Integer>minNumCoins= new ArrayList<Integer>();
		int[] minNumCoins=new int[m+1];
		minNumCoins[0]=0;
		for (int i=1;i<=m;i++){
			int numCoins=INF;
			for (int j=0;j<coins.length;j++) {
				if(i>=coins[j]) {
					numCoins=Math.min(numCoins, minNumCoins[i-coins[j]]+1);
					}
				} minNumCoins[i]=numCoins;
			}
		
        return minNumCoins[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
        scanner.close();;
    }
}

