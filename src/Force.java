public class Force
{
	public float x = 0;
  	public float y = 0;

  	public float resultingForce()
  	{
  		return x+y;
  	}
  	
  	public Force add(Force f)
  	{
  		this.x += f.x;
  		this.y += f.y;
  		
  		return this;
  	}
}