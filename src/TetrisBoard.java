/**
 * TetrisBoard maintains the current state of the game board. 
 * @author Xueying Xu (Shirley)
 */
public class TetrisBoard {

	/**
	 * A standard Tetris board has 10 columns.
	 */
	public static final int NUM_COLS = 10;

	/**
	 * A standard Tetris board has 18 rows.
	 */
	public static final int NUM_ROWS = 18;

	private int numCols;

	private int numRows;

	private boolean[][] gameBoard;
	
    // the falling piece
	private TetrisPiece curPiece;

	// an int array of length two that stores the upper left position of the falling piece
	private int[] curPieceGridPosition = new int[2];

	/**
	 * Constructor.
	 */
	public TetrisBoard() {
		
		this.numRows = NUM_ROWS;
		
		this.numCols = NUM_COLS;

		gameBoard = new boolean[numRows][numCols];
		
		// Initialize the game board
		createBoard();
		
		addNewPiece();
		
	}

	
	/**
	 * Initialize the grid position at (0, 3) of a new falling Tetris piece.
	 */
	private void createCurPieceGridPosition() {

		curPieceGridPosition[0] = 0;

		curPieceGridPosition[1] = 3;

	}

	
	/**
	 * Initialize the 2D game board to have all false values.
	 */
	private void createBoard() {

		for (int row = 0; row < numRows; row++) {

			for (int col = 0; col < numCols; col++) {

				gameBoard[row][col] = false;

			}
		}

	}

	
	/**
	 * Check if the game board has a filled block at a specific position.
	 * @param row the row index
	 * @param col the column index
	 * @return true if the game board has a filled block at a specific position
	 */
	public boolean hasBlock(int row, int col) {

		return gameBoard[row][col];

	}

	
	/**
	 * Get the current grid position of the falling Tetris piece.
	 * @return an int array of length two that stores the upper left position of the falling piece
	 */
	public int[] getCurPieceGridPosition() {

		return curPieceGridPosition;

	}

	
	/**
	 * Add a new random Tetris piece to the game board at grid position (0, 3). 
	 */
	public void addNewPiece() {

		int pieceType = (int) (Math.random() * 7);
		
		if (pieceType == 0) {
			
			curPiece = new TetrisSquare();
				
		} else if (pieceType == 1) {
			
			curPiece = new TetrisStick();

		} else if (pieceType == 2) {
			
			curPiece = new TetrisT();
			
		} else if (pieceType == 3) {
			
			curPiece = new TetrisL();
		
		} else if (pieceType == 4) {
			
			curPiece = new TetrisJ();
		
		} else if (pieceType == 5) {
			
			curPiece = new TetrisS();
		
		} else {
			
			curPiece = new TetrisZ();			
		}
		
		createCurPieceGridPosition();

	}

	
	
	/**
	 * Check if the current piece will exceed the boundaries (left, right, and bottom) of the game board.
	 * @param piece the current Tetris piece 
	 * @param rot the rotation index of the current Tetris piece 
	 * @param gridRow the row index of the position on the board that the piece intends to move to
	 * @param gridCol the column index of the position on the board that the piece intends to move to
	 * @return true if the piece will exceed the boundaries, false otherwise
	 */
	private boolean isOutOfBounds(TetrisPiece piece, int rot, int gridRow, int gridCol) {

		for (int pieceRow = 0; pieceRow < 4; pieceRow++) {

			for (int pieceCol = 0; pieceCol < 4; pieceCol++) {

				if (piece.hasFilledBlock(rot, pieceRow, pieceCol) &&
						
						// Check for bottom, right, and left boundaries
					  ( (gridRow + pieceRow >= numRows) || (gridCol + pieceCol >= numCols) || (gridCol < 0)) ) {

					      return true;
				    }
			
			 }

	     }

		 
		   return false;

	}

	
	/**
	 * Check if the current piece can be placed at a certain position on the game board.
	 * @param piece the current Tetris piece 
	 * @param rot the rotation index of the current Tetris piece 
	 * @param gridRow the row index of the position on the board that the piece intends to move to
	 * @param gridCol the column index of the position on the board that the piece intends to move to 
	 * @return true if the piece collides with other blocks on the game board, false otherwise.
	 */
	private boolean isBlocked(TetrisPiece piece, int rot, int gridRow, int gridCol) {

		for (int pieceRow = 0; pieceRow < 4; pieceRow++) {

			for (int pieceCol = 0; pieceCol < 4; pieceCol++) {

				if (piece.hasFilledBlock(rot, pieceRow, pieceCol) &&
					
					 // Check if the game board has blocks at certain grid positions 
					 hasBlock(gridRow + pieceRow, gridCol + pieceCol)) {

						return true;
						
				}

			}

		}

		return false;

	}

	
	/**
	 * Check if it is a valid move for the falling piece.
	 * @param piece the current Tetris piece 
	 * @param rot the rotation index of the current Tetris piece 
	 * @param gridRow the row index of the position on the board that the piece intends to move to
	 * @param gridCol the column index of the position on the board that the piece intends to move to 
	 * @return true if the move is valid (no collisions, not out of bounds), false otherwise.
	 */
	private boolean isValidMove(TetrisPiece piece, int rot, int gridRow, int gridCol) {
			
		return !(isOutOfBounds(piece, rot, gridRow, gridCol)) && !(isBlocked(piece, rot, gridRow, gridCol));
				
	}

	
	/**
	 * Update the grid position of the current piece if moving to the right is valid.
     * @return true if the piece moves to the right, false otherwise. 
	 */
	public boolean moveRight() {
		
	  if (curPiece == null) {
			
			return false;
		
	   } else {

		   if (isValidMove(curPiece, curPiece.getRotationIndex(), curPieceGridPosition[0], curPieceGridPosition[1] + 1)) {
               
			   // Update the grid position 
			   curPieceGridPosition[1]++;

			   return true;

		   } else {

			   return false;
		   }
		
	}

}

	
	/**
	 * Update the grid position of the current piece if moving to the left is valid.
	 * @return true if the piece moves to the left, false otherwise. 
	 */
	public boolean moveLeft() {
		
	  if (curPiece == null) {
		  
		 return false;
	  
	   } else {

		   if (isValidMove(curPiece, curPiece.getRotationIndex(), curPieceGridPosition[0], curPieceGridPosition[1] - 1)) {

			  // Update the grid position 
			  curPieceGridPosition[1]--;

			  return true;

		    } else {

			  return false;
		    }
	
	   }

	}

	
	/**
	 * Update the grid position of the current piece if moving down is valid.
	 * @return true if the piece moves down, false otherwise. 
	 */
	public boolean moveDown() {
		
		if (curPiece == null) {
			
			return false;
		
		} else {

		   if (isValidMove(curPiece, curPiece.getRotationIndex(), curPieceGridPosition[0] + 1, curPieceGridPosition[1])) {

			   // Update the grid position 
			   curPieceGridPosition[0]++;

			   return true;

		   } else {

			   return false;
		   }

	     }
	
	  }
	
	/**
	 * Rotate the current piece clockwise (update the rotation index) if the rotation is valid. 
	 * @return true if the piece rotates clockwise, false otherwise. 
	 */
	public boolean rotateCW() {
		
		if (curPiece == null) {
			
			return false;
		
		} else {

		   int newRotationIndex;

		   if (curPiece.getRotationIndex() < 3) {

			   newRotationIndex = curPiece.getRotationIndex() + 1;

		   } else {

			   newRotationIndex = 0;
		   }

		
		   if (isValidMove(curPiece, newRotationIndex, curPieceGridPosition[0], curPieceGridPosition[1])) {

			   // Update the rotation index
			   curPiece.setCWIndex();

			   return true;

		   } else {

			   return false;
		   }
	   
		}
	
	}


	/**
	 * Rotate the current piece counterclockwise (update the rotation index) if the rotation is valid.
	 * @return true if the piece rotates counterclockwise, false otherwise. 
	 */
	public boolean rotateCCW() {
		
		if (curPiece == null) {
			
			return false;
		
		} else {

		   int newRotationIndex;

		   if (curPiece.getRotationIndex() > 0) {

			   newRotationIndex = curPiece.getRotationIndex() - 1;

		   } else {

			   newRotationIndex = 3;
		   }

		   if (isValidMove(curPiece, newRotationIndex, curPieceGridPosition[0], curPieceGridPosition[1])) {

			   // Update the rotation index
			   curPiece.setCCWIndex();

			   return true;

		   } else {

			   return false;
		   }

		}
	
	}

	
	/**
	 * Update the boolean values of the game board when a piece lands by using
	 * the currentGridPosition values and the currentPiece's rotation value.
	 */
	public void landPiece() {
        	
	   for (int pieceRow = 0; pieceRow < 4; pieceRow++) {
		   
		   for (int pieceCol = 0; pieceCol < 4; pieceCol++) {
			   
			    if (curPiece.hasFilledBlock(curPiece.getRotationIndex(), pieceRow, pieceCol)) {
			   
			         gameBoard[curPieceGridPosition[0] + pieceRow][curPieceGridPosition[1] + pieceCol] = true;
			    
			    }	   
		   
		    }
	   
	   }
		 	
}

	
	/**
	 * Check if there is a row filled with blocks on the game board.
	 * @param row the row index
	 * @return true if there is a filled row, false otherwise.
	 */
	private boolean hasFilledRow(int row) {

	  int blocksCounter = 0;
		
	  for (int col = 0; col < numCols; col++) {
		  
		   if (gameBoard[row][col]) {
			  
			   blocksCounter++;
		   }
	   }
	
	   return blocksCounter == numCols; 	
	}
	
	
	
	/**
	 * Update the boolean values of the game board when a row is cleared.
	 * @param row the row index
	 */
	private void clearRow(int targetRow) {
		  
		    // Shift all values for rows at a lower index to be at one row higher
		    for (int row = targetRow; row > 0; row--) {
				  
			     for (int col = 0; col < numCols; col++) {
				
				    gameBoard[row][col] = gameBoard[row - 1][col];
				
			  }
			 
			 // Set the first row of the game board to all false values
			 for (int col = 0; col < numCols; col++) {
			
			        gameBoard[0][col] = false;
			 }
		   
		  }		
		
	}


	/**
	 * Detect and remove any rows formed. 
	 * @return the total number of rows cleared. 
	 */
	public int numberOfClearedRows() {
		
		int clearedRows = 0;
		
		for (int row = 0; row < numRows; row++) {
			
			if (hasFilledRow(row)) {
			
				clearRow(row);
			
			    clearedRows++;
		 
			}
		}
		
		return clearedRows;
	}


    /**
     * Get the game board.
     * @return the game board
     */
	public boolean[][] getGameBoard() {
		
		return gameBoard;
	
	}
	
	/**
     * Get the current Tetris piece.
     * @return the current Tetris piece
     */
	public TetrisPiece getCurrentPiece() {
		
		return curPiece;
		
	}
	
	
	/**
	 * Get the number of rows of the game board.
	 * @return the number of rows
	 */
	public int getNumRows() {
		
		return numRows;
	
	}

	
	/**
	 * Get the number of columns of the game board.
	 * @return the number of columns
	 */
	public int getNumCols() {
		
		return numCols;
	}

	
	/**
	 * Check if a block should be displayed at a certain position on the game board.
	 * @param row the row index
	 * @param col the col index
	 * @return true if a block (an 'X' for the text version) should be displayed, false otherwise.
	 */
	public boolean displayBlock(int row, int col) {
	
	  // Check if the block is on the game board
	  if (hasBlock(row, col)) {
		  
		  return true;
	  
	  // Check if the block is on the falling piece 
	  } else {
	  
	    for (int pieceRow = 0; pieceRow < 4; pieceRow++) {
		  
		   for (int pieceCol = 0; pieceCol < 4; pieceCol++) {
			  
			   int globalRow = curPieceGridPosition[0] + pieceRow;
			  
			   int globalCol = curPieceGridPosition[1] + pieceCol;
			  
			   if (globalRow == row && globalCol == col && curPiece.hasFilledBlock(curPiece.getRotationIndex(), pieceRow, pieceCol)) {
				   
				   return true;
			   
			   }
				  			  
		  }
	  
	  }
	  	 
          return false;
   
     }

   }

}
