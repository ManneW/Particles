import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Vector;

import javax.swing.JPanel;

public class World extends Thread{

  public java.util.Vector<Particle> particles;
  public Vector<Source> sources;

  private static World instance;
  private JPanel worldPanel;
  
  private World()
  {
	  this.particles = new Vector<Particle>();
	  this.sources = new Vector<Source>();
  }
  
  public static World instance()
  {
	  if (null == World.instance) {
		  World.instance = new World();
	  }
	  
	  return World.instance;
  }
  
  public void addParticle(Particle p)
  {
	  this.particles.add(p);
  }
  
  public void addSource(Source s)
  {
	  this.sources.add(s);
  }
  
  public void recalculateParticle(Particle p)
  {
	  //Apply force
	  
	  //Move
	  p.move();
  }
  
  public void paintWorld(Graphics g)
  {
	  for (Source source : sources) {
		  source.paint(g);
	  }
	  
	  for (Particle particle : particles) {
		  this.recalculateParticle(particle);
		  particle.paint(g);
	  }
  }
  
  public void run(){
	  while(true){
		  if(this.worldPanel.getGraphics()!=null){
			  paintWorld(this.worldPanel.getGraphics());
			  worldPanel.repaint();
		  }
		  else{
			  System.out.println("graphics null");
		  }
		  
		  try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
  }

	public void setWorldPanel(JPanel worldPanel) {
		this.worldPanel = worldPanel;
	}
	
	public JPanel getWorldPanel() {
		return worldPanel;
	}

  
}