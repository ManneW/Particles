import java.awt.Point;

public class WindEffect extends Effect {

	@Override
	public Force forceAt(int posX, int posY) {
		// TODO Auto-generated method stub
		Point p1 = new Point(this.posX, this.posY);
		Point p2 = new Point(posX, posY);
		double distance = p1.distance(p2);
		
		double fanReach = 2000;
		double fanForce = 1;
		double force;
		if (distance > fanReach) {
			force = 0;
		} else {
			force = 1 - distance/fanReach;
		}
		
		
		Point direction = new Point(p2.x-p1.x, p2.y-p1.y);
		direction.x = (int)Math.round(((double)direction.x)/Math.sqrt(direction.x*direction.x + direction.y*direction.y));
		direction.y = (int)Math.round(((double)direction.y)/Math.sqrt(direction.x*direction.x + direction.y*direction.y));
		
		Force f = new Force();
		f.x = (float)(direction.x * force * fanForce);
		f.y = (float)(direction.y * force * fanForce);
		
		
		return f;
	}
}