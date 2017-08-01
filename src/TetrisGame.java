/**
 * TetrisGame implements the game rules and logic. 
 * @author Xueying Xu (Shirley)
 */

public class TetrisGame {

	public static final int RIGHT = 1;

	public static final int LEFT = 2;

	public static final int DOWN = 3;

	public static final int CW = 4;

	public static final int CCW = 5;

	private TetrisBoard tetrisBoard;

	// the total number of cleared rows
	private int numClearedRows = 0;

	// the total number of cleared tetrises
	private int numClearedTetrises = 0;


	/**
	 * Constructor.
	 */
	public TetrisGame() {

		tetrisBoard = new TetrisBoard();
		
	}

	
	/**
	 * Get the Tetris board.
	 * @return the Tetris board 
	 */
	public TetrisBoard getTetrisBoard() {

		return tetrisBoard;

	}


	/**
	 * Try to move or rotate a Tetris piece.
	 * @param moveType the type of movement or rotation represented by an integer
	 */
	public void tryMove(int moveType) {

		if (moveType == RIGHT) {

			tetrisBoard.moveRight();

		}

		else if (moveType == LEFT) {

			tetrisBoard.moveLeft();

		}

		else if (moveType == DOWN) {

			boolean canMoveDown = tetrisBoard.moveDown();
			
			// if the falling piece cannot move down any more, end the round
	        // for this current piece
			if ( !canMoveDown ) {
				
				endRound();
				
			}
				
		}

		else if (moveType == CW) {

			tetrisBoard.rotateCW();
		}

		else if (moveType == CCW) {

			tetrisBoard.rotateCCW();
		}

	}

	
	/**
	 * Land the current piece. Check if there are rows to clear and 
	 * clear them if there are any. Then add a new piece to the game board
	 * to start a new round. 
	 */
	private void endRound() {
		
		tetrisBoard.landPiece();
        
		// Check for cleared rows
		int numRows = tetrisBoard.numberOfClearedRows();
		
		// Check if it is a Tetris
		if (numRows == 4) {
			
		   numClearedTetrises++;
		}
		
		// Update the number of cleared rows
		numClearedRows += numRows;
		
		// Start a new round
		tetrisBoard.addNewPiece();

	}

	
	/**
	 * Get the total number of cleared rows. 
	 * @return the total number of cleared rows
	 */	
	public int getNumClearedRows() {

		return numClearedRows;

	}

	

	/**
	 * Get the total number of cleared Tetrises. 
	 * @return the total number of cleared Tetrises
	 */	
	public int getNumClearedTetrises() {

		return numClearedTetrises;

	}

}
