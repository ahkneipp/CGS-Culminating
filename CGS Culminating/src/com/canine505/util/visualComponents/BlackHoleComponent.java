package com.canine505.util.visualComponents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
//import javax.swing.JComponent;
import com.canine505.util.ErrorMessage;
import com.canine505.util.Mass;
import com.canine505.util.PhysicsVector;
import com.canine505.util.Velocity;
import com.canine505.main.*;
import com.canine505.util.libs.StdLib;
//import com.canine505.util.libs.UnitLib;
//import com.canine505.util.Movable;

/**
 * Created by Alex Kneipp on 2/26/15
 */
//TODO delete methods and fields overridden from MatterComponent.
//TODO check anything that has to do with Unit for accuracy
public class BlackHoleComponent extends MatterComponent //implements Movable
{
	////////////////
	//Constructors//
	////////////////
    public BlackHoleComponent()
    {
    	//create a black hole with a mass of 1000 kilograms
    	Mass initialMass = new Mass(1000.00);
    	this.mass = initialMass;
        this.vel = null;
        //set the initial position to the middle of the screen
        this.x = (BlackHoleSimulator.window.getWidth()/2)-((2 * StdLib.GRAVITATIONAL_CONSTANT *
            (initialMass.getValue() * initialMass.getUnitMultiplier()))/Math.pow(StdLib.SPEED_OF_LIGHT, 2));
        this.y = (BlackHoleSimulator.window.getHeight()/2)+((2 * StdLib.GRAVITATIONAL_CONSTANT *
            (initialMass.getValue() * initialMass.getUnitMultiplier()))/Math.pow(StdLib.SPEED_OF_LIGHT, 2));
        //set the preferred size to the schwarzchild radius for a given mass
        this.setPreferredSize(new Dimension((int)(2 * StdLib.GRAVITATIONAL_CONSTANT *
            mass.getValue() * mass.getUnitMultiplier() /Math.pow(StdLib.SPEED_OF_LIGHT, 2)),(int)(2 * StdLib.GRAVITATIONAL_CONSTANT *
            mass.getValue() * mass.getUnitMultiplier() /Math.pow(StdLib.SPEED_OF_LIGHT, 2))));
        //set the minimum size of the object to one by one
        this.setMinimumSize(new Dimension(1,1));
    }	
	public BlackHoleComponent(int initialX, int initialY, Mass initialMass, Velocity vel)
    {
        //set the starting position and mass of the black hole.
        this.x = initialX;
        this.y = initialY;
        this.mass = initialMass;
        this.vel = vel;
      //set the preferred size to the schwarzchild radius of the black hole
        this.setPreferredSize(new Dimension((int)(2 * StdLib.GRAVITATIONAL_CONSTANT *
                mass.getValue() * mass.getUnitMultiplier() /Math.pow(StdLib.SPEED_OF_LIGHT, 2)),(int)(2 * StdLib.GRAVITATIONAL_CONSTANT *
                mass.getValue() * mass.getUnitMultiplier() /Math.pow(StdLib.SPEED_OF_LIGHT, 2))));
      //set the minimum size of the object to one by one
        this.setMinimumSize(new Dimension(1,1));
    }
    //presumes you want the black hole at the center of the screen
    public BlackHoleComponent(Mass initialMass)
    {
        //set the initial mass of the black hole and the position to the center of the screen
        this.mass = initialMass;
        this.vel = null;
        this.x = (BlackHoleSimulator.window.getWidth()/2)-((2 * StdLib.GRAVITATIONAL_CONSTANT *
            (initialMass.getValue() * initialMass.getUnitMultiplier()))/Math.pow(StdLib.SPEED_OF_LIGHT, 2));
        this.y = (BlackHoleSimulator.window.getHeight()/2)+((2 * StdLib.GRAVITATIONAL_CONSTANT *
            (initialMass.getValue() * initialMass.getUnitMultiplier()))/Math.pow(StdLib.SPEED_OF_LIGHT, 2));
      //set the preferred size to the schwarzchild radius of the black hole
        this.setPreferredSize(new Dimension((int)(2 * StdLib.GRAVITATIONAL_CONSTANT *
                mass.getValue() * mass.getUnitMultiplier() /Math.pow(StdLib.SPEED_OF_LIGHT, 2)),(int)(2 * StdLib.GRAVITATIONAL_CONSTANT *
                mass.getValue() * mass.getUnitMultiplier() /Math.pow(StdLib.SPEED_OF_LIGHT, 2))));
      //set the minimum size of the object to one by one
        this.setMinimumSize(new Dimension(1,1));
    }
    ////////////////////
    //End Constructors//
    ////////////////////
    ///////////
    //Methods//
    ///////////
    /**
     * Draws the black hole where size is based on mass
     * @Override javax.swing.JComponent.paintComponent
     * @param g graphics parameter.
     */
    public void paintComponent(Graphics g)
    {
        //turn the standard graphics argument into the improved graphics2D object
        Graphics2D g2d = (Graphics2D) g;
        //set the preferred size to the schwarzchild radius of the black hole
        this.setPreferredSize(new Dimension((int)(2 * StdLib.GRAVITATIONAL_CONSTANT *
                mass.getValue() * mass.getUnitMultiplier() /Math.pow(StdLib.SPEED_OF_LIGHT, 2)),(int)(2 * StdLib.GRAVITATIONAL_CONSTANT *
                mass.getValue() * mass.getUnitMultiplier() /Math.pow(StdLib.SPEED_OF_LIGHT, 2))));
        updatePosition();
        g2d.setColor(Color.BLACK);
        //g2d.fillOval(10,10,70,70);
        //calculate the schwarzchild radius of the black hole and make that the diameter
        //TODO make sure the equation for schwarzchild radius returns in KM
        g2d.fillOval((int)this.x,(int)this.y,(int)(2 * StdLib.GRAVITATIONAL_CONSTANT *
            mass.getValue() * mass.getUnitMultiplier() /Math.pow(StdLib.SPEED_OF_LIGHT, 2)),
            (int)((2 * StdLib.GRAVITATIONAL_CONSTANT *(mass.getValue() * mass.getUnitMultiplier()))
                /Math.pow(StdLib.SPEED_OF_LIGHT, 2)));
        ErrorMessage.printTst("X: " + x + "Y: " + y + "Diameter: " + (int) (2 * StdLib.GRAVITATIONAL_CONSTANT * mass.getValue()
                * mass.getUnitMultiplier() / Math.pow(StdLib.SPEED_OF_LIGHT, 2)), false);
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
    	//System.out.println("X: " + this.x);
    	//System.out.println("Y: " + this.y);
    	this.x += (this.getVelocity().getVectorMatrixNotation()[0]/1000) * .1;
    	this.y += (this.getVelocity().getVectorMatrixNotation()[1]/1000) * .1;
        this.calculateHitbox();
    }
    //change the diameter of the black hole based on the current mass
    private void updateDiameter(Mass mass)
    {
        this.diameter = (2 * StdLib.GRAVITATIONAL_CONSTANT *
            (mass.getValue() * mass.getUnitMultiplier()))/Math.pow(StdLib.SPEED_OF_LIGHT, 2);
    }
    //updates the diameter based on an added mass instead of an absolute one
    private void addMass(Mass addedMass)
    {
        mass.setValue(mass.getValue() + (addedMass.getValue() * addedMass.getUnitMultiplier()));
        this.diameter = (2 * StdLib.GRAVITATIONAL_CONSTANT *
            (mass.getValue() * mass.getUnitMultiplier()))/Math.pow(StdLib.SPEED_OF_LIGHT, 2);
    }
    //TODO test to make sure it returns the correct values and not a blank array
    /**
     * @return An array with the x coordinate of the black hole at index 0 and the y coordinate at 1
     */
    public double[] getPosition()
    {
    	return new double[]{this.x,this.y};
    }
    /**
     * @return The velocity of the black hole
     */
    public PhysicsVector getVelocity()
    {
    	if(this.vel != null)
    	{
    		return this.vel;
    	}
    	else
    	{
    		ErrorMessage.printErr("Vel was null, returning blank vector. ", true);
    		return new PhysicsVector();
    	}
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
	
	@Override
	public Rectangle getHitbox() 
	{
		return hitbox;		
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
	//temp updateVelocity method to replace the other one below the fields
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
	
    
    //////////
    //fields//
    //////////
    private double x;
    private double y;
    private double diameter;
    private Mass mass;
    //private Velocity velocity;
    private Rectangle hitbox = null;
    //Characters before the dash are the initials of the class name, the ones after are the ones of the immediate superclass
    public static final String ID = "BHC-MC";
    //////////////
    //end fields//
    //////////////
	/*
	 * Black holes tend to suck up anything, even if it's bigger, so whenever there is a colission I assume perfect energy transfer
	 * (haha) and remove the non-black hole object, while merging its mass into that of the black hole.
	 * If too black hole objects collide, I remove the smaller and merge it into
	 * the larger. 
	 */
    //TODO temporary commenting out so the MatterComponent updateVelocity can take over
//	@Override
//	//TODO check
//	public void updateVelocity() 
//	{
//		//check if the black hole has collided with anything
//		MatterComponent temp = BlackHoleSimulator.components.get(this.hasCollided());
//		if(this.hasCollided() != -1)
//		{
//			//TODO Check if finished
//			//TODO don't access the mass field directly
//			//TODO use ID to find out what type of component the collider is 
//			if(this.mass.getValue() >= temp.mass.getValue()||this.getID().equals("BHC-MC"));
//			{
//				//TODO actually update the actual velocity
//				//TODO hand do math to check accuracy of following statement
//				this.addMass(new Mass(temp.mass.getValue(),1));
//				//Remove the "temp" object from the array list because it was just swallowed by a black hole
//				BlackHoleSimulator.components.remove(BlackHoleSimulator.components.get(this.hasCollided()));
//				//update
//				this.vel.setVectorMatrixNotation(new double[] {temp.vel.getVectorMatrixNotation()[0] + this.vel.getVectorMatrixNotation()[0],
//						this.vel.getVectorMatrixNotation()[1] + temp.vel.getVectorMatrixNotation()[1]});
//			}
//		}
//		for(int i = 0; i < BlackHoleSimulator.components.size(); i++)
//		this.vel = (Velocity) new PhysicsVector(new double[]{this.vel.getVectorMatrixNotation()[0] +
//				StdLib.calculateGravity(this, BlackHoleSimulator.components.get(i)).getVectorMatrixNotation()[0],
//				this.vel.getVectorMatrixNotation()[1] +	
//				StdLib.calculateGravity(this, BlackHoleSimulator.components.get(i)).getVectorMatrixNotation()[1]});
//	}
}