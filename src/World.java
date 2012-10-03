import java.awt.Graphics;
import java.util.Vector;

public class World {

  public java.util.Vector<Particle> particles;
  public Vector<Source> sources;

  private static World instance;
  
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
  
}