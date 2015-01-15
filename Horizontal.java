package sim;

public class Horizontal extends Road {

	int width = TrafficWorld.WORLDWIDTH;
	int length = 50;

public Horizontal(){
	this.getImage().scale(width, length);
	this.getImage().clear();
}
public void spawnCars(int space,int y, int x, int rotate, int road, int a){
	x = 0; 
	y = road + offset;
	TrafficWorld.car[a] = new Car();
	getWorld().addObject(TrafficWorld.car[a], x, y);
	TrafficWorld.car[a].setRotation(rotate - 180);
	y += DISTANCE;
	x = width;
	a ++;
	TrafficWorld.car[a] = new Car();
	getWorld().addObject(TrafficWorld.car[a], x, y);
	TrafficWorld.car[a].setRotation(rotate);

}	
	
}
