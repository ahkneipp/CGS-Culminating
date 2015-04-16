package com.canine505.util.visualComponents;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;
import com.canine505.util.ErrorMessage;
import com.canine505.util.Mass;
import com.canine505.util.Velocity;
import com.canine505.main.*;
import com.canine505.util.libs.StdLib;
import com.canine505.util.libs.UnitLib;
import com.canine505.util.Movable;

/**
 * Created by Alex Kneipp on 2/26/15
 */
public class BlackHoleComponent extends JComponent implements Movable
{
	////////////////
	//Constructors//
	////////////////
    public BlackHoleComponent(int initialX, int initialY, Mass initialMass, Velocity vel)
    {
        //set the starting position and mass of the black hole.
        this.x = initialX;
        this.y = initialY;
        this.mass = initialMass;
        this.velocity = vel;
    }
    //presumes you want the black hole at the center of the screen
    public BlackHoleComponent(Mass initialMass)
    {
        //set the initial mass of the black hole and the position to the center of the screen
        this.mass = initialMass;
        this.velocity = null;
        this.x = (BlackHoleSimulator.window.getWidth()/2)-((2 * StdLib.GRAVITATIONAL_CONSTANT *
            (initialMass.getValue() * initialMass.getUnitMultiplier()))/Math.pow(StdLib.SPEED_OF_LIGHT, 2));
        this.y = (BlackHoleSimulator.window.getHeight()/2)+((2 * StdLib.GRAVITATIONAL_CONSTANT *
            (initialMass.getValue() * initialMass.getUnitMultiplier()))/Math.pow(StdLib.SPEED_OF_LIGHT, 2));
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
        updatePosition();
        //g2d.fillOval(10,10,70,70);
        //calculate the schwarzchild radius of the black hole and make that the diameter
        //TODO figure out size scaling
        g2d.drawOval((int)this.x,(int)this.y,(int)(2 * StdLib.GRAVITATIONAL_CONSTANT *
            mass.getValue() * mass.getUnitMultiplier() /Math.pow(StdLib.SPEED_OF_LIGHT, 2)),
            (int)((2 * StdLib.GRAVITATIONAL_CONSTANT *(mass.getValue() * mass.getUnitMultiplier()))
                /Math.pow(StdLib.SPEED_OF_LIGHT, 2)));
        ErrorMessage.printTst("X: " + x + "Y: " + y + "Diameter: " + (int) (2 * StdLib.GRAVITATIONAL_CONSTANT * mass.getValue()
                * mass.getUnitMultiplier() / Math.pow(StdLib.SPEED_OF_LIGHT, 2)), false);
    }
    //TODO make the method more adaptive so Gravity can work
    //Keeps the black hole in the center for now
    public void updatePosition()
    {
        this.x = (BlackHoleSimulator.window.getWidth()/2)-((2 * StdLib.GRAVITATIONAL_CONSTANT *
            (mass.getValue() * mass.getUnitMultiplier()))/Math.pow(StdLib.SPEED_OF_LIGHT, 2));
        this.y = (BlackHoleSimulator.window.getHeight()/2)-((2 * StdLib.GRAVITATIONAL_CONSTANT *
            (mass.getValue() * mass.getUnitMultiplier()))/Math.pow(StdLib.SPEED_OF_LIGHT, 2));
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
    public Velocity getVelocity()
    {
    	return this.velocity;
    }
    
    //////////
    //fields//
    //////////
    private double x;
    private double y;
    private double diameter;
    private Mass mass;
    private Velocity velocity;
    private Rectangle hitbox = null;
    //////////////
    //end fields//
    //////////////
	
    //TODO implement
	@Override
	public void updateVelocity() {
		// TODO Auto-generated method stub
		
	}

	@Override
	//TODO low efficiency version, comparing everything to everything else.  Can improve by using the handshake problem
	public boolean getHasCollided() 
	{
		//TODO compare everything to everything else using nested fors.
		boolean temp = false;
		for(int i = 0; i < BlackHoleSimulator.components.size(); i++)
		{
			if(BlackHoleSimulator.components.get(i).getHitbox().intersects()
		}
		return temp;
	}
	
	@Override
	public void calculateHitboxes() 
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

}