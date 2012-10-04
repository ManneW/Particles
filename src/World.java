import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Vector;

import javax.swing.JPanel;

public class World extends Thread{

  public java.util.Vector<Particle> particles;
  public Vector<Source> sources;
  public Vector<Effect> effects;

  private static World instance;
  private JPanel worldPanel;
  
  private World()
  {
	  this.particles = new Vector<Particle>();
	  this.sources = new Vector<Source>();
	  this.effects = new Vector<Effect>();
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
  
  public void addEffect(Effect e)
  {
	  this.effects.add(e);
  }
  
  public void recalculateParticle(Particle p)
  {
	  //Apply force
	  Force resultingForce = new Force();
	  for (Effect effect : effects) {
		  resultingForce.add(effect.forceAt(p.getRoundedPosX(), p.getRoundedPosY()));
	  }
	  
	  p.applyForce(resultingForce);
	  
	  //Move
	  p.move();
  }
  
  public void paintWorld(Graphics g)
  {
	  synchronized (sources) {
		  for (Source source : sources) {
			  source.paint(g);
		  }
	  }
	  
	  //System.out.println("Particles: " + particles.size());
	  
	  Vector<Particle> exitedParticles = new Vector<Particle>();
	  synchronized (particles) {
		  for (Particle particle : particles) {
			  this.recalculateParticle(particle);
			  if (particle.getPosX() < 0 || particle.getPosX() > this.worldPanel.getWidth() ||
				  particle.getPosY() < 0 || particle.getPosY() > this.worldPanel.getHeight()) {
				  exitedParticles.add(particle);
			  }
			  particle.paint(g);
		  }
		  particles.removeAll(exitedParticles);
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
			Thread.sleep(200);
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