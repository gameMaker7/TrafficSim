package sim;

public class Vertical extends Road{

	int width = 50;
	int length = TrafficWorld.WORLDHEIGHT;
	
	public Vertical(){
		this.getImage().scale(width, length);
		this.getImage().clear();
		
	}
	public void spawnCars(int space, int x, int y, int rotate, int road, int a){
		y = gen.nextInt(space);
		x = road + offset;
		TrafficWorld.car[a] = new Car();
		getWorld().addObject(TrafficWorld.car[a], x, y);
		System.out.println(x +" " + y);
		TrafficWorld.car[a].setRotation(rotate - 180);
		x += DISTANCE;
		y = gen.nextInt(space);
		a ++;
		TrafficWorld.car[a] = new Car();
		getWorld().addObject(TrafficWorld.car[a], x, y);
		TrafficWorld.car[a].setRotation(rotate);

	}	
}
