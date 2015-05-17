package com.canine505.util.libs;

import com.canine505.util.PhysicsVector;
import com.canine505.util.visualComponents.MatterComponent;

/**
 * Created by Alex Kneipp on 2/26/2015.
 */
public class StdLib
{
    /**
     * Checks if a and b are near to each other within 10 decimal places
     * @Deprecated on 3/15/15 because I realized there was a built in version (Double.compare)
     * @param a The first number to be compared
     * @param b The second number to be compared
     * @return true if they are equal within 10 decimal places and false if not.
     */
    @Deprecated
    public static boolean isEqualTo(double a, double b)
    {
        //Multiply doubles by ten to the 10th and cast as long to eliminate the roundoff errors often found in doubles
        if((long)Math.pow(10,10)*a == (long)Math.pow(10,10)*b)
            return true;
        else
            return false;
    }
    
    public static PhysicsVector calculateGravity(MatterComponent m1, MatterComponent m2)
    {
    	return new PhysicsVector(Math.toDegrees(Math.atan((m1.getY()-m2.getY())/(m1.getX()-m2.getX()))),
    			(StdLib.GRAVITATIONAL_CONSTANT * m1.getMass().getValue() * m2.getMass().getValue())
    			/ (Math.sqrt(Math.pow(m2.getX() - m1.getX(), 2) + (Math.pow(m2.getY() + m1.getY(), 2)))*1000)/*multiply by 1000 because 
    			 * it needs to be converted to meters from the KM handed to it */);
    }
    
    public static PhysicsVector calculateGravity(double m1, double m2, double[] xs, double[]ys)
    {
		return new PhysicsVector(Math.toDegrees(Math.atan((ys[0]-ys[1])/(xs[0]-xs[1]))), (StdLib.GRAVITATIONAL_CONSTANT * m1 * m2)
    			/ (Math.sqrt(Math.pow(xs[1] - xs[0], 2) + (Math.pow(ys[1] + ys[0], 2)))*1000)/*multiply by 1000 because 
    			 * it needs to be converted to meters from the KM handed to it */);
    	
    }
    //unit in n-m/kg^2
    public static final double GRAVITATIONAL_CONSTANT = 6.67384 * Math.pow(10,-11);
    public static final String GRAVITATIONAL_CONSTANT_UNIT = "m^3 Kg^-1 s^-2";
    public static final double SPEED_OF_LIGHT = 299792458.0;
    public static final String SPEED_OF_LIGHT_UNIT = "m/s";
}
