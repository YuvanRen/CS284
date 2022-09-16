//Name: Yuvan Rengifo
//I pledge my honor that I have abided by the Stevens Honor System.

public class Complexity {

	public static void method1(int n) {  //O(n^2)
		int counter = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {	
				System.out.println("Operation: " + counter);
				counter ++;
			}
		}
	}
	
	public static void method2(int n) {	 //O(n^3)
		int counter = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0 ; j < n; j ++) {	
				for(int k = 0; k < n; k++) {
				System.out.println("Operation: " + counter);
				counter ++;
				}
			}
		}
	}

	public static void method3(int n) {  //O(log n)
		int counter = 0;
		for (int i = 1; i < n; i = i * 2){
		    System.out.println("Operation: " + counter);
		    counter ++;
		    }
	}
	
	//Question 4:
	
	// Iteration | Start | end 		 Length of a = 32
	//  1        |  0    | 31  		|mid=(31-0)/2 + 0 = 15 + 1 = 16
	//  2        |  16   | 31  		|mid=(31-16)/2 + 16 = 23 + 1 = 24
	//  3        |  24   | 31 		|mid=(31-24)/2 + 24 = 27 + 1 = 28
	//  4        |  28   | 31 		|mid=(31-28)/2 + 28 = 29 + 1 = 30
	//  5        |  30   | 31  		|mid=(31-30)/2 + 30 = 30 + 1 = 31
 	//  6        |  31   | 32           	|mid=(31-31)/2 + 31 = 31 1 = 32
	                                                                              //ASK IF ALL ITERATIONS HAPPEN!!!
	// Iteration | Start | end  		Length of a = 64
	//  1        |  0    | 63 		|mid=(63-0)/2 + 0 = 31 + 1 = 32
	//  2        |  32   | 63 		|mid=(63-32)/2 + 32 = 47 + 1 = 48
	//  3        |  48   | 63  		|mid=(63-48)/2 + 48 = 55 + 1 = 56
	//  4        |  56   | 63 		|mid=(63-56)/2 + 56 = 59 + 1 = 60
	//  5        |  60   | 63  		|mid=(63-60)/2 + 60 = 61 + 1 = 62
	//  6        |  62   | 63 		|mid=(63-62)/2 + 62 = 62 + 1 = 63
	//  7        |  63   | 64            	|mid=(63-63/2 + 63 = 63 + 1 = 64
	
	//Question 5:
	
	// length of A doubled so the number of iterations went up by 1
	
	//Question 6:
	
	// O log(n)
	
	
	public static void method4(int n) { //O(n log n)
		int counter = 0;
		for(int i = 0; i < n; i++) {
		    for(int j = i; j > 0; j = j/2) {
		          System.out.println("Operation: " + counter);
		               counter++;
		          }
		    }
	 }
	
	public static void method5(int n) { //O(log log n)
		int counter = 0;
	       for(int i = n; i > 0; i = i/4) {
	           System.out.println("Operation: " + counter);
	           counter++;
	       }
	 }
}
