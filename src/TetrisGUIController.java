import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TetrisGUIController extends JPanel implements KeyListener, ActionListener {
	
	public static final int DEFAULT_DROP_RATE = 500;

	private TetrisBoardGUIView view;
	
	private TetrisGame game;
	
	private JLabel rowsLabel;
	
	private JLabel tetrisesLabel;
	
	private Timer gameTimer;
	
	private int dropRate;
	
	
	/**
	 * Constructor.
	 */
	public TetrisGUIController() {
		
		super( new BorderLayout() );
		
		addKeyListener(this);
		
		setFocusable(true);
					
		// Create a new Tetris game
		game = new TetrisGame();
		
		// Create the initial display
		createView();
		
		createScore();
		
		setupTimer();
	
	}
	
	// Set up a timer to automate the falling of Tetris pieces
	private void setupTimer() {
		
		// Tetris piece falls every half second
		dropRate = DEFAULT_DROP_RATE;
		
		gameTimer = new Timer(dropRate, this);
		
		gameTimer.start();
		
	}
	
	/**
	 * Update the data for the game model and refresh the game view. 
	 */
	public void actionPerformed(ActionEvent e) {
		
		game.tryMove(3);
		
		refreshDisplay();
	}
	
	// Create the initial view of the game board
	private void createView() {
		
		view = new TetrisBoardGUIView(game.getTetrisBoard());
		
        this.add(view, BorderLayout.CENTER);
        			
	}
	
	// Create a JPanel that displays the number of rows and Tetrises cleared for the current game
	private void createScore() {
		
		JPanel scoreDisplay = new JPanel(new GridLayout(2, 1));
		
		rowsLabel = new JLabel("Lines cleared      " + game.getNumClearedRows());
		
		tetrisesLabel = new JLabel("Tetrises cleared      " + game.getNumClearedTetrises());
		
		scoreDisplay.add(rowsLabel);
		
		scoreDisplay.add(tetrisesLabel);
		
		this.add(scoreDisplay, BorderLayout.NORTH);
		
	}
	
	
	/**
	 * Update the contents of the labels and the view of the game board.
	 */	
	public void refreshDisplay() {
		
        rowsLabel.setText("Lines cleared      " + game.getNumClearedRows());
		
		tetrisesLabel.setText("Tetrises cleared      " + game.getNumClearedTetrises());
		
		view.repaint();
		
	}

	
	/**
	 * Get the user input when a key is pressed.
	 * @param e the key that is pressed
	 */
	public void keyPressed(KeyEvent e) {
			
		int key = e.getKeyCode();

	    if ( key == KeyEvent.VK_RIGHT ) {
			       
	    	game.tryMove(1);
			    	
	    } else if ( key == KeyEvent.VK_LEFT  ) {
			 
	    	game.tryMove(2);
			    	
	    } else if ( key == KeyEvent.VK_DOWN  ) {
			 
	    	game.tryMove(3);
			    	
	    } else if (key == KeyEvent.VK_X) {

			game.tryMove(4);
			
	    } else if (key == KeyEvent.VK_Z) {
	    	
	    	game.tryMove(5);
	    }

		refreshDisplay();
	}

	
	/**
	 * Do something when a key is released.
	 * @param e the key that is released
	 */
	public void keyReleased(KeyEvent e) {

	}

		
	/**
	 * Do something when a key is pressed and released.
	 * @param e the key that is pressed and released
	 */
	public void keyTyped(KeyEvent e) {
			
	}

	
	
}
