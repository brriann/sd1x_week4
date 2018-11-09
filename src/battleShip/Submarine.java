package battleShip;

public class Submarine extends Ship {

	public Submarine() {
		setLength(3);
		setHit(new boolean[getLength()]);
	}
	
	@Override
	public String getShipType() {
		return "submarine";
	}
}
