public class ExplosionSource extends Source {

	@Override
	public void emitParticles() {
		
	}
	
	
	private Particle generateParticle()
	{
		Force f = this.randomizeForce();
		while (f.resultingForce() == 0) {
			f = this.randomizeForce();
		}
		
		Particle p = new Particle(posX, posY, , );
		
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