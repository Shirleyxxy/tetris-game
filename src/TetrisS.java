/**
 * TetrisS represents the Tetris S shape. 
 * @author Xueying Xu (Shirley) 
 */
public class TetrisS extends TetrisPiece {
   
	/**
	 * Constructor. 
	 */
	public TetrisS() {
		
		super();
	   
	    boolean[][][] tetrisS = {
			
					
				{
				    {true, false, false, false},
				
				    {true, true, false, false},
				
				    {false, true, false, false},
				
				    {false, false, false, false}  
				    
				},
				
				
				{
				    {false, true, true, false},
				
				    {true, true, false, false},
				
				    {false, false, false, false},
				
				    {false, false, false, false}  
				    
				},
				
				
				{
				    {true, false, false, false},
				
				    {true, true, false, false},
				
				    {false, true, false, false},
				
				    {false, false, false, false}  
				    
				},
				
				{
				    {false, true, true, false},
				
				    {true, true, false, false},
				
				    {false, false, false, false},
				
				    {false, false, false, false}  
				    
				}
				
		};
		
		
		piece = tetrisS;
		
			
	
	}
	
}
