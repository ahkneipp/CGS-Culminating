package com.canine505.util;

import java.util.ArrayList;
import java.util.Random;
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
		return colors.get(generator.nextInt(13));
	}
	//random generator to select the random color
	private static Random generator = new Random();
	//array list used to store all the colors
	private static ArrayList<Color> colors = new ArrayList<Color>(13);
}
