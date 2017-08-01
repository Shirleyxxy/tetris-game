/**
 * TetrisZ represents the Tetris Z shape. 
 * @author Xueying Xu (Shirley) 
 */
public class TetrisZ extends TetrisPiece {
    
	/**
	 * Constructor.
	 */
	public TetrisZ() {
			
			super();
		   
		    boolean[][][] tetrisZ = {
				
						
					{
					    {false, true, false, false},
					
					    {true, true, false, false},
					
					    {true, false, false, false},
					
					    {false, false, false, false}  
					    
					},
					
					
					{
					    {true, true, false, false},
					
					    {false, true, true, false},
					
					    {false, false, false, false},
					
					    {false, false, false, false}  
					    
					},
					
					
					{
					    {false, true, false, false},
					
					    {true, true, false, false},
					
					    {true, false, false, false},
					
					    {false, false, false, false}  
					    
					},
					
					{
					    {true, true, false, false},
					
					    {false, true, true, false},
					
					    {false, false, false, false},
					
					    {false, false, false, false}  
					    
					}
					
			};
			
			
			piece = tetrisZ;
			
						
		}
		
	
}
