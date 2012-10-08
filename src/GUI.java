import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;


public class GUI implements ActionListener {

	private JFrame frame;
	private JPanel worldPanel;
	private JButton btnAddEffect;
	private JButton btnAddSource;
	private JButton btnRunSimulation;
	private boolean simulationRunning = false;
	private JButton btnAddConeSource;
	

	/**
	 * Launch the application.
	 */
	/*commented 2012-10-03 17:45
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
		});
	}
	*/
	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();

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
		
		btnAddSource = new JButton("Add Explosion source");
		btnAddSource.addActionListener(this);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnAddEffect = new JButton("Add effect");
		btnAddEffect.addActionListener(this);
		
		btnAddConeSource = new JButton("Add Cone Source");
		btnAddConeSource.addActionListener(this);
		panel.add(btnAddConeSource);
		panel.add(btnAddEffect);
		
		JLabel label = new JLabel("");
		panel.add(label);
		panel.add(btnAddSource);
		
		btnRunSimulation = new JButton("Run simulation");
		btnRunSimulation.addActionListener(this);
		panel.add(btnRunSimulation);
		
		worldPanel = new WorldPanel();
		worldPanel.setBackground(Color.BLUE);
		frame.getContentPane().add(worldPanel, BorderLayout.CENTER);
		Graphics g = worldPanel.getGraphics();
		
//		if (null == g)
//			System.out.println("g is null");
//		
//		World.instance().setGraphics(g);
	}

	/*
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
	*/
	
	public JPanel getWorldPanel() {
		return worldPanel;
	}

	public JButton getBtnAddEffect() {
		return btnAddEffect;
	}
	public JButton getBtnAddSource() {
		return btnAddSource;
	}
	
	public void actionPerformed(ActionEvent arg) {
		System.out.println("Action performed");
		if(arg.getSource()==btnAddSource){
			System.out.println("add source");
			ExplosionSource es = new ExplosionSource();
			es.posX = (int) (Math.random()*150+150);
			es.posY = (int) (Math.random()*150+150);
			es.size = (int) (Math.random()*25);
			es.emitParticles();
			
			World.instance().addSource(es);
			World.instance().sources.get(World.instance().sources.size()-1).paint(worldPanel.getGraphics());
		}
		else if(arg.getSource()==btnAddConeSource){
			System.out.println("add source");
			ConeSource cs = new ConeSource();
			cs.posX = (int) (Math.random()*150+150);
			cs.posY = (int) (Math.random()*150+150);
			cs.directionX = (int) (cs.posX-75+(Math.random()*150));
			cs.directionY = (int) (cs.posY-75+(Math.random()*150));
			cs.quadrant = (int) Math.round((Math.random()*3)+1);
			cs.size = (int) (Math.random()*25);
			cs.emitParticles();
			
			World.instance().addSource(cs);
			World.instance().sources.get(World.instance().sources.size()-1).paint(worldPanel.getGraphics());
		}
		else if(arg.getSource()==btnAddEffect){
			//TODO
			//add effect
		}
		else if(arg.getSource()==btnRunSimulation){
			if(!simulationRunning){
				//TODO
				//check if thread has started
				if(false){
					simulationRunning = true;
					World.instance().resume();
				}
				else{
					simulationRunning = true;
					World.instance().start();					
				}
			}
			else{
				simulationRunning = false;
				World.instance().stop();
			}
		}
		
	}

	public JButton getBtnRunSimulation() {
		return btnRunSimulation;
	}
	public JButton getBtnAddConeSource() {
		return btnAddConeSource;
	}
}
