/**
 * TetrisPiece maintains representation and rotation of one Tetris piece for the Tetris game.
 * @author Xueying Xu (Shirley)
 */

public abstract class TetrisPiece {

	// 3D array representing a Tetris piece
	protected boolean[][][] piece;

	// first index for the boolean array: 0 = 0 degrees; 1 = 90 degrees;
	// 2 = 180 degrees; 3 = 270 degrees
	protected int rotationIndex;

	/**
	 * Constructor.
	 */
	public TetrisPiece() {

	}

	/**
	 * Get the rotation index (first index of the 3D array) of the Tetris piece.
	 * @return the first index of the 3D boolean array
	 */
	public int getRotationIndex() {

		return rotationIndex;

	}

	/**
	 * Update the rotation index of the piece after rotating clockwise.
	 */
	public void setCWIndex() {

		if (rotationIndex < 3) {

			rotationIndex = rotationIndex + 1;

		} else {

			rotationIndex = 0;
		}

	}

	/**
	 * Update the rotation index of the piece after rotating counterclockwise.
	 */
	public void setCCWIndex() {

		if (rotationIndex > 0) {

			rotationIndex = rotationIndex - 1;

		} else {

			rotationIndex = 3;
		}

	}

	
	/**
	 * Check if there is a filled block at a specific position for a specific
	 * rotation index.
	 * @return true if there is a filled block, false otherwise.
	 */
	public boolean hasFilledBlock(int rot, int row, int col) {

		return piece[rot][row][col];

	}

}
