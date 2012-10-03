import java.awt.Graphics;

public abstract class Source {

  public int posX;

  public int posY;

  public abstract void emitParticles();
  public abstract void paint(Graphics g);
  
}