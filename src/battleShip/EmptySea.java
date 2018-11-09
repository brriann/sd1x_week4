package battleShip;

public class EmptySea extends Ship{

	public EmptySea() {
		this.setLength(1);
	}
	
	@Override
	public boolean shootAt(int row, int column) {
		return false;
	}
	
	@Override
	public boolean isSunk() {
		return false;
	}
	
	@Override
	public String toString() {
		// any single-char representation of empty sea
		return "_";
	}
	
	@Override
	public String getShipType() {
		return "empty";
	}
}
