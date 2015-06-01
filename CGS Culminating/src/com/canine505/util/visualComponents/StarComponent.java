/**
 * 
 */
package com.canine505.util.visualComponents;

import java.awt.Rectangle;

import com.canine505.util.*;
/**
 * @author Alex Kneipp
 * Created on April 11, 2015
 * Component for stars.
 */
public class StarComponent extends MatterComponent //implements Movable
{
	public StarComponent(Mass mass, double radius, double temp, double age)
	{
		super(mass,radius);
		this.temperature = temp;
		this.age = age;
	}
	public StarComponent(Mass mass, double radius, double age)
	{
		super(mass, radius);
		this.age = age;
	}
	
	public StarComponent() 
	{
		this.color = RandomColor.getRandomColor();
	}
	/**
	 * @return The ID string of the class.  Formatted so that the first few characters are the class name and the last few are
	 * the initials of the immediate superclass.
	 */
	@Override
	public String getID() 
	{
		return this.ID;
	}

	private double temperature = 0.0;
	private double age = 0.0;
	public final int priority = 2;
    //Characters before the dash are the initials of the class name, the ones after are the ones of the immediate superclass
    public String ID = "SC-MC";
	
//	//TODO implement each method maybe in MatterComponent
//	@Override
//	public double[] getPosition() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	@Override
//	public void updatePosition() {
//		// TODO Auto-generated method stub
//		
//	}
//	@Override
//	public PhysicsVector getVelocity() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	@Override
//	public void updateVelocity() {
//		// TODO Auto-generated method stub
//		
//	}
//	@Override
//	public void calculateHitbox() {
//		// TODO Auto-generated method stub
//		
//	}
//	@Override
//	public int hasCollided() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//	@Override
//	public Rectangle getHitbox() {
//		// TODO Auto-generated method stub
//		return null;
//	}
    
}
