package com.canine505.util;

import com.canine505.util.PhysicsVector;
import com.canine505.util.libs.UnitLib;

import java.lang.System;

//TODO add methods to get and set magnitude in base units (times or divided by the unit multiplier.)

/**
 * Created by Alex Kneipp on 1/30/15
 */
public class Velocity extends PhysicsVector
{

    public Velocity(double direction, double magnitude, Unit unit)
    {
        //print what the method gets as a multiplier for testing purposes
    	this.unit = unit;
        this.direction = direction;
        this.magnitude = magnitude;
    }
    public double getUnitMultiplier()
    {
        return unit.getUnitMultiplier()/Unit.getDefaultMultiplier();
    }

    public String getUnitName()
    {
        return unit.getUnitName();
    }
    /**
     * The metric unit multiplier for the velocity class.  The unitPrefix string variable is an optional prefix to store
     * the metric prefix for the unit.
     * ex/ The deca- prefix would have a unit multiplier of 10, and the kilo- prefix would have a multiplier of 1000
     */
    private Unit unit = null;
}