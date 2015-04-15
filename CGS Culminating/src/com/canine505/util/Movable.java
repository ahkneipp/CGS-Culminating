package com.canine505.util;

import java.awt.Rectangle;

/**
 * @author Alex Kneipp
 * Interface for all movable visual components
 */
public interface Movable 
{
	///////////
	//methods//
	///////////
	//should return the x and y values of the position in array indicies 0 and 1.
	public double[] getPosition();
	//should change x and y based on gravitational forces from other components and current velocity
	public void updatePosition();
	//should return the velocity in the manner of a velocity object
	public Velocity getVelocity();
	//should change the current velocity of the object based on collisions and the gravity of other objects
	public void updateVelocity();
	//should return true if it has collided with another component and false if it has not
	public boolean getHasCollided();
	//use earlier derived math to determine the size and position of the hitboxes
	public void calculateHitboxes();
	//use to store the rectangles for the hitbox
	public Rectangle[] hitbox = new Rectangle[8];
}
