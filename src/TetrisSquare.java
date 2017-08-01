/**
 * TetrisSquare represents the Tetris Square shape. 
 * @author Xueying Xu (Shirley) 
 */
public class TetrisSquare extends TetrisPiece{

	/**
	 * Constructor.
	 */
    public TetrisSquare() {
				
    	super();
	   		
	    boolean[][][] tetrisSquare = {
			
					
				{
				    {true, true, false, false},
				
				    {true, true, false, false},
				
				    {false, false, false, false},
				
				    {false, false, false, false}  
				    
				},
				
				
				{
				    {true, true, false, false},
				
				    {true, true, false, false},
				
				    {false, false, false, false},
				
				    {false, false, false, false}  
				    
				},
				
				
				{
				    {true, true, false, false},
				
				    {true, true, false, false},
				
				    {false, false, false, false},
				
				    {false, false, false, false}  
				    
				},
				
				{
				    {true, true, false, false},
				
				    {true, true, false, false},
				
				    {false, false, false, false},
				
				    {false, false, false, false}  
				    
				}
				
		};
		
		
		piece = tetrisSquare;
		
			
	
	}
	

	
}
