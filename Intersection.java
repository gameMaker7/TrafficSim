package sim;

import java.awt.Color;
import java.util.ArrayList;

import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class Intersection extends Actor {

	final static int SIZE = 50;
	final static int RADIUS = 50;
	ArrayList<TrafficControl> close = new ArrayList<TrafficControl>();
	ArrayList<TrafficControl> in = new ArrayList<TrafficControl>();
	ArrayList<TrafficControl> approaching = new ArrayList<TrafficControl>();
	ArrayList<TrafficControl> exiting = new ArrayList<TrafficControl>();
	GreenfootImage image = new GreenfootImage(SIZE, SIZE);
	Light hState = Light.GREEN;
	Light vState = Light.RED;
	private int count = 0;
	private int change = 100;
	private int change2 = 200;
	private int total = 300;
	private Lights up;
	private Lights down;
	private Lights right;
	private Lights left;
	private int wait = 400;;

	public  Intersection(int x, int y){
		this.setImage(image);
	}
	public void act(){
		lightControl();
		commands();

	}
	private void lightControl() {
		if( count == 0){
			hState = Light.GREEN;
			left.setImage("Images/trafficLightGreen.png");
			right.setImage("Images/trafficLightGreen.png");

			vState = Light.RED;
			down.setImage("Images/trafficLightRed.png");
			up.setImage("Images/trafficLightRed.png");
		}
		count ++;
		 if(count == change){
			hState = Light.YELLOW;
			left.setImage("Images/trafficLightYellow.png");
			right.setImage("Images/trafficLightYellow.png");

			vState = Light.RED;
			up.setImage("Images/trafficLightRed.png");
			down.setImage("Images/trafficLightRed.png");

		}
		else if(count == change2){
			hState = Light.RED;
			left.setImage("Images/trafficLightRed.png");
			right.setImage("Images/trafficLightRed.png");

			vState = Light.GREEN;
			down.setImage("Images/trafficLightGreen.png");
			up.setImage("Images/trafficLightGreen.png");
		}

		else if(count == total){
			hState = Light.RED;
			left.setImage("Images/trafficLightRed.png");
			right.setImage("Images/trafficLightRed.png");

			vState = Light.YELLOW;
			down.setImage("Images/trafficLightYellow.png");
			up.setImage("Images/trafficLightYellow.png");

		}

		else if(count == wait){
			count = 0;
		}
	}

	public void commands(){
		ArrayList<TrafficControl> a1 = (ArrayList<TrafficControl>) this.getObjectsInRange(RADIUS, TrafficControl.class);
		ArrayList<TrafficControl> a2 = (ArrayList<TrafficControl>) this.getObjectsInRange(RADIUS/2, TrafficControl.class);

		ArrayList<TrafficControl> a3 = (ArrayList<TrafficControl>) close.clone();
		for(TrafficControl a: a3){
			if(!a1.contains(a)){
				close.remove(a);
				a.leaving();
			}
		}
		for(TrafficControl a: a1){
			if(!approaching.contains(a) && !in.contains(a)){
				close.add(a);
				approaching.add(a);
				a.approaching(this);
			}

		}
		for(TrafficControl a: a2){
			if(approaching.contains(a) && !in.contains(a)){
				in.add(a);
				approaching.remove(a);
				a.entering(this);
			}

		}

	}

	public void lights(){
		up = new Lights();
		getWorld().addObject(up, getX() + SIZE/2,getY() - SIZE);
		up.turn(180);
		left = new Lights();
		getWorld().addObject(left, getX() -10 , getY());
		left.turn(90);
		down = new Lights();
		getWorld().addObject(down, getX() + SIZE/2, getY() + SIZE);
		right = new Lights();
		getWorld().addObject(right, getX() + SIZE + 10, getY());
		right.turn(-90);

	}
}
