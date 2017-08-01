/**
 * TetrisJ represents the Tetris J shape. 
 * @author Xueying Xu (Shirley) 
 */
public class TetrisJ extends TetrisPiece {

   /**
    * Constructor.
    */
   public TetrisJ() {
		
		super();
	   		
	    boolean[][][] tetrisJ = {
			
					
				{
				    {false, true, false, false},
				
				    {false, true, false, false},
				
				    {true, true, false, false},
				
				    {false, false, false, false}  
				    
				},
				
				
				{
				    {true, false, false, false},
				
				    {true, true, true, false},
				
				    {false, false, false, false},
				
				    {false, false, false, false}  
				    
				},
				
				
				{
				    {true, true, false, false},
				
				    {true, false, false, false},
				
				    {true, false, false, false},
				
				    {false, false, false, false}  
				    
				},
				
				{
				    {true, true, true, false},
				
				    {false, false, true, false},
				
				    {false, false, false, false},
				
				    {false, false, false, false}  
				    
				}
				
		};
		
		
		piece = tetrisJ;
		
			
	}
	
	
	

	
}
