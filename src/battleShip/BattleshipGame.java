package battleShip;

import java.util.Scanner;

public class BattleshipGame {

	private Ocean ocean;
	
	public static void main(String[] args) {
		BattleshipGame game = new BattleshipGame();
		game.gameStart();
		
		Scanner scanner = new Scanner(System.in); 
		
		while (game.ocean.getShotsFired() < 25) {
			game.acceptInput(scanner.nextLine());
			game.ocean.print();
		}
		scanner.close();
		game.ocean.print();
		game.ocean.printCheat();

	}
	
	public void gameStart() {
		
		ocean = new Ocean();
		ocean.placeAllShipsRandomly();
		
		System.out.println("Welcome to Battleship.");
		System.out.println("5 shots per turn. You get 5 turns.");
		System.out.println("Enter your shots as 1,1;2,2;3,3;4,4;5,5;");
		System.out.println("After each turn, results will be displayed.");
		System.out.println("At the end of game, ship positions will be revealed.");
		System.out.println("Input 'q' to Quit.");
	}
	
	public void acceptInput(String playerShots) {
		if (playerShots.equals("q")) {
			System.out.println("*****QUITTER*****");
			System.out.println("*****QUITTER*****");
			System.out.println("*****QUITTER*****");
			System.out.println("*****QUITTER*****");
			System.exit(0);
			return;
		}
		String[] shotPairs = playerShots.split(";");
		for (String shot : shotPairs) {
			String[] rowCol = shot.split(",");
			int row = Integer.parseInt(rowCol[0]);
			int col = Integer.parseInt(rowCol[1]);
			ocean.shootAt(row, col);
		}
	}
}




// initial unit testing main method

/*		BattleshipGame game = new BattleshipGame();
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
scanner.close();*/
	
