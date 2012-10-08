import java.awt.Color;
import java.awt.Graphics;

public class GravityEffect extends Effect {

	@Override
	public Force forceAt(int posX, int posY)
	{
		Force f = new Force();
		f.x = 0;
		f.y = 0.2;
		
		return f;
	}
}