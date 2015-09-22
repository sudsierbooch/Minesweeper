import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
//////////////////////////////////////////////////////////////////////////////
//// @author sudsierbooch
//// Mapmarker initializes the game
//// Makes frame, generates buttons and bombs, attaches listeners
//// Creates arraylist for Jbuttons and Tiles.
//////////////////////////////////////////////////////////////////////////////
public class Mapmaker {

	public Mapmaker(){
		//Create the window for the game as well as the layout and size
		JFrame frame = new JFrame("MineSweeper");
		JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10,10));
        frame.add(panel);
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        //Create a Mine and generate bombs returning arraylist of 10 random bombs
        Mine m = new Mine();
        //bomb list
        ArrayList<Integer> a = m.generateBombs();
        //tile list
        ArrayList<Tile> tl = new ArrayList<Tile>();
        //button list
        ArrayList<JButton> bl = new ArrayList<JButton>();
        //create 100 buttons
        for(int i=1; i<=101; ++i){
	
	
        	if(a.contains(i)){
        		final int k = i;
        		//create bomb tile
        		Tile t;
        		t = new Tile(k-1,true);
        		//create button
        		JButton button = new JButton();
        		//add bomb-tile to Arraylist
        		tl.add(t);
        		button.addActionListener(new ActionListener(){
			
        			@Override
        			public void actionPerformed(ActionEvent e) {
        				button.setBackground(Color.RED);
        			}
        		});
        		//add button to panel, add button to button arraylist
        		button.setText(" ");
        		panel.add(button);
        		bl.add(button);
        	}else{
        		// Create non-bomb tile
        		Tile t;
        		//need a final int since i changes
        		final int k = i;
        		t = new Tile(k-1,false);
        		//Create the button
        		JButton button = new JButton();
        		//add the tile into the arrayList 
        		tl.add(t);
        		button.addActionListener(new ActionListener(){
			
        			@Override
        			public void actionPerformed(ActionEvent e) {
        				button.setBackground(Color.GREEN);
        				button.setText(""+howMany(tl,tl.get(k).getPos(k),tl.get(k).getVal()));
         			}
        		});
	///////////////////////////////////////////////////////////////////////////
	// If button is the 101th button dont actually add it.
	// we need it for avoiding index out of bounds
	///////////////////////////////////////////////////////////////////////////
        		if(!(i==101)){
        			button.setText(" ");
        			panel.add(button);
        			bl.add(button);
        		}
		
        		}
	
        	}

		}
		/////////////////////////////////////////////////////////////////////
		// howMany(ArrayList<Tile> t, String s, int v )
		// determines amount of bombs surrounding a tile, returns an int 
		// which is given as a text to the tile. 
		//@param t = List of tiles to pull value and boolean is bomb value
		//@param s = String to determine current position of clicked tile
		//@param v = value of current tile to determine which #s surround it
		/////////////////////////////////////////////////////////////////////
		public int howMany(ArrayList<Tile> t, String s, int v ){
			int total = 0;
			if(s=="TLcorner"){
				int k = v;
				if(t.get(k).bomb()){
					total=total+1; 
				}
				if(t.get(k+10).bomb()){
					total=total+1;
				}
				if(t.get(k+9).bomb()){
					total=total+1;
				}
			}
			if(s=="Tedge"){
				int k = v;
				if(t.get(k-2).bomb()){
					total=total+1; 
				}
				if(t.get(k).bomb()){
					total=total+1;
				}
				if(t.get(k+8).bomb()){
					total=total+1;
				}
				if(t.get(k+9).bomb()){
					total=total+1;
				}
				if(t.get(k+10).bomb()){
					total=total+1;
				}
			}
			if(s=="TRcorner"){
				int k = v;
				if(t.get(k-2).bomb()){
					total=total+1; 
				}
				if(t.get(k+8).bomb()){
					total=total+1;
				}
				if(t.get(k+9).bomb()){
					total=total+1;
				}
				
			}
			if(s=="BLcorner"){
				int k = v;
				if(t.get(k).bomb()){
					total=total+1; 
				}
				if(t.get(k-10).bomb()){
					total=total+1;
				}
				if(t.get(k-11).bomb()){
					total=total+1;
				}
				
			}
			if(s=="BRcorner"){
				int k = v;
				if(t.get(k-2).bomb()){
					total=total+1; 
				}
				if(t.get(k-12).bomb()){
					total=total+1;
				}
				if(t.get(k-11).bomb()){
					total=total+1;
				}
				
			}
			if(s=="Bedge"){
				int k = v;
				if(t.get(k-2).bomb()){
					total=total+1; 
				}
				if(t.get(k).bomb()){
					total=total+1;
				}
				if(t.get(k-11).bomb()){
					total=total+1;
				}
				if(t.get(k-12).bomb()){
					total=total+1;
				}
				if(t.get(k-10).bomb()){
					total=total+1;
				}
			}
			if(s=="Ledge"){
				int k = v;
				if(t.get(k-10).bomb()){
					total=total+1; 
				}
				if(t.get(k).bomb()){
					total=total+1;
				}
				if(t.get(k-11).bomb()){
					total=total+1;
				}
				if(t.get(k+9).bomb()){
					total=total+1;
				}
				if(t.get(k+10).bomb()){
					total=total+1;
				}
			}
			if(s=="Redge"){
				int k = v;
				if(t.get(k-12).bomb()){
					total=total+1; 
				}
				if(t.get(k-2).bomb()){
					total=total+1;
				}
				if(t.get(k-11).bomb()){
					total=total+1;
				}
				if(t.get(k+9).bomb()){
					total=total+1;
				}
				if(t.get(k+8).bomb()){
					total=total+1;
				}
			}
			if(s=="center"){
				int k = v;
				if(t.get(k).bomb()){
					total=total+1; 
				}
				if(t.get(k-2).bomb()){
					total=total+1;
				}
				if(t.get(k-11).bomb()){
					total=total+1;
				}
				if(t.get(k-10).bomb()){
					total=total+1;
				}
				if(t.get(k-12).bomb()){
					total=total+1;
				}
				if(t.get(k+9).bomb()){
					total=total+1;
				}
				if(t.get(k+8).bomb()){
					total=total+1;
				}
				if(t.get(k+10).bomb()){
					total=total+1;
				}
			}
			
			return total;
		}
}

