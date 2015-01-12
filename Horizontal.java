package sim;

public class Horizontal extends Road {

	int width = TrafficWorld.WORLDWIDTH;
	int length = 50;

public Horizontal(){
	this.getImage().scale(width, length);
	this.getImage().clear();
}
public void spawnCars(int space, int x, int y, int rotate, int road, int a){
	x = gen.nextInt(space);
	y = road + offset;
	TrafficWorld.car[a] = new Car();
	getWorld().addObject(TrafficWorld.car[a], x, y);
	System.out.println(x +" " + y);
	TrafficWorld.car[a].setRotation(rotate - 180);
	y += DISTANCE;
	x = gen.nextInt(space);
	a ++;
	TrafficWorld.car[a] = new Car();
	getWorld().addObject(TrafficWorld.car[a], x, y);
	TrafficWorld.car[a].setRotation(rotate);

}	
	
}
