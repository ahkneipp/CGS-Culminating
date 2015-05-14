package com.canine505.util;

import java.awt.Color;
/**
 * @author Alex Kneipp
 * Created on 4/11/15
 * A class to generate a random color for the drawing of MatterComponents
 */
public class RandomColor 
{
	public static Color getRandomColor()
	{
		return colors[randomWithRange(0,12)];
	}
	static int randomWithRange(int min, int max)
	{
	   int range = (max - min) + 1;     
	   return (int)(Math.random() * range) + min;
	}
	//array list used to store all the colors
	private static Color[] colors= {Color.BLACK ,Color.BLUE,Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA
		,Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};
}

