import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class ConeSource extends Source {
	
	int directionX, directionY, quadrant;

	@Override
	public void emitParticles() {
		Particle p;
		for (int i = 0; i < (this.size + 25); i+=1) {
			p = this.generateParticle();
			World.instance().addParticle(p);
		}
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.GREEN);
		
		int pX = 0, pY = 0, p2X = 0, p2Y = 0;
		switch (this.quadrant) {
		case 1:
			pX = posX + size;
			pY = posY;
			p2X = posX;
			p2Y = posY+size;
			break;
		case 2:
			pX = posX + size;
			pY = posY;
			p2X = posX;
			p2Y = posY-size;
			break;
		case 3:
			pX = posX - size;
			pY = posY;
			p2X = posX;
			p2Y = posY-size;
			break;
		case 4:
			pX = posX - size;
			pY = posY;
			p2X = posX;
			p2Y = posY+size;
			break;	
		} 
		
		g.drawLine(posX, posY, pX, pY);
		g.drawLine(posX, posY, p2X, p2Y);
		
	}

	private Particle generateParticle()
	{
		Force f = this.randomizeForce();
		while (f.resultingForce() == 0) {
			f = this.randomizeForce();
		}
		
		Particle p = new Particle();
		p.setPosX(this.posX);
		p.setPosY(this.posY);
		p.applyForce(f);
		
		return p;
	}
	
	private Force randomizeForce()
	{
		Force f = new Force();
		switch (this.quadrant) {
		case 1:
			f.x = (float)((Math.random() * 10.0));
			f.y = (float)((Math.random() * 10.0));
			break;
		case 2:
			f.x = (float)((Math.random() * 10.0));
			f.y = (float)((Math.random() * -10.0));
			break;
		case 3:
			f.x = (float)((Math.random() * -10.0));
			f.y = (float)((Math.random() * -10.0));
			break;
		case 4:
			f.x = (float)((Math.random() * -10.0));
			f.y = (float)((Math.random() * 10.0));
			break;	
		default:
			break;
		}
		
		
		return f;
	}
	
	
}