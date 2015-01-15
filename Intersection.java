package sim;

import java.awt.Color;
import java.util.ArrayList;

import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class Intersection extends Actor {

	final static int WIDTH = 50;
	final static int LENGTH = 50;
	ArrayList<Car> close = new ArrayList<Car>();
	ArrayList<Car> approaching = new ArrayList<Car>();
	ArrayList<Car> exiting = new ArrayList<Car>();
	ArrayList<Car> gone = new ArrayList<Car>();
	GreenfootImage image = new GreenfootImage(WIDTH, LENGTH);

	public  Intersection(){
		this.setImage(image);
	}
	public void act(){
		approaching.addAll(this.getObjectsInRange(WIDTH, TrafficControl.class));
		for(TrafficControl a: approaching){
			a.approacking();
			approaching.remove(a);
		}
		close.addAll(this.getObjectsInRange(WIDTH/2, TrafficControl.class));
		for(TrafficControl a: close){
			a.entering();
			close.remove(a);
		}
		exiting.addAll(this.getObjectsInRange(WIDTH/2, TrafficControl.class));
		for(TrafficControl a: exiting){
			a.leaving();
			exiting.remove(a);
		}
		
	}
	public void lights(){
		Lights up = new Lights();
		getWorld().addObject(up, getX() + LENGTH/2,getY() - WIDTH);
		up.turn(180);
		up.count=250;
		Lights left = new Lights();
		getWorld().addObject(left, getX() -10 , getY());
		left.turn(90);
		Lights down = new Lights();
		getWorld().addObject(down, getX() + LENGTH/2, getY() + WIDTH);
		down.count=250;
		Lights right = new Lights();
		getWorld().addObject(right, getX() + LENGTH + 10, getY());
		right.turn(-90);
		
	}
}
