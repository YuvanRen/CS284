import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MultiplayerGameTest {

	@Test
	public void testSize() {
		MultiplayerGame t1 = new MultiplayerGame(3);
		t1.addGamePiece(0, "Vandal", 40);
		t1.addGamePiece(0, "Operator", 150);
		t1.addGamePiece(1, "Phantom", 39);
		t1.addGamePiece(2, "Sheriff", 55);
		assertEquals(t1.size(), 4);
	}
}
