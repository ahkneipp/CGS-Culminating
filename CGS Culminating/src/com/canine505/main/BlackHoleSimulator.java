package com.canine505.main;

import java.awt.Component;
import java.util.ArrayList;

import com.canine505.util.ErrorMessage;
import com.canine505.util.Mass;
import com.canine505.util.Movable;
import com.canine505.util.libs.StdLib;
import com.canine505.util.libs.UnitLib;
import com.canine505.util.visualComponents.BlackHoleComponent;
import com.canine505.util.visualComponents.MatterComponent;

import javax.swing.JFrame;
//import javax.swing.JPanel;
import javax.swing.JComponent;


/**
 * Created by Alex Kneipp on 1/30/15
 * Viewer class for Alex Kneipp's CGS Culminating project.
 * The class assumes every computation equals one second.
 * Gravity is calculated using values in the UnitLib library, and methods required by the Movable interface.
 * The movable interface is implemented by the MatterComponent class, which every movable component extends.
 */
public class BlackHoleSimulator
{
    public static void main(String[] args)
    {
        //TODO set to false before any presentation
        ErrorMessage.setPrintErrorStatements(true);
        //TODO set to false before any presentation
        ErrorMessage.setPrintTestingStatements(true);
        //Sets the default multiplier to handle larger numbers
        com.canine505.util.Unit.setDefaultMultipler(1000.0);
        System.out.println("Black Hole Simulator");
        System.out.println("Written by Canine505");
        /*
        Place all previous versions and date updated in this block comment.
        See Changelog.txt for specific updates
        Version 1.0 Indev - 1/30/15
        Version 1.01 Indev - 2/8/15
        Version 1.02 Indev - 2/26/15
        Version 1.021 Indev - 2/27/15
        Version 1.1 Indev - 3/15/15
        Version 1.11 Indev - 3/20/15
        Version 1.2 Indev - 4/10/15, 4/11/15
        Version 1.21 Indev - 4/14/15, 4/15/15, 4/16/15, 4/17/15
        Version 1.22 Indev - 4/25/15
         */
        System.out.print("Version: " + VERSION);
        System.out.println(", Last updated: " + LAST_UPDATED);
        //testing mass class and black hole component calculations
        components.add(new BlackHoleComponent(new Mass(1, (Double)UnitLib.STELLAR_MASS.getValue()[0])));
        //create test window of size 500^2 pixels, add a black hole component and set to visible
        window.setSize(500,500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //TODO increase efficiency so it doesn't iterate through the whole ArrayList every time you want to add something.
        for(int i = 0; i < components.size(); i++)
        {
        	window.add((JComponent) components.get(i));
        }
        //ErrorMessage.printErr(new Mass(1,UnitLib.ONE_SOLAR_MASS.getValue()).getValue(),true);
        window.setVisible(true);
        //Testing stuff goes here
        ErrorMessage.printTst(String.valueOf(Double.MAX_VALUE),false);
        double[] x = new double[] {0,90}; 
        double[] y = new double[] {0,90};
        ErrorMessage.printTst("FOG: <" + StdLib.calculateGravity(1000000.0, 1000000.0, x,y).getVectorMatrixNotation()[0] + ", " +  
        		StdLib.calculateGravity(1000000.0, 1000000.0, x,y).getVectorMatrixNotation()[1] + ">", false);
    }
    private static final String VERSION = "1.22 Indev";
    private static final String LAST_UPDATED = "4/28/15";
    public static final JFrame window = new JFrame();
    public static final ArrayList<MatterComponent> components = new ArrayList<MatterComponent>(5);
}
