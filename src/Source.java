import java.awt.Graphics;

public abstract class Source {

  public int posX, posY, size;

  public abstract void emitParticles();
  public abstract void paint(Graphics g);
  
}