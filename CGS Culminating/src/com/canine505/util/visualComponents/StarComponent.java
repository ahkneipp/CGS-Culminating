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
	
	private double temperature = 0.0;
	private double age = 0.0;
    //Characters before the dash are the initials of the class name, the ones after are the ones of the immediate superclass
    public static final String ID = "SC-MC";
	
	//TODO implement each method maybe in MatterComponent
	@Override
	public double[] getPosition() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void updatePosition() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Velocity getVelocity() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void updateVelocity() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void calculateHitbox() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int hasCollided() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Rectangle getHitbox() {
		// TODO Auto-generated method stub
		return null;
	}
}
