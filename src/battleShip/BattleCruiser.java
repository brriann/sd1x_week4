package battleShip;

public class BattleCruiser extends Ship {

	public BattleCruiser() {
		setLength(7);
		setHit(new boolean[getLength()]);
	}
	
	@Override
	public String getShipType() {
		return "battlecruiser";
	}
}
