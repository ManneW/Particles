import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

public class Particle {

	private double posX;
  	private double posY;
  	private double vX;
  	private double vY;
  	
  	public Particle()
  	{
  		
  	}
  	
  	public Particle(double posX, double posY, double vX, double vY)
	{
		this.posX = posX;
		this.posY = posY;
		this.vX = vX;
		this.vY = vY;
	}
	
	public double getPosX() {
		return posX;
	}
	public void setPosX(double posX) {
		this.posX = posX;
	}
	public double getPosY() {
		return posY;
	}
	public void setPosY(double posY) {
		this.posY = posY;
	}
	
	public int getRoundedPosX() {
		return (int)Math.round(this.getPosX());
	}
	
	public int getRoundedPosY() {
		return (int)Math.round(this.getPosY());
	}
	
	
	public double getvX() {
		return vX;
	}
	public void setvX(double vX) {
		this.vX = vX;
	}
	public double getvY() {
		return vY;
	}
	public void setvY(double vY) {
		this.vY = vY;
	}

  	/**
  	 * Re-computes the particles velocity according to the applied force 
  	 * @param f
  	 */
  	public void applyForce(Force f)
  	{
  		this.vX += f.x;
  		this.vY += f.y;
  	}
  	
  	public void paint(Graphics g)
  	{
  		g.setColor(Color.RED);
  		g.fillOval((int)Math.round(this.getPosX()), (int)Math.round(this.getPosY()), 10, 10);
  	}
  	
  	public void move()
  	{
  		this.posX += this.vX;
  		this.posY += this.vY;
  	}
  	
}