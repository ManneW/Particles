import java.awt.Graphics;

import javax.swing.JPanel;


public class WorldPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5533337947392051835L;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		World.instance().paintWorld(g);
	}
}
