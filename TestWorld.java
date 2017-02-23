import java.util.Random;

public class TestWorld {

	public static void main(String[] args) {
	
		//set the world up
		int ROWS = 10; 
		int COLUMNS = 20; 
		
		World earth = new EdgeWorld(ROWS, COLUMNS); //uses the edgeworld logic
		//World earth = new WrapWorld(ROWS, COLUMNS); //uses the wrapworld logic
		Random rn = new Random();
	
		/*
		* for simple population 
		* creation of the for loops below is usefull as it allows 
		*to easity adjust the starting population.
		*/
		
		for(int i = 0; i <1; i++){
			//create random positions on the grid for Creature1
			int r = rn.nextInt(ROWS);
			int c = rn.nextInt(COLUMNS);
			
			//create a new Species of type Creature 1 
			Species sp = new Creature1(r,c, earth);
			
			//colonise the world
			earth.colonise(r, c, sp);
			sp.start();
		}
		
		//CREATURE2
		for(int i = 0; i <1; i++){
			//create random positions on the grid for Creature 2
			int r = rn.nextInt(ROWS);
			int c = rn.nextInt(COLUMNS);
			
			//create a new Species of type Creature2 
			Species sp = new Creature2(r,c, earth); 
			
			//colonise the world
			earth.colonise(r, c, sp);
			sp.start();
		}
		//and watch the world go wild
		for(;;){
			try{
				Thread.sleep(500); //prints screen every 0.5 seconds
				earth.print();
			}
			catch(InterruptedException e) {
					System.out.println("oh no, something went wrong");		
			}
		}
	}
}