package battleShip;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShipTest {
	public Ocean ocean;
	public Submarine sub;
	public Submarine sub2;
	public BattleShip bship;
	public BattleShip bship2;

	@BeforeEach
	void setUp() throws Exception {
		ocean = new Ocean();
		sub = new Submarine();
		bship = new BattleShip();
		sub2 = new Submarine();
		bship2 = new BattleShip();
	}

	@Test
	void testOkToPlaceShipAt() {
		
		// literal corner cases
		assertTrue(sub.okToPlaceShipAt(0, 0, true, ocean));
		assertFalse(sub.okToPlaceShipAt(0, 19, true, ocean));
		
		// place 1 ship, place other in proximity
		sub.placeShipAt(1, 2, true, ocean);
		assertFalse(sub2.okToPlaceShipAt(0, 2, true, ocean));
		assertFalse(sub2.okToPlaceShipAt(0, 0, true, ocean));
		assertFalse(sub2.okToPlaceShipAt(2, 0, true, ocean));
		
		assertFalse(sub2.okToPlaceShipAt(0, 5, true, ocean));
		assertFalse(sub2.okToPlaceShipAt(1, 5, true, ocean));
		assertFalse(sub2.okToPlaceShipAt(2, 5, true, ocean));
		
		assertFalse(sub2.okToPlaceShipAt(2, 1, false, ocean));
		
		// place 1 ship, place other on top of 1st
		assertFalse(sub2.okToPlaceShipAt(1, 2, false, ocean));
		assertFalse(sub2.okToPlaceShipAt(1, 3, false, ocean));
		assertFalse(sub2.okToPlaceShipAt(1, 4, false, ocean));
	}

	@Test
	void testPlaceShipAt() {
		
		bship.placeShipAt(0, 0, true, ocean);
		for (int i = 0, j = bship.getLength(); i < j; i++) {
			assertEquals(bship, ocean.getShipArray()[0][i]);
		}
		
		sub2.placeShipAt(7, 7, false, ocean);
		for (int i = 7, j = 7 + sub2.getLength(); i < j; i++) {
			assertEquals(sub2, ocean.getShipArray()[i][7]);
		}
	}

	@Test
	void testShootAt() {
		
		bship.placeShipAt(0, 0, true, ocean);
		bship.shootAt(0, 0);
		assertEquals(bship.getHit()[0], true);
		for (int i = 1, j = bship.getLength(); i < j; i++) {
			assertEquals(bship.getHit()[i], false);
		}
		
		bship2.placeShipAt(5, 10, false, ocean);
		bship2.shootAt(10, 10);
		assertEquals(bship2.getHit()[5], true);
		for (int i = 0; i < 5; i++) {
			assertEquals(bship2.getHit()[i], false);
		}
		assertEquals(bship2.getHit()[6], false);
		assertEquals(bship2.getHit()[7], false);
	}

	@Test
	void testIsSunk() {
		assertEquals(bship.isSunk(), false);
		for (int i = 0, j = bship.getLength(); i < j; i++) {
			bship.getHit()[i] = true;
		}
		assertEquals(bship.isSunk(), true);
	}

	@Test
	void testToString() {
		assertEquals(bship.toString(), "S");
		for (int i = 0, j = bship.getLength(); i < j; i++) {
			bship.getHit()[i] = true;
		}
		assertEquals(bship.toString(), "x");
	}

}
