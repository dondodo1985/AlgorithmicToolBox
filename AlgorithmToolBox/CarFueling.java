import java.util.Scanner;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
    	int currentRefill=0,numRefills=0;
    	int lim=tank;
    	int n =stops.length;
    	
    	while(lim<dist) {
    		if (currentRefill>=n || stops[currentRefill]>lim) {
    			return -1;
    		}
    		//find the farthest stop 
    		while(currentRefill<n-1 && stops[currentRefill+1]<=lim) {
    			currentRefill++;
    		}
    		numRefills++;
    		lim=stops[currentRefill]+tank;
    		currentRefill++;
    		
    	}
        return numRefills;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }
        System.out.println(computeMinRefills(dist, tank, stops));
        scanner.close();
    }
}
