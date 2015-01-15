package sim;

import greenfoot.Actor;

public class Lights extends Actor {

	public int count = 0;
	boolean isRed = true;
	boolean isGreen = false;
	Light state = Light.Red;
	public Lights(){
		this.setImage("Images/trafficLightGreen.png");
	}

	public void act(){
		if(isRed && count == 0){
			state = Light.Green;
			count += 250;
			isRed = false;
			isGreen = true;
			this.setImage("Images/trafficLightGreen.png");
		}
		else if(!isRed && !isGreen){
			if(count == 0){
				isRed = true;
				count = 250;
				this.setImage("Images/trafficLightRed.png");
			}
		}
		else if(!isRed && isGreen){
			if(count < 100){
				isGreen = false;
				this.setImage("Images/trafficLightYellow.png");

			}
		}
		count --;
	}
}

