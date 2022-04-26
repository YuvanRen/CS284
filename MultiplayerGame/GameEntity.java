package hw3;
public abstract class GameEntity {
	
	protected GameEntity prev;
	protected GameEntity next;
	public GameEntity() {
	
	}
	public abstract boolean isGamePlayer();
	public abstract int size();
	public abstract String getName();
}
