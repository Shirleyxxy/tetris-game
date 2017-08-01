/**
 * TetrisStick represents the Tetris Stick shape. 
 * @author Xueying Xu (Shirley) 
 */
public class TetrisStick extends TetrisPiece {

	/**
	 * Constructor.
	 */
	public TetrisStick() {
		
		super();
	   	
	    boolean[][][] tetrisStick = {
			
					
				{
				    {true, false, false, false},
				
				    {true, false, false, false},
				
				    {true, false, false, false},
				
				    {true, false, false, false}  
				    
				},
				
				
				{
				    {true, true, true, true},
				
				    {false, false, false, false},
				
				    {false, false, false, false},
				
				    {false, false, false, false}  
				    
				},
				
				
				{
				    {true, false, false, false},
				
				    {true, false, false, false},
				
				    {true, false, false, false},
				
				    {true, false, false, false}  
				    
				},
				
				{
				    {true, true, true, true},
				
				    {false, false, false, false},
				
				    {false, false, false, false},
				
				    {false, false, false, false}  
				    
				}
				
		};
		
		
		piece = tetrisStick;
		
			
	
	}
	
	
	
}
