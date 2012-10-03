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


public class GUI implements Runnable, ActionListener {

	private JFrame frame;
	private JPanel worldPanel;
	

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
		es.posX = 100;
		es.posY = 100;
		es.emitParticles();
		
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
		frame.setBounds(100, 100, 676, 387);
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
		
		worldPanel = new JPanel();
		worldPanel.setBackground(Color.BLUE);
		frame.getContentPane().add(worldPanel, BorderLayout.CENTER);
	}

	public void run()
	{
		while(true) {
			World.instance().paintWorld(this.getWorldPanel().getGraphics());
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public JPanel getWorldPanel() {
		return worldPanel;
	}

	public void actionPerformed(ActionEvent arg) {
		//if(arg.getSource()==)
		
	}
}
