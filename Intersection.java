package sim;

import java.awt.Color;

import greenfoot.Actor;

public class Intersection extends Actor {

	final static int WIDTH = 50;
	final static int LENGTH = 50;
	
	public  Intersection(){
		this.getImage().scale(WIDTH, LENGTH);
		this.getImage().clear();
	}
}
