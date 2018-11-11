package battleShip;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Ocean {

	private Ship[][] ships;
	private int shotsFired;
	private int hitCount;
	private int shipsSunk;
	
	private EmptySea empty;
	
	private BattleShip battleship;
	private BattleCruiser battlecruiser;
	private Cruiser cruiser1;
	private Cruiser cruiser2;
	private LightCruiser lightcruiser1;
	private LightCruiser lightcruiser2;
	private Destroyer destroyer1;
	private Destroyer destroyer2;
	private Destroyer destroyer3;
	private Submarine submarine1;
	private Submarine submarine2;
	private Submarine submarine3;
	private Submarine submarine4;
	
	private ArrayList<Ship> gameships;
	
	private boolean[][] attempts;
	
	public Ocean() {
		
		// initialize to all empty sea, zero out game variables
		ships = new Ship[20][20];
		empty = new EmptySea();
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				ships[i][j] = empty;
			}
		}
		
		shotsFired = hitCount = shipsSunk = 0;
		
		battleship = new BattleShip();
		battlecruiser = new BattleCruiser();
		cruiser1 = new Cruiser();
		cruiser2 = new Cruiser();
		lightcruiser1 = new LightCruiser();
		lightcruiser2 = new LightCruiser();
		destroyer1 = new Destroyer();
		destroyer2 = new Destroyer();
		destroyer3 = new Destroyer();
		submarine1 = new Submarine();
		submarine2 = new Submarine();
		submarine3 = new Submarine();
		submarine4 = new Submarine();
		
		gameships = new ArrayList<Ship>();
		
		gameships.add(battleship);
		gameships.add(battlecruiser);
		gameships.add(cruiser1);
		gameships.add(cruiser2);
		gameships.add(lightcruiser1);
		gameships.add(lightcruiser2);
		gameships.add(destroyer1);
		gameships.add(destroyer2);
		gameships.add(destroyer3);
		gameships.add(submarine1);
		gameships.add(submarine2);
		gameships.add(submarine3);
		gameships.add(submarine4);
		
		attempts = new boolean[20][20];
	}
	
	public void placeAllShipsRandomly() {
		for (Ship ship : gameships) {
			
			int row = -1;
			int col = -1;
			boolean horiz = true;
			
			while (!ship.okToPlaceShipAt(row, col, horiz, this)) {
				row = ThreadLocalRandom.current().nextInt(0, 20);
				col = ThreadLocalRandom.current().nextInt(0, 20);
				horiz = ThreadLocalRandom.current().nextBoolean();
			}
			ship.placeShipAt(row, col, horiz, this);
		}
	}
	
	public boolean isOccupied(int row, int column) {
		return ships[row][column] != empty;
	}
	
	boolean shootAt(int row, int column) {
		shotsFired += 1;
		attempts[row][column] = true;
		Ship ship = ships[row][column];
		if (ship.getShipType() != "empty" && !ship.isSunk()) {
			hitCount += 1;
			ship.shootAt(row, column);
			if (ship.isSunk()) {
				shipsSunk += 1;
			}
			return true;
		}
		return false;
	}
	
	public int getShotsFired() {
		return shotsFired;
	}
	
	public int getHitCount() {
		return hitCount;
	}
	
	public int getShipsSunk() {
		return shipsSunk;
	}
	
	public boolean isGameOver() {
		return shipsSunk == 13;
	}
	
	Ship[][] getShipArray() {
		return ships;
	}
	
	public void printCheat() {
		System.out.print("  ");
		for (int i = 0; i < 10; i ++) {
			System.out.print(" " + i + " ");
		}
		for (int i = 10; i < 20; i ++) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		for (int i = 0; i < 10; i++) {
			System.out.print(i + " ");
			for(int j = 0; j < 20; j++) {
				System.out.print(" " + ships[i][j].toString() + " ");
			}
			System.out.println();
		}
		for (int i = 10; i < 20; i++) {
			System.out.print(i);
			for(int j = 0; j < 20; j++) {
				System.out.print(" " + ships[i][j].toString() + " ");
			}
			System.out.println();
		}
	}
	
	public void print() {
		System.out.print("  ");
		for (int i = 0; i < 10; i ++) {
			System.out.print(" " + i + " ");
		}
		for (int i = 10; i < 20; i ++) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		for (int i = 0; i < 10; i++) {
			System.out.print(i + " ");
			for(int j = 0; j < 20; j++) {
				printCell(i, j);
			}
			System.out.println();
		}
		for (int i = 10; i < 20; i++) {
			System.out.print(i);
			for(int j = 0; j < 20; j++) {
				printCell(i, j);
			}
			System.out.println();
		}
	}
	
	public void printCell(int row, int col) {
		System.out.print(" ");
		if (!attempts[row][col]) {
			System.out.print(".");
		} else {
			if (ships[row][col].getShipType() == "empty") {
				System.out.print("-");
			} else if (ships[row][col].isSunk()) {
				System.out.print("x");
			} else {
				System.out.print("S");
			}
		}
		System.out.print(" ");
	}
}
