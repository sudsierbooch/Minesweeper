///////////////////////////////////////////////////////////////////
////  @author sudsierbooch
////  The Tile Class will set framework for the layout of the game board
////
//////////////////////////////////////////////////////////////////

public class Tile {
	
	////////////////////////////////////////////////////////////////////
	//Private Variables:
	// value; which number the tile is ie)box 1,2,3,4...
	// position; Where is the tile located ie) in the corner,side,middle?
	// isBomb; tells if the tile it a bomb or nah.
	////////////////////////////////////////////////////////////////////
	
		private int value;
		private String position;
		private boolean isBomb;
	
	///////////////////////////////////////////////////////////////////////
	// Constructor
	// Tile gets created with its position number t stored into value
	// and that value is used to determine its position
	///////////////////////////////////////////////////////////////////////	
		
		public Tile(int t, boolean y){
			value=t;
			position = getPos(t);
			isBomb=y;
		}
	
	///////////////////////////////////////////////////////////////////////
	// getVal()
	// simple accessor method to current tile's value variable
	///////////////////////////////////////////////////////////////////////	
		
		public int getVal(){
			return this.value;
		}
	
	///////////////////////////////////////////////////////////////////////
	// myPos()
	// simple accessor method to current tile's position variable
	///////////////////////////////////////////////////////////////////////		
		
		public String myPos(){
			return this.position;
		}
	
	///////////////////////////////////////////////////////////////////////
	// bomb()
	// returns if tile is bomb; true or flase.
	///////////////////////////////////////////////////////////////////////
	
		public boolean bomb(){
			return this.isBomb;
		}
			
	///////////////////////////////////////////////////////////////////////
	// getPos(int t)
	// Used to get the position of the tile by using its value variable as the parameter
	///////////////////////////////////////////////////////////////////////	
		
		public String getPos(int t){
		String pos="";
		if(t == 1 ||t == 10 ||t == 91 ||t == 100){
			if (t==1){
	            pos = "TLcorner";
	            return pos;
			}
	        else if (t==10){
	            pos = "TRcorner";
	            return(pos);
	        }
	        else if (t==91){
	            pos = "BLcorner";
	            return(pos);
	        }
	        else if (t==100){
	            pos = "BRcorner";
	            return(pos);
	        }  
		}		
		if(t== 92 || t==93||t==94||t==95||t==96||t==97||t==98||t==99){ 
	             pos = "Bedge";
	             return(pos);    
			}
	    if (t == 2 ||t== 3 ||t== 4 ||t== 5 ||t== 6 ||t== 7 ||t== 8 ||t== 9){ 
	             pos = "Tedge";
	             return(pos);       
	     	}
	    if(t == 11 ||t== 21 ||t== 31 ||t== 41 ||t== 51 ||t== 61 ||t== 71 ||t== 81){ 
	             pos = "Ledge";
	             return(pos);
	    	}        	         
	    if(t == 20|| t == 30|| t == 40|| t == 50|| t == 60|| t == 70|| t == 80|| t == 90){ 
	                 pos = "Redge";
	                 return pos;
	    	}         
	    else  
	             pos = "center";
	             return pos;
		}	       	     
		
}