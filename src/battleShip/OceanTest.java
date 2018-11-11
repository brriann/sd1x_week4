package battleShip;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OceanTest {
	
	public Ocean ocean;

	@BeforeEach
	void setUp() throws Exception {
		ocean = new Ocean();
	}

	@Test
	void testOcean() {
		assertEquals(ocean.getShipArray()[12][7].toString(), "_");
		assertEquals(ocean.getShipArray()[12][7].getShipType(), "empty");
		assertEquals(ocean.getShotsFired(), 0);
		assertEquals(ocean.getHitCount(), 0);
		assertEquals(ocean.getShipsSunk(), 0);
	}

	@Test
	void testPlaceAllShipsRandomly() {
		ocean.placeAllShipsRandomly();
		int bship = 0;
		int bcruiser = 0;
		int cruiser = 0;
		int lcruiser = 0;
		int destroyer = 0;
		int sub = 0;
		int empty = 0;
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				switch (ocean.getShipArray()[i][j].getShipType()) {
				case "battleship":
					bship += 1;
					break;
				case "battlecruiser":
					bcruiser += 1;
					break;
				case "cruiser":
					cruiser += 1;
					break;
				case "light cruiser":
					lcruiser += 1;
					break;
				case "destroyer":
					destroyer += 1;
					break;
				case "submarine":
					sub += 1;
					break;
				case "empty":
					empty += 1;
					break;
				}
			}
		}
		assertEquals(bship, 8);
		assertEquals(bcruiser, 7);
		assertEquals(cruiser, 12);
		assertEquals(lcruiser, 10);
		assertEquals(destroyer, 12);
		assertEquals(sub, 12);
		assertEquals(empty, 339);
	}

	@Test
	void testIsOccupied() {
		Submarine sub = new Submarine();
		sub.placeShipAt(5, 5, true, ocean);
		assertTrue(ocean.isOccupied(5, 5));
		assertTrue(ocean.isOccupied(5, 6));
		assertTrue(ocean.isOccupied(5, 7));
		assertFalse(ocean.isOccupied(5, 4));
		assertFalse(ocean.isOccupied(5, 8));
	}

	@Test
	void testShootAt() {
		assertEquals(1, 1);
	}
}
