package battleShip;

import java.util.Scanner;

public class BattleshipGame {

	private Ocean ocean;
	
	public static void main(String[] args) {
		BattleshipGame game = new BattleshipGame();
		game.ocean = new Ocean();
		game.ocean.placeAllShipsRandomly();
		game.ocean.printCheat();
		game.ocean.print();
		
		Scanner scanner = new Scanner(System.in);
		
		int counter = 0;
		int row = 0;
		int col = 0;
		
		while (counter < 50) {
			row = scanner.nextInt();
			col = scanner.nextInt();
			if (row > 0 && row < 20 && col > 0 && col < 20) {
				game.ocean.shootAt(row, col);
			}
			counter++;
			game.ocean.printCheat();
			game.ocean.print();
		}
		scanner.close();
		
	}
}
	
