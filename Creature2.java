public class Creature2 extends Species {

	public final String NAME = "2"; 
	private final int MAX_LIFESPAN = 5; 
	private final double FITNESS = 0.4;

	public Creature2(int row, int column, World world) {

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
		Species sp = new Creature2(r,c, world); 
		
		return sp; 
	}
	
		
}
