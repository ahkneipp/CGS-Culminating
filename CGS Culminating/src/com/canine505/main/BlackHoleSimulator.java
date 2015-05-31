package com.canine505.main;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Scanner;

import com.canine505.util.CanineTimer;
import com.canine505.util.ErrorMessage;
import com.canine505.util.Mass;
import com.canine505.util.Movable;
import com.canine505.util.PhysicsVector;
import com.canine505.util.Velocity;
import com.canine505.util.libs.StdLib;
import com.canine505.util.libs.UnitLib;
import com.canine505.util.visualComponents.BlackHoleComponent;
import com.canine505.util.visualComponents.MatterComponent;

import javax.swing.JFrame;
//import javax.swing.JPanel;
import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;


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
        parseStartingArguments(args);
        //TODO set to false before any presentation
        ErrorMessage.setPrintErrorStatements(false);
        //TODO set to false before any presentation
        ErrorMessage.setPrintTestingStatements(false);
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
        Version 1.22 Indev - 4/25/15, 4/25/15, 4/27/15, 4/28/15, 5/13/15, 5/14/15, 5/15/15, 5/16/15, 5/27/15, 5/28/15
        Version 1.3 Indev - 5/30/15
         */
        System.out.print("Version: " + VERSION);
        System.out.println(", Last updated: " + LAST_UPDATED);
        //testing mass class and black hole component calculations
        //galaxyComponent.setLayout(new FlowLayout());
        if(!textBased)
        {
 	        window.setLayout(new FlowLayout());
	        //window.getContentPane().add(galaxyComponent);
	        components.add(new BlackHoleComponent(50, 50, new Mass(10000000000000000000000000000000.0),new Velocity(0,-10)));
	        components.add(new BlackHoleComponent(50, 100, new Mass(10000000000000000000000000000000.0),new Velocity(0,10)));
	       	//create test window of size 2500 pixels, add a black hole component and set to visible
	        //window.setLayout(new FlowLayout());
	        for(int i = 0; i < components.size(); i++)
	        {
	        	//content.add(components.get(i));
	        	//window.getContentPane().add(components.get(i));
	        	//System.out.println(window.getContentPane().getComponent(i));
	        }
	        window.setSize(500,500);
	        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        window.setVisible(true);
	        //main loop
	        if(!isPaused)
	        {
		        while(true)
		        {
		        	//System.out.println(window.getComponent(0));
		            //window.validate();
		        	window.repaint();
		        	//Testing stuff goes here
//		        	ErrorMessage.printTst(String.valueOf(Double.MAX_VALUE),false);
//		        	double[] x = new double[] {0,90}; 
//		        	double[] y = new double[] {0,90};
		        }
	        }
        }
        else
        {
        	while(true)
        	{
        		time.start();
    			if(time.getTime() < 3000 && scan.hasNext())
    			{
    				StdLib.parseCommand(scan.nextLine());
    				time.reset();
    			}

        		if(!isPaused)
        		{
	        		for(int i = 0; i< components.size(); i++)
	        		{
	        			System.out.println("I am updating everything");
	        			components.get(i).updateAll();
	        		}
        		}
        	}
        }
    }
    
    private static void parseStartingArguments(String[] arguments)
    {
    	try
    	{
    		switch(arguments[0])
    		{
    		case "GUI":
    			//fall through to allow case mistakes
    		case "gui":
    			textBased = false;
    			break;
    		case "NOGUI":
    			//fall through to allow case mistakes
    		case "nogui":
    			textBased = true;
    			break;
    		case "HELP":
    			//fall through to allow case mistakes
    		case "?":
    			//fall through to allow case mistakes
    		case "help":
    			System.out.println("Help menu for Black Hole Simulator:");
    			System.out.println("\"help\" or \"?\":  Shows this menu");
    			System.out.println("\"GUI\":          Runs the application with the gui");
    			System.out.println("\"NOGUI\":        Runs the application using the console in a text based capacity.");
    			System.exit(0);
    			break;
    		default:
    			System.out.println("That command is not recognized.  Try \"help\" or \"?\"");
    			System.exit(0);
    			break;
    		}
    	}
    	catch(ArrayIndexOutOfBoundsException e)
    	{
    		System.out.println("Application failed to run correctly.  You need to give one argument "
    				+ "so the program knows what it's doing");
    		System.out.println("Use \"help\" or \"?\" to see a list of available arguments");
    		System.exit(0);
    	}
    }
    //Hey tomorrow me, try using this link: http://stackoverflow.com/questions/20458671/how-to-add-multiple-jcomponents-to-a-jpanel
    //to fix your graphics problem.  If it doesn't work, guess what!  You can't reach back in time to punck yourself/me in the past!
    private static final String VERSION = "1.3 Indev";
    private static final String LAST_UPDATED = "5/30/15";
    //private static final JPanel galaxyComponent = new JPanel();
    public static final JFrame window = new JFrame();
    public static final Canvas content = new Canvas();
    public static final ArrayList<MatterComponent> components = new ArrayList<MatterComponent>(5);
    public static final Scanner scan = new Scanner(System.in);
    public static boolean textBased;
    public static boolean componentIsSelected;
    public static boolean isPaused = false;
    private static CanineTimer time = new CanineTimer();
}
