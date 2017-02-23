/*
 * in this world logic, if the requested values fall out with  
 * the edges of the grid, the grid is treated as if it wraps around itself, 
 * where 0 and the grid length or breadth meet therefore providing a continual 
 * movement. The returned values are always positive and within the edges scope 
 * of the grid.
 */

public class WrapWorld extends World {
	
	private int columns;
	private int rows; 
	

	public WrapWorld(int rows, int columns) {
		this.rows = rows; 
		this.columns = columns; 
		
		super.setRows(rows); 
		super.setColumns(columns);
		super.makeWorld();
		
	}
	
	public int getPossibleRow(int r){
		int newR;

		if (r < 0) {
			newR = rows + r;
			return newR;      //return the opposite end of the grid
		}

		if (r >= rows) {
			newR = r - rows; //return the opposite end of the grid
			return newR;

		}

		return r; //return the original if the number is valid
	}
	
	
	public int getPossibleColumn(int c) {
		int newC;

		if (c < 0) {
			newC = columns + c;
			return newC; 		//return the opposite end of the grid

		}

		if (c >= columns) {
			newC = c - columns;	//return the opposite end of the grid
			return newC;

		}

		return c; 	//return the original if the number is valid
	}

}
