/**
 * TetrisT represents the Tetris T shape. 
 * @author Xueying Xu (Shirley) 
 */

public class TetrisT extends TetrisPiece {
    
	/**
	 * Constructor. 
	 */
	public TetrisT() {
		
		super();
		
		 boolean[][][] tetrisT = {
					
					
					{
					    {true, false, false, false},
					
					    {true, true, false, false},
					
					    {true, false, false, false},
					
					    {false, false, false, false}  
					    
					},
					
					
					{
					    {true, true, true, false},
					
					    {false, true, false, false},
					
					    {false, false, false, false},
					
					    {false, false, false, false}  
					    
					},
					
					
					{
					    {false, true, false, false},
					
					    {true, true, false, false},
					
					    {false, true, false, false},
					
					    {false, false, false, false}  
					    
					},
					
					{
					    {false, true, false, false},
					
					    {true, true, true, false},
					
					    {false, false, false, false},
					
					    {false, false, false, false}  
					    
					}
					
			};
			
		
		 piece = tetrisT;
		
				
	}
	
	
}
