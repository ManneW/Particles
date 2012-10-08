public class GravityEffect extends Effect {

	@Override
	public Force forceAt(int posX, int posY) {
		// TODO Auto-generated method stub
		Force f = new Force();
		f.x = 0;
		f.y = 0.2;
		
		return f;
	}
}