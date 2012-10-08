public class Force
{
	public double x = 0;
  	public double y = 0;

  	public double resultingForce()
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