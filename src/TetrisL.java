/**
 * TetrisL represents the Tetris L shape. 
 * @author Xueying Xu (Shirley) 
 */
public class TetrisL extends TetrisPiece {
    
	/**
	 * Constructor. 
	 */
    public TetrisL() {
		
		super();
	   	
	    boolean[][][] tetrisL = {
			
					
				{
				    {true, false, false, false},
				
				    {true, false, false, false},
				
				    {true, true, false, false},
				
				    {false, false, false, false}  
				    
				},
				
				
				{
				    {true, true, true, false},
				
				    {true, false, false, false},
				
				    {false, false, false, false},
				
				    {false, false, false, false}  
				    
				},
				
				
				{
				    {true, true, false, false},
				
				    {false, true, false, false},
				
				    {false, true, false, false},
				
				    {false, false, false, false}  
				    
				},
				
				{
				    {false, false, true, false},
				
				    {true, true, true, false},
				
				    {false, false, false, false},
				
				    {false, false, false, false}  
				    
				}
				
		};
		
		
		piece = tetrisL;
		
			
	
	}
	
	
	
	
	
}
