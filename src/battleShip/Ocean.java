package battleShip;

public class Ocean {

	private Ship[][] ships = new Ship[20][20];
	private int shotsFired;
	private int hitCount;
	private int shipsSunk;
	
	public Ocean() {
		
		// initialize to all empty sea, zero out game variables
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				ships[i][j] = new EmptySea();
			}
		}
		
		shotsFired = hitCount = shipsSunk = 0;
	}
	
	public void placeAllShipsRandomly() {
		
	}
	
	public boolean isOccupied(int row, int column) {
		
	}
	
	boolean shootAt(int row, int column) {
		
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
	
	public void print() {
		
	}
	
}
