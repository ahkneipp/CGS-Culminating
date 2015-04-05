package com.canine505.util;

import com.canine505.util.libs.StdLib;
import com.canine505.util.libs.UnitLib;

/**
 * Created by Alex Kneipp on 2/27/2015.
 */
public class Unit {


    public Unit(double unitMultiplier, String unitName) {
        this.unitName = unitName;
        //try to guess if the unit refers to a measure of length
        if ((this.defaultMassUnit != null && this.unitName.length() < 5 && this.unitName.substring(this.unitName.length()
            - 5).equals("meter")) || this.unitName.equals(UnitLib.ASTRONOMICAL_UNIT.unitName))
        {
            //if so, divide the given(absolute) by the default unit multiplier to yield a relative multiplier
            this.unitMultiplier = unitMultiplier / this.defaultLengthUnit.getUnitMultiplier();
        }
        //do the same thing as above but with mass
        if ((this.defaultLengthUnit != null && this.unitName.length() < 5 && this.unitName.substring(this.unitName.length()
            - 4).equals("gram")) || this.unitName.equals(UnitLib.STELLAR_MASS))
        {
            this.unitMultiplier = unitMultiplier / this.defaultLengthUnit.getUnitMultiplier();
        }
    }

    /**
     * Gives the entire unit using an object Array with a Double object and String object, in that order.
     * @return An object Array with a Double object and String object, in that order.
     */
    public Object[] getValue()
    {
        return new Object[] {new Double(unitMultiplier),unitName};
    }
    public double getUnitMultiplier()
    {return this.unitMultiplier;}
    //The following two methods set the default unit (kilograms/kilometers at the time this comment was written) so the
    //program can handle large numbers
    public static void setDefaultMassUnit(Unit defaultUnit)
    {
        defaultMassUnit = defaultUnit;
    }
    public static void setDefaultLengthUnit(Unit defaultUnit)
    {
        defaultLengthUnit = defaultUnit;
    }

    private static Unit defaultLengthUnit;
    public static Unit defaultMassUnit;
    private double unitMultiplier;
    private String unitName;
}
