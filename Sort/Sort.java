package Hw5;
//	Yuvan Rengifo
//	I pledge my honor that I have abided by the Stevens Honor System.

public class Sort {
	
	private static <T> void swap(T[] lst, int i, int g) {
        T temp = lst[i];
        lst[i] = lst[g];
        lst[g] = temp;
}
	private static <T extends Comparable<T>> int partition(T[] array, int lower, int upper){
       swap(array, lower, upper);
       T pivot = array[lower];
       int up = lower; 
       int down = upper;
       	do
            {
              while((up < down) && pivot.compareTo(array[up]) >= 0){
                   up++;
             }
             while(pivot.compareTo(array[down]) < 0){
                   down--;
             }
             if(up < down){
                   swap(array, up, down);
                }

            }
       		while(up < down);
       			swap(array, lower, down);
       			return down;
     }
	private static class Interval{
		
	private int lower;
	private int upper;
	
	public  Interval(int lower , int upper) {
		this.lower = lower;
		this.upper = upper;
	}
	
	public int getLower() {	
		return lower;					// returns the lower bound
	}
	public int getUpper() {		
		return upper; 					// returns the upper bound
	}
	public boolean equals(Object o) {
		return ((Interval) o).getLower() == this.lower && ((Interval) o).getUpper() == this.upper;	// returns true if this interval and
	}													//the given interval have the same lower and upper bounds
									
	public int hashCode () {
		return lower * lower + upper;	// returns lower * lower + upper
	}
}
}



