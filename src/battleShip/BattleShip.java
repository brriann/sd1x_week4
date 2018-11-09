package battleShip;

public class BattleShip extends Ship {

	public BattleShip() {
		setLength(8);
		setHit(new boolean[getLength()]);
	}
	
	@Override
	public String getShipType() {
		return "battleship";
	}
}
