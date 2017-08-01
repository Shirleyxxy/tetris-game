import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public class TetrisBoardGUIView extends JComponent {

	private TetrisBoard gameBoard;
	
	/**
	 * Constructor. 
	 * @param b the TetrisBoard 
	 */
	public TetrisBoardGUIView(TetrisBoard b) {
		
		gameBoard = b;
		
	}

	/**
	 * Paint the outline of the game board and the blocks on it.
	 * @param g the Graphics object
	 */
	public void paint(Graphics g) {
				
	   int blockSize = computeBlockSize();
		
	   paintBoardOutline(g, blockSize);
		
	   // Loop through the game board to paint the blocks
       for (int row = 0; row < gameBoard.getNumRows(); row++) {
			
			for (int col = 0; col < gameBoard.getNumCols(); col++) {
					
		        paintBlock(g, row, col, blockSize);
		
			}
			
        }
		
	}

	
	// Paint the outline of the game board
	private void paintBoardOutline(Graphics g, int blockSize) {
		
		g.setColor(Color.BLACK);
		
		g.drawRect(0, 0, gameBoard.getNumCols() * blockSize, gameBoard.getNumRows() * blockSize);
		
		
	}
	
		
	private void paintBlock(Graphics g, int row, int col, int blockSize) {
		
		 // Check where on the game board to paint the blocks
		 if (gameBoard.displayBlock(row, col)) {
							 	
		         g.setColor(new Color(66, 149, 244));
		 
		         g.fillRect(col * blockSize, row * blockSize, blockSize, blockSize);
		         
		         g.setColor(Color.BLACK);
				 
		         g.drawRect(col * blockSize, row * blockSize, blockSize, blockSize);
		
	      }
		   
	}
	
	// Compute the size of each square block
	private int computeBlockSize() {
		
		return (getHeight()) / gameBoard.getNumRows();
	
	}
	
	
}
