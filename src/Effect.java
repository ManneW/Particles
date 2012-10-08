import java.awt.Color;
import java.awt.Graphics;

public abstract class Effect {

  public int posX;

  public int posY;

  public abstract Force forceAt(int posX, int posY);

  public void paint(Graphics g)
  {
	  g.setColor(Color.ORANGE);
	  g.drawRect(posX-5, posY-5, 10, 10);
  }
}