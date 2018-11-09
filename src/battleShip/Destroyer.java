package battleShip;

public class Destroyer extends Ship{

	public Destroyer() {
		setLength(4);
		setHit(new boolean[getLength()]);
	}
	
	@Override
	public String getShipType() {
		return "destroyer";
	}
}
