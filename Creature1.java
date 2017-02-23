

public class Creature1 extends Species {

	public final String NAME = "1"; 
	private final int MAX_LIFESPAN = 10; 
	private final double FITNESS = 0.8; 
	
	public Creature1(int row, int column, World world) {
	
		
		//set values for each creature and pass it to the superclass Species
		super.setCreatureName(this.NAME);
		super.generateLifespan(this.MAX_LIFESPAN);
		super.setFitness(this.FITNESS);
		super.setWorld(world);
		super.setRow(row); 
		super.setColumn(column); 
		
	}


	@Override
	/*
	 * @see Species#getSpecie(int, int, World)
	 * returns its creature type
	 */
	public Species getCreature(int r, int c, World world) {
		Species sp = new Creature1(r,c, world); 
		
		return sp; 
	}
	
		
}
