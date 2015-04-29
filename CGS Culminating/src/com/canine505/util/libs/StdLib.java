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
    	return new PhysicsVector((StdLib.GRAVITATIONAL_CONSTANT * m1.getMass().getValue() * m2.getMass().getValue())
    			/ (Math.sqrt(Math.pow(m2.getX() - m1.getX(), 2) + (Math.pow(m2.getY() + m1.getY(), 2)))));
    }
    //unit in n-m/kg^2
    public static final double GRAVITATIONAL_CONSTANT = 6.67384 * Math.pow(10,-11);
    public static final String GRAVITATIONAL_CONSTANT_UNIT = "m^3 Kg^-1 s^-2";
    public static final double SPEED_OF_LIGHT = 299792458;
    public static final String SPEED_OF_LIGHT_UNIT = "m/s";
}
