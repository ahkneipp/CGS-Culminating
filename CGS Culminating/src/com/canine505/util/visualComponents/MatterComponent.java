/**
 * 
 */
package com.canine505.util.visualComponents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

import com.canine505.main.BlackHoleSimulator;
import com.canine505.util.*;
import com.canine505.util.libs.StdLib;
/**
 * @author Alex Kneipp
 * Created on 4/11/15
 * Superclass for all components in the program that have mass and are made of matter
 */
public class MatterComponent extends JComponent implements Movable
{
	//Constructors
	public MatterComponent()
	{
		this.color = RandomColor.getRandomColor();
		this.vel = new Velocity(new double[]{0,0});
		this.mass = new Mass(0);
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
	//end Constructors
	//methods
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		this.updatePosition();
		g2d.setColor(this.color);
		g2d.fillOval((int)this.x,(int)this.y, (int)(2*this.radius), (int)(2*this.radius));
		this.updateVelocity();
	}
	
	public void setIsSelected(boolean selected)
	{
		this.isSelected = selected;
	}
	
	public boolean getIsSelected()
	{
		return isSelected;
	}	

	/**
	 * @return The ID string of the class.  Formatted so that the first few characters are the class name and the last few are
	 * the initials of the immediate superclass.
	 */
	@Override
	public String getID() 
	{
		return MatterComponent.ID;
	}
	
	@Override
	public int hasCollided() 
	{
		int temp = -1;
		for(int i = 0; i < BlackHoleSimulator.components.size(); i++)
		{
			if(BlackHoleSimulator.components.get(i).getHitbox() != this.getHitbox() && 
					BlackHoleSimulator.components.get(i).getHitbox().intersects(this.getHitbox()))
				temp = i;
		}
		return temp;
	}
	
	@Override
	//TODO update so that it may not redeclare rectangle every time
	public void calculateHitbox() 
	{
		int diameter = (int)(2 * StdLib.GRAVITATIONAL_CONSTANT *
	            mass.getValue() * mass.getUnitMultiplier() /Math.pow(StdLib.SPEED_OF_LIGHT, 2));
		int xCourner = (int) (this.x - diameter);
		int yCourner = (int) (this.y - diameter);
		hitbox = new Rectangle((int)(xCourner + diameter/Math.sqrt(2.0)), (int)(yCourner + diameter/Math.sqrt(2.0)),
				(int)(diameter/Math.sqrt(2.0)), (int)(diameter/Math.sqrt(2.0)));
	}
	
	public Color getColor()
	{
		return this.color;
	}
	
	@Override
	public Rectangle getHitbox() 
	{
		return hitbox;		
	}
    /**
     * @return The velocity of the component
     */
    public PhysicsVector getVelocity()
    {
    	return this.vel;
    }    
    /**
     * @return An array with the x coordinate of the black hole at index 0 and the y coordinate at 1
     */
    public double[] getPosition()
    {
    	return new double[]{this.x,this.y};
    }
	
    //TODO double check gravity math
    public void updatePosition()
    {
    	/*
        this.x = (BlackHoleSimulator.window.getWidth()/2)-((2 * StdLib.GRAVITATIONAL_CONSTANT *
            (mass.getValue() * mass.getUnitMultiplier()))/Math.pow(StdLib.SPEED_OF_LIGHT, 2));
        this.y = (BlackHoleSimulator.window.getHeight()/2)-((2 * StdLib.GRAVITATIONAL_CONSTANT *
            (mass.getValue() * mass.getUnitMultiplier()))/Math.pow(StdLib.SPEED_OF_LIGHT, 2));
            */
    	//@TESTTAG
    	this.x += (this.getVelocity().getVectorMatrixNotation()[0]/1000) * .1;
    	this.y += (this.getVelocity().getVectorMatrixNotation()[1]/1000) * .1;
        //this.calculateHitbox();
    }
    public Mass getMass()
    {
    	return mass;
    }
    
	@Override
	public void updateVelocity() 
	{
		if(vel != null)
		{
			double[] temp = new double[2];
			temp = vel.getVectorMatrixNotation();
			for(int i = 0; i < BlackHoleSimulator.components.size(); i++)
			{
				this.vel =new Velocity((temp[0] + StdLib.calculateGravity(this, 
						BlackHoleSimulator.components.get(i)).getVectorMatrixNotation()[0]) / 
						BlackHoleSimulator.components.get(i).getMass().getValue(), 
						temp[1] + StdLib.calculateGravity(this, 
						BlackHoleSimulator.components.get(i)).getVectorMatrixNotation()[1] /
						BlackHoleSimulator.components.get(i).getMass().getValue());
			}
		}
	}
	
	public void updateAll()
	{
		updateVelocity();
		updatePosition();
		calculateHitbox();
	}
	public int getX()
	{
		return (int) this.x;
	}
	public int getY()
	{
		return (int) this.y;
	}
	public void setX(double x)
	{
		this.x = x;
	}
	
	public void setY(double y)
	{
		this.y = y;
	}
	//end methods
	protected Mass mass = null;
	protected double radius = 0.0;
	//x value of the position of the component
	protected double x = 0;
	//y value of the position of the component
	protected double y = 0;
	protected Velocity vel = null;
	protected Color color = null;
	private Rectangle hitbox = null;
    //Characters before the dash are the initials of the class name, the ones after are the ones of the immediate superclass
    public static String ID = "MC-JC";
    protected boolean isSelected;
}
