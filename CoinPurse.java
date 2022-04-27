package Hw1;
// Yuvan Rengifo
// I pledge my honor that I have abided by the Stevens Honor System.

public class CoinPurse{
	
	// data fields
	
	private int numGalleons;
	private int numSickles;						// 17 Sickles in a Galleon
	private int numKnuts;						//29 Knuts in a Sickle
	private static final int CAPACITY = 256;			//Max of 256 Coins
		
	//Constructors
	
	public CoinPurse() {

	}
	public CoinPurse(int g, int s, int k) {
		this.numGalleons = g;
		this.numSickles = s;
		this.numKnuts = k;
		}
	
	//Adding and Withdrawing
	
	/* Deposits n Galleons
	** unless user tries to input negative n 
	** or CAPACITY has been reached
	*/ 
	public void depositGalleons(int n) {	
		
		if(n < 0) {
			throw new IllegalArgumentException("Error: Can not deposit negative coins");
		
		}
		else if(numCoins() + n >= CAPACITY) {	
			throw new IllegalArgumentException("Error: Not enought space in the purse for more coins");
		}
		
		else{
			this.numGalleons += n;
		}
		
	}
	
	/* Deposits n Sickles
	** unless user tries to input negative n 
	** or CAPACITY has been reached
	*/ 
	public void depositSickles(int n) {														
		if(n < 0) {
			throw new IllegalArgumentException("Error: Can not deposit negative coins");
		}
		
		else if(numCoins() + n >= CAPACITY) {
			throw new IllegalArgumentException("Error: Not enought space in the purse for more coins");
		}
		
		else{
			this.numSickles += n;
		}
			
	}
	
	/* Deposits n Knuts
	** unless user tries to input negative n 
	** or CAPACITY has been reached
	*/ 
	public void depositKnuts(int n) {														
		if(n < 0) {
			throw new IllegalArgumentException("Error: Can not deposit negative coins");
		}
		else if(numCoins() + n >= CAPACITY) {
			System.out.println("Error: Not enought space in the purse for more coins");
		}
		else{
			this.numKnuts += n;
		}	
	}
	
	/* Withdraw n Galleons
	** unless there are nor enough coins 
	** in the purse
	*/ 
	public void withdrawGalleons(int n) {													
		
		if(this.numGalleons > 0 && n<=numGalleons ) {
			this.numGalleons -=n;
		}
		else {
			throw new IllegalArgumentException("Error: Not enought Galleons in the Purse to withdraw " + n + " coins");			
		}
	}
	
	/* Withdraw n Sickles
	** unless there are nor enough coins 
	** in the purse
	*/ 
	public void withdrawSickles(int n) {													
	
		if(this.numSickles > 0 && n<=numSickles) {
			this.numSickles -=n;
		}
		else {
			throw new IllegalArgumentException("Error: Not enought Sickles in the Purse to withdraw " + n + " coins");
		}
	}
	
	/* Withdraw n Knuts
	** unless there are nor enough coins 
	** in the purse
	*/ 
	public void withdrawKnuts(int n) {														
		
		if(this.numKnuts > 0 && n<=numKnuts) {	
			this.numKnuts -=n;
		}
		else {
			throw new IllegalArgumentException("Error: Not enought Knuts in the Purse to withdraw " + n + " coins");
		}
	}
	
	//Cumulative operations
	
	/*
	**@returns how many coins are in the purse
	*/
	public int numCoins() {
		return this.numGalleons + this.numKnuts + this.numSickles;
	}
	
	/*
	** @return the value of the purse
	*/
	public int totalValue() {	
		return (numGalleons*493) + (numSickles*29) + numKnuts ;
	}
	
	/*
	** @returns the number of each coin toString
	*/
	public String toString() {
		return "Galleons: " + this.numGalleons +"\n" + "Sickles: " + this.numSickles + "\n" + "Knuts: " + this.numKnuts ;
		
	}
	
	/* Check if the exact change put in by the user is correct
	** @returns true or false
	*/ 
	public boolean exactChange(int n) {
		if(n > totalValue() || n < totalValue()) {
			return false;
		}
		return true;
		}
}
