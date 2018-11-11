package battleShip;

public abstract class Ship {

	private int bowRow;
	private int bowColumn;
	private int length;
	private boolean horizontal;
	private boolean[] hit;
	
	public int getBowRow() {
		return bowRow;
	}
	public void setBowRow(int bowRow) {
		this.bowRow = bowRow;
	}
	public int getBowColumn() {
		return bowColumn;
	}
	public void setBowColumn(int bowColumn) {
		this.bowColumn = bowColumn;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public boolean isHorizontal() {
		return horizontal;
	}
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}
	public boolean[] getHit() {
		return hit;
	}
	public void setHit(boolean[] hit) {
		this.hit = hit;
	}
	
	public abstract String getShipType();
	
	public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		
		int gridSize = ocean.getShipArray()[0].length;
		
		if (horizontal) {
			// overflow off grid
			if (column < 0 || column > gridSize - getLength()) {
				return false;
			}
			// check for ship overlaps
			for (int i = column, j = getLength() + column; i < j; i++) {
				if (ocean.getShipArray()[row][i].getShipType() != "empty") {
					return false;
				}
			}
			// check for ship touches
			int above = row - 1;
			int below = row + 1;
			int left = column - 1;
			int right = column + getLength();
			
			
			if (above >= 0) {
				for (int i = column, j = getLength() + column; i < j; i++) {
					if (ocean.getShipArray()[above][i].getShipType() != "empty") {
						return false;
					}
				}
			}
			if (below <= 19) {
				for (int i = column, j = getLength() + column; i < j; i++) {
					if (ocean.getShipArray()[below][i].getShipType() != "empty") {
						return false;
					}
				}
			}
			if (left >= 0) {
				if (ocean.getShipArray()[row][left].getShipType() != "empty") {
					return false;
				}
			}
			if (left >= 0 && above >= 0) {
				if (ocean.getShipArray()[above][left].getShipType() != "empty") {
					return false;
				}
			}
			if (left >= 0 && below <= 19) {
				if (ocean.getShipArray()[below][left].getShipType() != "empty") {
					return false;
				}
			}
			if (right <= 19) {
				if (ocean.getShipArray()[row][right].getShipType() != "empty") {
					return false;
				}
			}
			if (right <= 19 && above >= 0) {
				if (ocean.getShipArray()[above][right].getShipType() != "empty") {
					return false;
				}
			}
			if (right <= 19 && below <= 19) {
				if (ocean.getShipArray()[below][right].getShipType() != "empty") {
					return false;
				}
			}
			
			return true;
			
		} else {
			// overflow off grid
			if (row < 0 || row > gridSize - getLength()) {
				return false;
			}
			// check for ship overlaps
			for (int i = row, j = getLength() + row; i < j; i++) {
				if (ocean.getShipArray()[i][column].getShipType() != "empty") {
					return false;
				}
			}
			// check for ship touches
			int above = row - 1;
			int below = row + getLength();
			int left = column - 1;
			int right = column + 1;
			
			
			if (above >= 0) {
				if (ocean.getShipArray()[above][column].getShipType() != "empty") {
					return false;
				}
			}
			if (below <= 19) {
				if (ocean.getShipArray()[below][column].getShipType() != "empty") {
					return false;
				}
			}
			if (left >= 0) {
				for (int i = row, j = getLength() + row; i < j; i++) {
					if (ocean.getShipArray()[i][left].getShipType() != "empty") {
						return false;
					}
				}
			}
			if (left >= 0 && above >= 0) {
				if (ocean.getShipArray()[above][left].getShipType() != "empty") {
					return false;
				}
			}
			if (left >= 0 && below <= 19) {
				if (ocean.getShipArray()[below][left].getShipType() != "empty") {
					return false;
				}
			}
			if (right <= 19) {
				for (int i = row, j = getLength() + row; i < j; i++) {
					if (ocean.getShipArray()[i][right].getShipType() != "empty") {
						return false;
					}
				}
			}
			if (right <= 19 && above >= 0) {
				if (ocean.getShipArray()[above][right].getShipType() != "empty") {
					return false;
				}
			}
			if (right <= 19 && below <= 19) {
				if (ocean.getShipArray()[below][right].getShipType() != "empty") {
					return false;
				}
			}

			return true;
		}
	}
	
	public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		setBowRow(row);
		setBowColumn(column);
		setHorizontal(horizontal);
		
		if (horizontal) {
			for (int i = column, j = getLength() + column; i < j; i++) {
				ocean.getShipArray()[row][i] = this;
			}
		} else {
			for (int i = row, j = getLength() + row; i < j; i++) {
				ocean.getShipArray()[i][column] = this;
			}
		}
	}
	
	 public boolean shootAt(int row, int column) {
		 if (isSunk()) return false;
		 
		 if (horizontal) {
			 if (row == getBowRow() && column >= getBowColumn() && column < getBowColumn() + getLength()) {
				 hit[column - getBowColumn()] = true;
				 return true;
			 }
		 } else {
			 if (column == getBowColumn() && row >= getBowRow() && row < getBowRow() + getLength()) {
				 hit[row-getBowRow()] = true;
				 return true;
			 }
		 }
		 return false;
		 
	 }
	 
	 public boolean isSunk() {
		 for (int i = 0, j = getLength(); i < j; i++) {
			 if (!hit[i]) {
				 return false;
			 }
		 }
		 return true;
	 }
	 
	 @Override
	 public String toString() {
		 if (isSunk()) {
			 return "x";
		 } else {
			 return "S";
		 }
	 }
	
}
