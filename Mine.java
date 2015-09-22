
import java.util.ArrayList;
import java.util.Random;

/////////////////////////////////////////////////////////////////////////////
//// The Mine class will create an array of size 10
//// And generate 10 random numbers between 1-100 and store them inside
//// With out duplicates, The 'Tiles' with these 'values' will be bombs
/////////////////////////////////////////////////////////////////////////////

public class Mine {
	
	////////////////////////////////////////////////////////////////////////
	// declares an array of integers
	////////////////////////////////////////////////////////////////////////
	
	private  ArrayList<Integer> bombArray = new ArrayList<Integer>(11);
	
	////////////////////////////////////////////////////////////////////////
	// Generates random integer between min and max params
	////////////////////////////////////////////////////////////////////////
    	
	public  int randInt(int min, int max) {

	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	/////////////////////////////////////////////////////////////////////////
	// Generate bombs loops 10 time creating a new random bomb value
	// and storing it in the array, ensuring no duplicate numbers are
	// stored
	/////////////////////////////////////////////////////////////////////////
	
		public  ArrayList<Integer> generateBombs(){
			bombArray.add(0);
			for (int i=1; i<11; i++){
			int t = randInt(1,100);
			
			for (int p=0; p<i;p++){
				if(t == bombArray.get(p)){
					t = randInt(1,100);
					p=0;
					System.out.println("Fuck you");
				}
			}
			bombArray.add(i, t);
			System.out.println(bombArray);
		}
			return bombArray;
	}

}	

