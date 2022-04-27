package Hw1;
// Yuvan Rengifo
// I pledge my honor that I have abided by the Stevens Honor System.

public class CoinPurse{
	
	// data fields
	
	private int numGalleons;
	private int numSickles;								// 17 Sickles in a Galleon
	private int numKnuts;								//29 Knuts in a Sickle
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
	
	public void depositGalleons(int n) {													//GalleonsDeposit
		
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
	
	public void depositSickles(int n) {														//SicklesDeposit
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
	
	public void depositKnuts(int n) {														//KnutsDeposit
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
	
	public void withdrawGalleons(int n) {													//GalleonsWithdrawl
		
		if(this.numGalleons > 0 && n<=numGalleons ) {
			this.numGalleons -=n;
		}
		else {
			throw new IllegalArgumentException("Error: Not enought Galleons in the Purse to withdraw " + n + " coins");			
		}
	}
	
	public void withdrawSickles(int n) {													//SickelsWithdrawl
	
		if(this.numSickles > 0 && n<=numSickles) {
			this.numSickles -=n;
		}
		else {
			throw new IllegalArgumentException("Error: Not enought Sickles in the Purse to withdraw " + n + " coins");
		}
	}
	
	public void withdrawKnuts(int n) {														//KnutsWithdrawl
		
		if(this.numKnuts > 0 && n<=numKnuts) {	
			this.numKnuts -=n;
		}
		else {
			throw new IllegalArgumentException("Error: Not enought Knuts in the Purse to withdraw " + n + " coins");
		}
	}
	
	//Cumulative operations
	
	public int numCoins() {
		return this.numGalleons + this.numKnuts + this.numSickles;
	}
	
	public int totalValue() {	
		return (numGalleons*493) + (numSickles*29) + numKnuts ;
	}
	public String toString() {
		return "Galleons: " + this.numGalleons +"\n" + "Sickles: " + this.numSickles + "\n" + "Knuts: " + this.numKnuts ;
		
	}
	
	//Exact Change
	
	public boolean exactChange(int n) {
		if(n > totalValue() || n < totalValue()) {
			return false;
		}
		return true;
		}
}
