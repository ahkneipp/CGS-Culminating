package com.canine505.main;

import com.canine505.util.ErrorMessage;
import com.canine505.util.Mass;
import com.canine505.util.libs.UnitLib;
import com.canine505.util.visualComponents.BlackHoleComponent;
import javax.swing.JFrame;


/**
 * Created by Alex Kneipp on 1/30/15
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
        Version 1.2 Indev - 4/10/15
         */
        System.out.print("Version: " + VERSION);
        System.out.println(", Last updated: " + LAST_UPDATED);

        //create test window of size 500^2, add a black hole component and set to visible
        window.setSize(500,500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //testing mass class and black hole component calculations
        window.add(new BlackHoleComponent(new Mass(1, (Double)UnitLib.STELLAR_MASS.getValue()[0])));
        //ErrorMessage.printErr(new Mass(1,UnitLib.ONE_SOLAR_MASS.getValue()).getValue(),true);
        window.setVisible(true);

        //Testing stuff goes here
        ErrorMessage.printTst(String.valueOf(Double.MAX_VALUE),false);
    }
    private static final String VERSION = "1.2 Indev";
    private static final String LAST_UPDATED = "4/10/15";
    public static final JFrame window = new JFrame();
}
