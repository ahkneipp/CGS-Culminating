package com.canine505.util;

import com.canine505.util.libs.StdLib;
import com.canine505.util.libs.UnitLib;

/**
 * Created by Alex Kneipp on 2/27/2015.
 */
public class Unit 
{
    public Unit(double unitMultiplier, String unitName) 
    {
        this.unitName = unitName;
        this.unitMultiplier = unitMultiplier / Unit.defaultMultiplier;
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
    {
    	return this.unitMultiplier;
    }
    public String getUnitName()
    {
    	return this.unitName;
    }
    public static void setDefaultMultipler(double defaultUnitMultiplier)
    {
    	//Next two are included for compatibility with deprecated methods
    	Unit.defaultLengthUnit = new Unit(defaultUnitMultiplier, "Default");
    	Unit.defaultMassUnit = new Unit(defaultUnitMultiplier, "Default");
    	Unit.defaultMultiplier = defaultUnitMultiplier;
    }
    public static double getDefaultMultiplier()
    {
    	return Unit.defaultMultiplier;
    }

    /**
     * Sets the default unit in which values are expressed and multipliers are stored
     * @param defaultUnit The unit in which to express measures of mass.
     * @deprecated Replaced by setDefaultUnitMultipler()
     */
    @Deprecated
    public static void setDefaultMassUnit(Unit defaultUnit)
    {
        defaultMassUnit = defaultUnit;
    }
    /**
     * Sets the default unit in which values are expressed and multipliers are stored
     * @param defaultUnit The unit in which to express measures of length
     * @deprecated Replaced by setDefaultUnitMultipler()
     */
    @Deprecated
    public static void setDefaultLengthUnit(Unit defaultUnit)
    {
        defaultLengthUnit = defaultUnit;
    }

    //Next two no longer used because of lots of null pointer problems
    private static Unit defaultLengthUnit = null;
    private static Unit defaultMassUnit = null;
    private static double defaultMultiplier;
    private double unitMultiplier;
    private String unitName;
}
