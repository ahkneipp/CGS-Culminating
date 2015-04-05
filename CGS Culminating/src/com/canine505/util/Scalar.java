package com.canine505.util;

/**
 * Class that represents any scalar quantity (eg/ mass, speed, but not velocity)
 * Created by Alex Kneipp on 2/8/15
 */
public class Scalar
{
    public Scalar(double value)
    {
        this.value = value;
    }
    public Scalar()
    {
        this(0);
    }
    public double getValue()
    {
        return value;
    }
    public void setValue(double value)
    {
        this.value = value;
    }
    public Scalar get()
    {
        return this;
    }
    private double value;
}