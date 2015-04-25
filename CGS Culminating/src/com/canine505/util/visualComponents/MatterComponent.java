/**
 * 
 */
package com.canine505.util.visualComponents;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JComponent;

import com.canine505.util.*;
/**
 * @author Alex Kneipp
 * Created on 4/11/15
 * Superclass for all components in the program that have mass and are made of matter
 */
public class MatterComponent extends JComponent implements Movable
{
	public MatterComponent()
	{
		this.color = RandomColor.getRandomColor();
	}
	public MatterComponent(Mass mass, double radius)
	{
		this();
		this.mass = mass;
		this.radius = radius;
	}
	public MatterComponent(Mass mass, double radius, int x, int y, Velocity vel)
	{
		this();
		this.mass = mass;
		this.radius = radius;
		this.x = x;
		this.y = y;
		this.vel = vel;
	}
	protected Mass mass = null;
	protected double radius = 0.0;
	//x value of the position of the component
	protected int x = 0;
	//y value of the position of the component
	protected int y = 0;
	protected Velocity vel = null;
	protected Color color = null;
    //Characters before the dash are the initials of the class name, the ones after are the ones of the immediate superclass
    public static final String ID = "MC-JC";
	
	//The following methods are simply overrided by the sub clases until I can get around to standardizing them
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
	public int hasCollided() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void calculateHitbox() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Rectangle getHitbox() {
		// TODO Auto-generated method stub
		return null;
	}
}
