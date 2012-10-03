import java.awt.Color;
import java.awt.Graphics;

public class ExplosionSource extends Source {

	@Override
	public void emitParticles() {
		//Do a burst of 10 particles
		Particle p;
		for (int i = 0; i < ((int)(Math.random() * 25) + 25); i+=1) {
			p = this.generateParticle();
			World.instance().addParticle(p);
		}
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.GREEN);
		g.drawRect(posX-5, posY-5, 10, 10);
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
		f.x = (float)((Math.random() * 10.0) - 5);
		f.y = (float)((Math.random() * 10.0) - 5);
		
		return f;
	}
	
}