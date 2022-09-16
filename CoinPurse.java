import java.util.Random;

public class CoinPurse {

//Yuvan Rengifo
// I pledge my honor that I have abided by the Stevens Honor System.
		
//Data fields
		
	private int numGalleons;
	private int numSickles;				// 17 Sickles = 1 Galleons
	private int numKnuts;				// 29 Knuts = 1 Sickle 
		
	private static final int CAPACITY = 256;
		
	//Constructors 
		
	public CoinPurse() {
		numGalleons = 0;
		numSickles = 0;
		numKnuts = 0;
		
	}
		
	public CoinPurse(int g, int s, int k) {
		numGalleons = g;
		numKnuts = k;
		numSickles = s;
		
		if (g + s + k > CAPACITY) {
			throw new IllegalArgumentException("Coin limit exceeded.");			
		}
		
		if (g < 0 || s < 0 || k < 0) {
			throw new IllegalArgumentException("Purse cant hold negative values");
		}
	}
		
	/* Deposit Constructors
	** deposit n coins unless user tries 
	** to input negative n or CAPACITY has been reached
	*/ 
		
	public void depositGalleons(int n) {
		if(n < 0) {
			throw new IllegalArgumentException("Error: Can not deposit negative coins");
			
		}
		else if(numCoins() + n > CAPACITY) {	
			throw new IllegalArgumentException("Error: Not enought space in the purse for more coins");
		}
			
		else{
			numGalleons += n;
		}
			
	}
		
	public void depositSickles(int n) {
		if(n < 0) {
			throw new IllegalArgumentException("Error: Can not deposit negative coins");
		}
			
		else if(numCoins() + n > CAPACITY) {
			throw new IllegalArgumentException("Error: Not enought space in the purse for more coins");
		}
			
		else{
			numSickles += n;
		}
	}
		
	public void depositKnuts(int n) {
			
		if(n < 0) {
			throw new IllegalArgumentException("Error: Can not deposit negative coins");
		}
			
		else if(numCoins() + n > CAPACITY) {
			throw new IllegalArgumentException("Error: Not enought space in the purse for more coins");
		}
			
		else{
			numKnuts += n;
		}
	}
		
	/* Withdrawer constructors
	** remove n coins unless  
	** there are not enough coins in the purse
	*/ 
		
	public void withdrawGalleons(int n) {
		
		if (n < 0){
			throw new IllegalArgumentException("Error: Cannot Withdraw a negative ammount of coins.");		
		}
			
		else if (numGalleons > 0 && n<=numGalleons) {
			this.numGalleons -=n;
			}
		else {
			throw new IllegalArgumentException("Error: Not enought Galleons in the Purse to withdraw " + n + " coins");
		}
			
			
		}
	public void withdrawSickles(int n) {
			
		if (n < 0){
			throw new IllegalArgumentException("Error: Cannot Withdraw a negative ammount of coins.");
		}
			
		else if(numSickles > 0 && n<=numSickles) {
			this.numSickles -=n;			
		}
			
		else {
			throw new IllegalArgumentException("Error: Not enought Sickles in the Purse to withdraw " + n + " coins");
		}
	}
		
	public void withdrawKnuts(int n) {
			
		if (n < 0){
			throw new IllegalArgumentException("Error: Cannot Withdraw a negative ammount of coins.");		
		}
			
		else if(numKnuts > 0 && n<=numKnuts) {	
			this.numKnuts -=n;		
		}
			
		else {
			throw new IllegalArgumentException("Error: Not enought Knuts in the Purse to withdraw " + n + " coins");
		}
	}
		
	//returns how many coins are in the purse
		
	public int numCoins() {
		return numGalleons + numKnuts + numSickles;
			
	}
		
	// returns Value of all coins
		
	public int totalValue() {
		return (493*numGalleons) + numKnuts + (29*numSickles);
	}
		
	public String toString() {
		return "Galleons: " + numGalleons +"\n" + "Sickles: " + numSickles + "\n" + "Knuts: " + numKnuts ;
	}
		
	public boolean exactChange(int n) {
		int galleons = numGalleons;
		int sickles = numSickles;
		int knuts = numKnuts;
		if(n== 0) {
			return true;
		}
			
		while(n >= 493 && galleons > 0) {
			n -= 493;
			galleons --;
			if(n == 0) {
				return true;
			}
			}
			
		while(n >= 29 && sickles > 0) {
			n -= 29;
			sickles --;
			if(n == 0) {
				return true;
			}
		}
			
		while(n > 0 && knuts > 0) {
			n--;
			knuts --;
			if(n == 0) {
				return true;
			}
		}
		return false;
	}
	
	//Return Array of withdrawn Coins
	public int[] withdraw(int n) {
		  int[] w = {0,0,0};
	        int gCount = numGalleons;
	        int sCount = numSickles;
	        int kCount = numKnuts;
	        if(n > 126208) {
	            throw new IllegalArgumentException("Your coin purse can't hold that amount!");
	        }
	        if(exactChange(n) == true) {
	        while(n >= 493 && gCount > 0) {
	            n -= 493;
	            gCount --;
	            w[0] = w[0] + 1;
	        }
	        while(n >= 29 && sCount > 0) {
	            n -= 29;
	            sCount --;
	            w[1] = w[1] + 1;
	        }
	        while(n > 0 && kCount > 0) {
	            n--;
	            kCount --;
	            w[2] = w[2] + 1;
	            }
	    numGalleons = numGalleons - w[0];
	    numSickles = numSickles - w[1];
	    numKnuts = numKnuts - w[2];   
	    return w;
	        }
	else {
		while((n >= 493) && (n > 29)) {
			n -= 493;
			w[0] = w[0] + 1;
		}
		while(n > 1){
			n -= 29;
			w[1] = w[1] + 1;
		}
		while(n == 1) {
			n--;
			w[2] = w[2] + 1;
			}
		return w;
		}
	}

	//Game Of Chance
		
	public int drawRandCoin() {
			
		if (numCoins() == 0) {
			System.out.println("There are no Coins in Purse!");
			}
		//Create a Random Coin
			
		Random r = new Random();
		float randomFloat = r.nextFloat() * numCoins();
		if (randomFloat < numGalleons) {
			return 2;
				
		} else if (randomFloat < numGalleons + numKnuts) {
			return 0;
				
		} else {
			return 1;
		}
	}
		
	public int[] drawRandSequence(int n) {
		//Error if no coins in purse
			
		int[] Array = new int[n];
			
		if (numCoins() == 0) {
			System.out.println("There are no Coins in Purse!");
			return new int[] {};
			} 
			
		for (int i = 0; i < n; i++) {
			Array[i] = drawRandCoin();
		}
		return Array;			
	}
	/* Collects 2 Sequences in an array
	 * 	The function compares them
	 */
	public static int compareSequences(int[] coinSeq1, int[] coinSeq2) {
		int coin1Score = 0;
		int coin2Score = 0;
		if (coinSeq1.length != coinSeq2.length) {
		System.out.println("Given Sequence lengths are not the same!");
		} 
		for (int i = 0; i<coinSeq1.length; i++) {
			if (coinSeq1[i] > coinSeq2[i]) {
				coin1Score ++;
			}
			if (coinSeq1[i] < coinSeq2[i]) {
				coin2Score ++;
			}
		}
		if (coin1Score > coin2Score) {
			return 1;
			} else if (coin1Score < coin2Score) {
				return -1;
			} else {
				return 0;
			}
		}
		
	
	
	public static void main(String[] args) {
		CoinPurse l = new CoinPurse(1,2,8);
		int[]arr = l.withdraw(559);
		//System.out.println(arr[0]);
		//System.out.println(arr[1]);
		//System.out.println(arr[2]);
		System.out.println(l.toString());
		//System.out.println(l.withdraw(559));
		}
}
