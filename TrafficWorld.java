package sim;

import java.awt.Color;
import java.util.Random;

import greenfoot.World;

public class TrafficWorld extends World{

	final static int WORLDWIDTH = 1500;
	final static int WORLDHEIGHT = 900;
	final static int CELL = 1;
	final static int ROADWIDTH = 50;
	final static int DISTANCE = 25;
	final static int HROADS = 5;
	final static int VROADS = 7;
	final static int HOFFSET = (WORLDWIDTH - ROADWIDTH) / (VROADS - 1); 
	final static int VOFFSET = (WORLDHEIGHT - ROADWIDTH) / (HROADS - 1); 
	int YroadStart = 0;
	int XroadStart = 0;
	final static int YSTART = 10;
	static int nCars = (HROADS + VROADS) * 2;
	Random gen = new Random();
	Horizontal[] hroad = new Horizontal[HROADS];
	Vertical[] vroad = new Vertical[VROADS];
	static Car[] car = new Car[nCars];
	int a = 1;
	int Xposition = 0;
	int Yposition = 0;
	public TrafficWorld(){
		super(WORLDWIDTH, WORLDHEIGHT, CELL);
		background();
		spawnRoads();
		spawnIntersect();
	}
	public void spawnRoads(){
		int rotate = 0;
		this.getBackground().setColor(Color.gray);
		for(int i = 0; i <HROADS; i ++){
			rotate = 0;
			hroad[i] = new Horizontal();
			addObject(hroad[i],XroadStart ,YroadStart);
			hroad[i].draw(XroadStart, YroadStart, hroad[i].width, hroad[i].length);
			rotate = 180;
			hroad[i].spawnCars(WORLDWIDTH, Xposition, Yposition, rotate, YroadStart, a);
			YroadStart += VOFFSET;
			a ++;
		}
		YroadStart = 0;
		for(int i = 0; i<VROADS; i ++){
			rotate = 270;
			vroad[i] = new Vertical();
			addObject(vroad[i],XroadStart ,YroadStart);
			vroad[i].draw(XroadStart, YroadStart, vroad[i].width, vroad[i].length);
			vroad[i].spawnCars(WORLDHEIGHT, Yposition, Xposition, rotate, XroadStart, a);
			XroadStart += HOFFSET;
			a ++;
		}
	}
	public void spawnIntersect(){
		int i = 0;
		int a = 0;
		int x = ((i + 1) * (a + 1)) + 1;
		Intersection[] intersect = new Intersection[VROADS * HROADS];
		for( i = 0; i<VROADS ; i ++){
			for( a = 0; a < HROADS ; a ++){
				intersect[x] = new Intersection();
				this.addObject(intersect[x],vroad[i].getX(), hroad[a].getY() + DISTANCE);
				intersect[x].lights();
			}
		}
	}

	public void background(){
		this.getBackground().setColor(Color.GREEN);
		this.getBackground().fill();


	}
	
	}

