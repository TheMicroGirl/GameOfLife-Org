public abstract class World {
	
	private int rows;
	private int columns; 
	private Species [][] world; 

	
	public void makeWorld(){
		world = new Species[this.rows][this.columns]; 

	}
	
	/*
	 * places the organism into the world	
	 */
	public void colonise (int r, int c, Species organism) {
		world[r][c] = organism; 
	}
	
	
	/*
	 * depending on the type of logic the world exhibits ( in this exercise wrap world or
	 * edge world )dealing with requested locations, it will return the approperiate 
	 * and column
	 */
	public abstract int getPossibleRow(int r); 
	
	public abstract int getPossibleColumn(int c); 	
	
	
	/*
	 * Returns contents of the particular cell in the grid
	 */
	public Species getOrganism(int r, int c){
		Species creature = world[r][c];
		return creature ; 
	
	}
	/*
	 * prints the current state of the world
	 * empty cells are represented with 
	 * the "-"
	 */
	public void print(){
		
		synchronized(world) {
			int popcount = 0; 
			
			for (int i = 0; i<rows; i++){
				System.out.println();
				for (int j = 0; j<columns; j++){
					if (world[i][j] == null){
						System.out.print("-");
					}
					else{
						System.out.print(world[i][j].getSpecieName());
						popcount++; 
					}
				}
			}
			
			System.out.println("\n" + "Population in the world is " + popcount);	//counts the current population
		}
	}
	
	
	//setter area 
	
	public void setRows(int rows) {
		this.rows = rows;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}
}