package com.canine505.util;

import com.canine505.util.PhysicsVector;
import com.canine505.util.libs.UnitLib;

import java.lang.System;

//TODO find out how to deal with unit crap
//TODO add methods to get and set magnitude in base units (times or divided by the unit multiplier.)

/**
 * Created by Alex Kneipp on 1/30/15
 */
public class Velocity extends PhysicsVector
{

    public Velocity(double direction, double magnitude, double unitMultiplier, String unitPrefix)
    {
        //print what the method gets as a multiplier for testing purposes
        ErrorMessage.printErr(unitMultiplier,false);
        this.unit = unitMultiplier;
        this.unitPrefix = unitPrefix;
        new PhysicsVector(direction, magnitude/unitMultiplier);
    }

    public Velocity(double direction, double magnitude, double unitMultiplier)
    {
        //print what the constructor gets as a multiplier for testing purposes
        ErrorMessage.printErr(unitMultiplier,false);
        this.unit = unitMultiplier;
        this.unitPrefix = UnitLib.guessUnitPrefix(unitMultiplier);
        new PhysicsVector(direction, magnitude/unitMultiplier);
    }
    public double getUnitMultiplier()
    {
        return unit;
    }
    public String getUnitPrefix()
    {
        return unitPrefix;
    }
    /**
     * The metric unit multiplier for the velocity class.  The unitPrefix string variable is an optional prefix to store
     * the metric prefix for the unit.
     * ex/ The deca- prefix would have a unit multiplier of 10, and the kilo- prefix would have a multiplier of 1000
     */
    public double unit;
    public String unitPrefix;
}