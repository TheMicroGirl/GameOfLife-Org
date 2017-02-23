import java.util.Random;

public abstract class Species extends Thread	{

	private String name; 
	private int lifespan; 
	private double fitness; 
	private World world; 
	private int row; 
	private int column; 
	
		
	//generates a random lifespan based on the max_lifespan of the species
	public void generateLifespan(int MAX_LIFESPAN){
		Random rn = new Random();
		this.lifespan = rn.nextInt(MAX_LIFESPAN + 1); 
		
	}
		
	public void run(){
		//allows the creature to live and then reproduce unless it's
		//Interrupted - then the creature dies and does not reproduce
		
		try{
			Thread.sleep(this.lifespan * 1000);
			Reproduce(); 
		}
		catch(InterruptedException e){	
			//if you are interrupted do nothing.
		}
		
		
	}
	
	public void murder(){
		this.interrupt();
	}
	
	/*
	 * Handles the process of logic behind where to reproduce
	 * by interacting with the World class. 
	 * This logic is based on the 3x3 grid around the creature as
	 * Possible reproduction spaces
	 * 
	 */

	private void Reproduce(){
	
		synchronized(world) {
			
			boolean selfReproduce = false;	

			for (int i = -1; i < 2; i++) {
				for (int j = -1; j < 2; j++) {
						
					int newRow = world.getPossibleRow(row + i);				//returns the possible location based on the logic
																					//supplied in the WrapWorld or EdgeWrold Classes
					int newColumn = world.getPossibleColumn(column + j);
							
					if (newRow >= 0 && newColumn >= 0) { //only allows for positive numbers as possible locations. if the number is negative, the
																	//creature does not reproduce
								
						Species creature = world.getOrganism(newRow, newColumn);  //returns the organism in the specific position
						
						if (creature == null) {			//if the grid is empty work out the probability of placing the offspring there
							if (Math.random() <= fitness) {
								populate(newRow, newColumn);
							}
						} 
									
						else {
							if (Math.random() <= (fitness - creature.getFitness())) { //decide if to murder the creature and reproduce

								if (newRow == row && newColumn == column) {
									selfReproduce = true; 	
								}

									creature.murder();
									populate(newRow, newColumn);
							}

						}
								
					}

				}

			}
			
					
			if (selfReproduce == false) { //if you don't reproduce over yourself in the grid, clear the grid point after death
					world.colonise(row, column, null);
			}			
		}
	}
	
	
	
	/*
	 * Please the creature in the world and start the thread
	 */
	private void populate(int r, int c){
		Species sp1 = getCreature(r, c, world);
		world.colonise(r, c, sp1);
		sp1.start();
		
		
		
	}

	/*
	 * Depending on which Creature Class is extending species, it will have to return
	 * its creature type
	 */
	public abstract Species getCreature(int r, int c, World world);

	
	//Getter and Setter Area
	
	
	public String getCreatureName() {
		return this.name;
	}

	public void setCreatureName(String name) {
		this.name = name;
	}

	public double getFitness() {
		return this.fitness;
	}

	public void setFitness(double fitness) {
		this.fitness = fitness;
	}

	public void setRow(int row) {
		this.row = row; 
		
	}
	
	public void setColumn(int column) {
		this.column = column; 
		
	}

	public void setWorld(World world) {
		this.world = world;
	}
}
