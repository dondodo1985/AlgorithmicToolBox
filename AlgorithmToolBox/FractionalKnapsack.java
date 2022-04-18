import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
    	  	
    	Double value = 0.000d;
        int lengthN= weights.length;
        ItemValue[]item=new ItemValue[lengthN];
        for(int i=0;i<lengthN;i++) {
        	item[i]=new ItemValue(weights[i],values[i]);
        }
        //sorting by value
        Arrays.sort(item,new Comparator<ItemValue>() {
        	@Override
        	public int compare(ItemValue o1, ItemValue o2) {
        		return o2.cost.compareTo(o1.cost);
        	}
        });
       
		Double [] array = new Double[lengthN];
		for (int i=0;i<lengthN;i++) {
			if (capacity==0) return value;
			else {
				array[i]=item[i].getValue()/item[i].getWeight();
				Double a= Math.min(item[i].getWeight(),capacity);
				value+=(Double) a*array[i];
				capacity-=(Double)a;
				weights[i]-=a;
			}
		} 
        return withFourDecimal(value);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        scanner.close();
        System.out.println(getOptimalValue(capacity, values, weights));
    }
    
    @SuppressWarnings("deprecation")
	public static double withFourDecimal(double value) {
    	DecimalFormat df= new DecimalFormat("#.0000");
    			return new Double(df.format(value));
    }
    
    static class ItemValue{
    	private Double cost;
    	private double weight,value;
    	
    	@SuppressWarnings("deprecation")
		public ItemValue(int weight,int value) {
    		this.weight=weight;
    		this.value=value;
    		    		cost=new Double((double)value/(double)weight);
    	}
    	public double getWeight() {
    		return this.weight;
    	}
    	public double getValue() {
    		return this.value;
    	}
    }
    
} 
 


