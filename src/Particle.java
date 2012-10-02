import java.util.Vector;

public class Particle {

	private int posX;
  	private int posY;
  	private int vX;
  	private int vY;
  	
  	
  	public Particle(int posX, int posY, int vX, int vY)
	{
		this.posX = posX;
		this.posY = posY;
		this.vX = vX;
		this.vY = vY;
	}
	
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public int getvX() {
		return vX;
	}
	public void setvX(int vX) {
		this.vX = vX;
	}
	public int getvY() {
		return vY;
	}
	public void setvY(int vY) {
		this.vY = vY;
	}

  	
  	public void applyForce(Force f) {
  		//TODO
  	}
  	
}