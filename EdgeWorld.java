/*
 * in this world logic, if the requested values fall out with  
 * the edges of the grid, the returned number is -1, which indicates a
 * non valid location in the world
 */

public class EdgeWorld extends World {
	
	private int columns;
	private int rows; 
	

	public EdgeWorld(int rows, int columns) {
		this.rows = rows; 
		this.columns = columns; 
		
		super.setRows(rows); 
		super.setColumns(columns);
		super.makeWorld();
		
	}
	
	public int getPossibleRow(int r){
		int newR;

		if (r < 0 || r >=rows) {
			newR = -1;		//return -1 to indicate an invalid location (off the edge of the world
			return newR;
		}

		return r; //return the original if the number is valid
	}
	
	
	public int getPossibleColumn(int c) {
		int newC;

		if (c < 0 || c >= columns) {
			newC = -1;		//return -1 to indicate an invalid location (off the edge of the world
			return newC;

		}
		return c; //return the original if the number is valid
	}

}

