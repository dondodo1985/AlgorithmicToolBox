import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        //write your code here
    	if(m>1000 || m<0) return -1;
		int count_100=0,count_10=0,count_5=0,count_1=0;
		if (m>100){
			count_100=m/100;
			m=m%100;
		}
		if(m>0) {
			
			if (m>10){
				count_10=m/10;
				m=m%10;
			}if(m>0) {
				if(m>=5){
					count_5=m/5;
					m=m%5;
				} if(m>0 && m<5) {
					count_1=m;
					
				}
			}
   		}
        return count_100*10+count_10+count_5+count_1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        scanner.close();
        System.out.println(getChange(m));

    }
}

