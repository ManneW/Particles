import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;


public class GUI implements Runnable {

	private JFrame frame;
	private WorldPanel worldPanel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new GUI());
		
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
		
		ExplosionSource es = new ExplosionSource();
		es.posX = 300;
		es.posY = 300;
		es.emitParticles();
		
		World.instance().addSource(es);
		
		try {
			this.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Add source");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton_1 = new JButton("Add effect");
		panel.add(btnNewButton_1);
		
		JLabel label = new JLabel("");
		panel.add(label);
		panel.add(btnNewButton);
		
		JButton btnRunSimulation = new JButton("Run simulation");
		panel.add(btnRunSimulation);
		
		worldPanel = new WorldPanel();
		worldPanel.setBackground(Color.BLUE);
		frame.getContentPane().add(worldPanel, BorderLayout.CENTER);
	}

	@Override
	public void run()
	{
		World.instance().paintWorld(this.getWorldPanel().getGraphics());
		
		while(true) {
			this.getWorldPanel().getGraphics().clearRect(
					this.worldPanel.getX(),
					this.worldPanel.getY(),
					this.worldPanel.getWidth(),
					this.worldPanel.getHeight()
			);
			
			World.instance().paintWorld(this.getWorldPanel().getGraphics());
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public WorldPanel getWorldPanel() {
		return worldPanel;
	}
}
