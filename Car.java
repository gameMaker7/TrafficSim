package sim;


import java.util.Random;

import greenfoot.Actor;

public class Car extends Actor implements TrafficControl{
	Random gen = new Random();
	private int car = gen.nextInt(4);
	private int speed = gen.nextInt(5) + 1;
	Direction state = Direction.EAST;
	private int offset = 5;
	private int length = TrafficWorld.WORLDWIDTH - offset;
	private int width = TrafficWorld.WORLDHEIGHT - offset;
	private boolean move;
	private Light go;

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

		if(move){
			if(go == Light.GREEN){
				speed = gen.nextInt(5) + 1;
				move = false;
			}
		}

	}	
	@Override
	public void entering(Intersection x){
		if(state == Direction.EAST || state == Direction.WEST){
			go = x.hState;
			switch(x.hState){
			case RED: 
				speed = 0;
				move = true;
				break;
			default:
				break;
			}
			if(state == Direction.NORTH || state == Direction.SOUTH){
				go = x.vState;
				switch(x.vState){
				case RED: 
					speed = 0;
					move = true;
					break;
				default:
					break;
				}
			}
		}		
	}

	@Override
	public void leaving() {
	}
	@Override
	public void approaching(Intersection x) {
		if(state == Direction.EAST || state == Direction.WEST){
			switch(x.hState){
			case YELLOW:
				speed = 1;
				break;
			case RED: 
				speed = 1;
				break;
			default:
				break;
			}
			if(state == Direction.NORTH || state == Direction.SOUTH){
				switch(x.vState){
				case YELLOW:
					speed = 1;
					break;
				case RED: 
					speed = 1;
					break;
				default:
					break;
				}
			}		
		}
	}
}
