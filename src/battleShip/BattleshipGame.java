package battleShip;

public class BattleshipGame {

	private Ocean ocean;
	
	public static void main(String[] args) {
		BattleshipGame game = new BattleshipGame();
		game.ocean = new Ocean();
		game.ocean.placeAllShipsRandomly();
		game.ocean.printCheat();
	}
	
	
	// set up the game
	// accept shots from user
	// display results
	// print final scores
	// play again?
}