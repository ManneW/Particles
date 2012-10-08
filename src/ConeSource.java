import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class ConeSource extends Source {
	
	int directionX, directionY, quadrant;

	@Override
	public void emitParticles() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.GREEN);
		int[] dir = {this.posX, posY};
		int[] pos = {this.directionX, this.directionY};
		g.drawLine(posX, posY, directionY, directionY);
		
		int pX = 0, pY = 0, p2X = 0, p2Y ;
		//			int p2Y = (int) (directionY - Math.sqrt((Math.pow((posX-directionX), 2) +Math.pow((posY-directionY), 2))*Math.sin((Math.PI/4-angle))));
		
		/*
		if((directionX-posX)>0 && (directionY-posY)>0){
			pX = 
			p2X = directionX;
			p2Y = posY;
		}
		else if((directionX-posX)>0 && (directionY-posY)<0){
			p2X = directionX;
			p2Y = -posY;
		}
		else if((directionX-posX)<0 && (directionY-posY)>0){
			p2X = -directionX;
			p2Y = posY;
		}
		else{
			p2X = -directionX;
			p2Y = -posY;
		}
		*/
		
		
		g.setColor(Color.ORANGE);
		g.drawLine(posX, posY, pX, pY);
		g.drawLine(posX, posY, p2X, p2Y);
		
	}

	public ConeSource() {
		super();
		// TODO Auto-generated constructor stub
		
	}
	
	
}