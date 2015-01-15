package sim;


import java.util.Random;

import greenfoot.Actor;

public class Car extends Actor implements TrafficControl{
	Random gen = new Random();
	int car = gen.nextInt(4);
	int speed = gen.nextInt(5) + 1;
	int offset = 5;
	int length = TrafficWorld.WORLDWIDTH - offset;
	int width = TrafficWorld.WORLDHEIGHT - offset;
	boolean slow = false;
	boolean speedUp = false;

	private enum Range{FAR, APPROACHING, CLOSE}
	public Car(){
		switch(car){
		case 0: this.setImage("images/topCarYellow.png");
		break;
		case 1: this.setImage("images/topCarBlue.png");
		break;
		case 2: this.setImage("images/topCarRed.png");
		break;
		default: this.setImage("images/topCarPurple.png");
		break;
		}
	}
	public void act(){

		if(getX() < offset)this.setLocation(length, getY());
		if(getX() > length)this.setLocation(offset, getY());
		if(getY() < offset)this.setLocation(getX(), width);
		if(getY() > width)this.setLocation(getX(), offset);

		move(speed);



	}
	@Override
	public void approacking() {
		if(!slow){speed = 1;
		}
		slow = true;
		}
	@Override
	public void entering() {
		speedUp = true;
	}

	@Override
	public void leaving() {
		slow = false;
	}
}
