package sim;

public interface TrafficControl {


	public void leaving();
	public void approaching(Intersection x);
	public void entering(Intersection x); 
}
