/**
 * 
 */
package com.canine505.util.visualComponents;

import javax.swing.JComponent;
import com.canine505.util.*;
/**
 * @author alex
 * Superclass for all components in the program that have mass and are made of matter
 */
public class MatterComponent extends JComponent
{
	public MatterComponent()
	{
		this(null,0.0);
	}
	public MatterComponent(Mass mass, double radius)
	{
		this.mass = mass;
		this.radius = radius;
	}
	protected Mass mass = null;
	protected double radius = 0.0;
}
