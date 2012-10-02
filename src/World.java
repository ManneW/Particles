import java.util.Vector;

public class World {

  public java.util.Vector<Particle> particles;

  private static World instance;
  
  private World()
  {
	  this.particles = new Vector<Particle>();
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
  
}