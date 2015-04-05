package com.canine505.util.libs;

import com.canine505.util.ErrorMessage;
import com.canine505.util.Mass;
import com.canine505.util.Unit;
//TODO maybe change guessUnitPrefix so it returns units instead of unit prefix, add constructor for base unit
/**
 * Created by Alex Kneipp on 2/26/2015.
 */
public class UnitLib
{
    /**
     * Attempts to guess the prefix of a unit based on the given unitMultiplier
     * Deprecated on 3/15/15 for the Mass overhaul
     * @param unitMultiplier The multiplier of the unit the method is trying to guess (1000 would yield kilo)
     * @return The guessed unit prefix, none if the unit multiplier is one, or null if the unit multiplier couldn't be guessed
     */
    @Deprecated
    public static String guessUnitPrefix(double unitMultiplier)
    {
        if(StdLib.isEqualTo(unitMultiplier,1))
        {
            System.out.println("Guessing unitPrefix is \"none\"");
            return "none";
        }
        else if(StdLib.isEqualTo(unitMultiplier,10))
        {
            System.out.println("Guessing unitPrefix is \"deca\"");
            return "deca";
        }
        else if(StdLib.isEqualTo(unitMultiplier,100))
        {
            System.out.println("Guessing unitPrefix is \"hecto\"");
            return "hecto";
        }
        else if(StdLib.isEqualTo(unitMultiplier,1000))
        {
            System.out.println("Guessing unitPrefix is \"kilo\"");
            return "kilo";
        }
        else if(StdLib.isEqualTo(unitMultiplier,1000000))
        {
            System.out.println("Guessing unitPrefix is \"mega\"");
            return "mega";
        }
        else if(StdLib.isEqualTo(unitMultiplier,Math.pow(10,9)))
        {
            System.out.println("Guessing unitPrefix is \"giga\"");
            return "giga";
        }
        else if(StdLib.isEqualTo(unitMultiplier,Math.pow(10,12)))
        {
            System.out.println("Guessing unitPrefix is \"tera\"");
            return "tera";
        }
        else if(StdLib.isEqualTo(unitMultiplier,Math.pow(10,15)))
        {
            System.out.println("Guessing unitPrefix is \"peta\"");
            return "peta";
        }
        else if(StdLib.isEqualTo(unitMultiplier,Math.pow(10,-1)))
        {
            System.out.println("Guessing unitPrefix is \"deci\"");
            return "deci";
        }
        else if(StdLib.isEqualTo(unitMultiplier,Math.pow(10,-2)))
        {
            System.out.println("Guessing unitPrefix is \"centi\"");
            return "centi";
        }
        else if(StdLib.isEqualTo(unitMultiplier,Math.pow(10,-3)))
        {
            System.out.println("Guessing unitPrefix is \"milli\"");
            return "milli";
        }
        else if(StdLib.isEqualTo(unitMultiplier,Math.pow(10,-6)))
        {
            System.out.println("Guessing unitPrefix is \"micro\"");
            return "micro";
        }
        else if(StdLib.isEqualTo(unitMultiplier,Math.pow(10,-9))) {
            System.out.println("Guessing unitPrefix is \"nano\"");
            return "nano";
        }
        //TODO commented out for mass system switchover
       /* else if(StdLib.isEqualTo(unitMultiplier,ONE_SOLAR_MASS.getValue()))
        {
            System.out.println("Guessing unitPrefix is \"Solar Mass\"");
            return "Solar Mass";
        }*/
        else
        {
            System.out.print("Could not guess prefix.");
            System.out.println("Returning null...");
            ErrorMessage.printErr("Either the unitMutiplier did not correspond to a metric unit prefix, the Multiplier was " +
                "too large or too small, or the multiplier was beyond the bounds of the \"long\" data typ\n", false);
            return null;
        }
    }
    //unit is kilograms
    public static final Unit STELLAR_MASS = new Unit(1.98892 * Math.pow(10,33),"Stellar Mass");
    public static final Unit KILOGRAM = new Unit(1000, "Kilogram");
    public static final Unit KILOMETER = new Unit(1000, "Kilometer");
    public static final Unit ASTRONOMICAL_UNIT = new Unit (149597870.7, "AU");
    public static final Unit LIGHT_YEAR = new Unit (9.46073 * Math.pow(10,12), "LY");

}
