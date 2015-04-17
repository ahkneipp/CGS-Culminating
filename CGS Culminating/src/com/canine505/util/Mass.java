package com.canine505.util;

import com.canine505.util.libs.UnitLib;
//TODO write get and set methods for the remaining fields.
/**
 * Created by Alex Kneipp on 2/8/15
 */
//TODO overhaul unit system to handle really large numbers BEFORE they hit complications
public class Mass extends Scalar
{
	public Mass(double value, Unit unit)
	{
		this.setValue(value/(unit.getUnitMultiplier()/Unit.getDefaultMultiplier()));
	}

    public Mass(double value, double unitMultiplier, String unit)
    {
        this.unit = new Unit(unitMultiplier/Unit.getDefaultMultiplier(),unit);
        this.setValue(value/unitMultiplier);
    }

    public Mass(double value, double unitMultiplier)
    {
        //TODO write method to guess unit and replace null with it, REMEMBER TO MULTIPLY UNIT MULTIPLIER BACK OUT
        //divides out default unit multiplier from unit multiplier to normalize and (in this case) shrink the number
        unit = new Unit(unitMultiplier/Unit.getDefaultMultiplier(),null);
        //sets value and divides it out by unit multiplier to normalize it into the unit
        this.setValue(value/unitMultiplier);
    }
    public double getUnitMultiplier()
    {
        return unit.getUnitMultiplier();
    }

    private Unit unit;
}
