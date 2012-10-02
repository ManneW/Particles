public abstract class Effect {

  public int posX;

  public int posY;

  public abstract Force forceAt(int posX, int posY);

}