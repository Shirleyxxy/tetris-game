import javax.swing.JFrame;
/**
 * TetrisGUIApplication is the class to test out the Tetris game.
 * @author Xueying Xu (Shirley)
 */
public class TetrisGUIApplication {

	/**
	 * Creates a JFrame that holds the TetrisGUIController.
	 * 
	 **/
	public static void main(String[] args) {
		
		JFrame guiFrame = new JFrame( "Tetris" );
				
		guiFrame.setSize( 450, 800 );

		guiFrame.add( new TetrisGUIController() );
				
		// Exit normally on closing the window
		guiFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		// Show frame
		guiFrame.setVisible( true );
			
		
	}

}
