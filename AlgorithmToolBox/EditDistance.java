
import java.util.Scanner;

public class EditDistance {
	  public static int editDistance(String s, String t) {
		  //write your code here
		  s=s.toLowerCase();
		  t=t.toLowerCase();
		  char [] cs=convertChar(s);
		  char [] ct=convertChar(t);
		  int [][] D= new int [s.length()+1][t.length()+1];
		  D[0][0]=0;
		  for(int j=1;j<=t.length();j++) {
			  D[0][j]=j;
				}
		  for(int i=1;i<=s.length();i++) {
				D[i][0]=i;
				}
		for(int j=1;j<=t.length();j++) {
			for(int i=1;i<=s.length();i++) {
				if(cs[i]==ct[j]) {
					//System.out.println("Equal ="+cs[i]+" "+ct[j]+" : ");
					D[i][j]=minBetween(D[i][j-1]+1,(D[i-1][j]+1),D[i-1][j-1]);
				} else 
					//System.out.println("Not "+cs[i]+" "+ct[j]+" : ");
					D[i][j]=minBetween(D[i][j-1]+1,D[i-1][j]+1,D[i-1][j-1]+1);
			 }
		}  
    return D[s.length()][t.length()];
  }
	  
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(editDistance(s, t));
    scan.close();;
  }
	public static int minBetween(int s1,int s2,int s3) {
		int min=0;
		if (s1<=s2 && s1<=s3) min=s1;
		if (s2<=s1 && s2<=s3) min=s2;
		if (s3<=s1 && s3<=s2) min=s3;
	return min;	
	}
	
	public static char [] convertChar(String s) {
		char [] cs=new char[s.length()+2];
		cs[0]=' ';
		for(int i=1;i<=s.length();i++) {
			  cs[i]=s.charAt(i-1);
		  }
		return cs;
	}
}
