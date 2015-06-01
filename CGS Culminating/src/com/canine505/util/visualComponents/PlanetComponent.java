/**
 * 
 */
package com.canine505.util.visualComponents;

import java.awt.Rectangle;

import com.canine505.util.Movable;
import com.canine505.util.PhysicsVector;
/**
 * @author Alex Kneipp
 *
 */
public class PlanetComponent extends MatterComponent //implements Movable 
{

//	@Override
//	public double[] getPosition() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void updatePosition() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public PhysicsVector getVelocity() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void updateVelocity() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public int hasCollided() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public void calculateHitbox() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public Rectangle getHitbox() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	/**
	 * @return The ID string of the class.  Formatted so that the first few characters are the class name and the last few are
	 * the initials of the immediate superclass.
	 */
	@Override
	public String getID() 
	{
		return this.ID;
	}
	
    //Characters before the dash are the initials of the class name, the ones after are the ones of the immediate superclass
    public String ID = "PC-MC";
    public final int priority = 1;

}
