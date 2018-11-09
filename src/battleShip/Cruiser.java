package battleShip;

public class Cruiser extends Ship {

	public Cruiser() {
		setLength(6);
		setHit(new boolean[getLength()]);
	}
	
	@Override
	public String getShipType() {
		return "cruiser";
	}
}
