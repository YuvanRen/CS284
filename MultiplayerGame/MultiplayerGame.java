// Yuvan Rengifo
// I pledge my honor that I have abided by the Stevens Honor System.

public class MultiplayerGame {
	
	private GameEntity turnTracker;
	private GameEntity[] index;
	
	public MultiplayerGame(int n) {			// Creates a game with n number of players
        index = new GameEntity[n];
        for( int i = 0; i < n; i++) {
        	index[i]= new GamePlayer(null,null, i);
        	
        }
        	
        for(int i= 0 ; i<= n-1; i++) {   
        	if(i==0) {
        		index[i].next=index[i+1];   
        		index[i].prev=index[n-1];
        		}
        	else if(i == n-1){
        		index[i].next = index[0];
        		index[i].prev = index[i-1];
        	}else {
        	index[i].prev = index[i-1];
        	index[i].next = index[i+1];
        	}
        }
        }

    public int size() {						//Keep track of the number of pieces that are being played.
        int n= 0;
        for(int i = 0; i <= index.length - 1; i++) { 			
            GameEntity current = index[i];
        while(current.prev.isGamePlayer() == false) {
            n++;
            current = current.prev;
        }
    } 
    return n;
}
    public void addGamePiece(int playerId, String name, int strength) {
       
        if(playerId > index.length) {
            throw new IllegalArgumentException("addGamePiece: no such player");
        }
        GameEntity current = index[playerId];
        while( current.prev.isGamePlayer() == false) {
        if(current.prev.getName().equals(name)) {
            throw new IllegalArgumentException("addGamePiece: duplicate entity");
        } current = current.prev;
        
        }
            current.prev = new GamePiece(current.prev, current , name, strength);
    }

    public void removeGamePiece(int playerId, String name) {
        GameEntity current = index[playerId];
        if(playerId >= index.length) {
            throw new IllegalArgumentException("removeGamePiece: no such player");
        }
        while(current.prev.isGamePlayer() == false){
        	if(current.prev.getName().equals(name)) {
            	current.prev=current.prev.prev;
            	current.prev.next = current;
            	return;
            	}
        	if(current.prev.prev.isGamePlayer() == true);
            throw new IllegalArgumentException("removeGamePiece: Entity does not exist");
        }
        	
        	current = current.prev;
       	}
        
	public boolean hasGamePiece(String name) {
		for(int i = 0; i < index.length; i++) {
        	GameEntity current = index[i];
        while(current.prev.isGamePlayer() == false) {
        	if(current.prev.getName().equals(name)) {
        		return true;
        	}
        	current = current.prev;
        }
        }
    	return false;
		
	}
	
	public void removeAllGamePieces(int playerId) {
	if(playerId >= index.length) {
		throw new IllegalArgumentException("removeAllGamePieces: no such player");
	}
	 if(playerId == 0) {
     	index[playerId].prev = index[index.length -1];
     	index[index.length -1].next = index[playerId];
     }
     else {
     	index[playerId].prev = index[playerId-1];
     	index[playerId-1].next = index[playerId];
     }
		
	}
	
	public void increaseStrength(int playerId, int n){
        GameEntity current = (GamePiece)index[playerId].prev;
        while(current.isGamePlayer() == false){
           ((GamePiece)current).updateStrength(n);
            current = current.prev;
        }
    }
	
	public String toString() {
		String SST = "";
        for(int i = 0; i <= index.length - 1; i++){
            GameEntity current = index[i];
            SST += current.getName() + " ";
            while(current.prev.isGamePlayer() == false){
                SST += current.prev.toString() + ", ";
                current = current.prev;
            }
            SST += "\n";
        }
        return SST;
	}
	public void initializeTurnTracker() {
		turnTracker = index[0];
	}
	public void nextPlayer() {
		if(turnTracker.isGamePlayer() == false) {
	        while(turnTracker.isGamePlayer() == false){
	            turnTracker = turnTracker.next;
	        }
	        turnTracker = turnTracker.next;
	    }

	    while(turnTracker.next.isGamePlayer() == false){
	        turnTracker = turnTracker.next;
	    }
	    turnTracker = turnTracker.next;
	}	
	public void nextEntity() {
		turnTracker = turnTracker.next;
	}
	public void prevPlayer() {
		if(turnTracker.isGamePlayer() == false) {
	        while(turnTracker.isGamePlayer() == false){
	            turnTracker = turnTracker.prev;
	        }
	        turnTracker = turnTracker.prev;
	    }

	    while(turnTracker.prev.isGamePlayer() == false){
	        turnTracker = turnTracker.prev;
	    }
	    turnTracker = turnTracker.prev;
	}
	public String currentEntityToString() {
        return turnTracker.toString();
	}
