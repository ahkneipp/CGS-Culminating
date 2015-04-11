/**
 * 
 */
package com.canine505.util.visualComponents;

import java.awt.Color;

import javax.swing.JComponent;

import com.canine505.util.*;
/**
 * @author Alex Kneipp
 * Created on 4/11/15
 * Superclass for all components in the program that have mass and are made of matter
 */
public class MatterComponent extends JComponent
{
	public MatterComponent()
	{
		this.color = RandomColor.getRandomColor();
	}
	public MatterComponent(Mass mass, double radius)
	{
		this();
		this.mass = mass;
		this.radius = radius;
	}
	public MatterComponent(Mass mass, double radius, int x, int y, Velocity vel)
	{
		this();
		this.mass = mass;
		this.radius = radius;
		this.x = x;
		this.y = y;
		this.vel = vel;
	}
	protected Mass mass = null;
	protected double radius = 0.0;
	//x value of the position of the component
	protected int x = 0;
	//y value of the position of the component
	protected int y = 0;
	protected Velocity vel = null;
	protected Color color = null;
}
