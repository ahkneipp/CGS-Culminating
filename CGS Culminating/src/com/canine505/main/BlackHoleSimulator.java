package com.canine505.main;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
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
        //TODO set to false before any presentation
        ErrorMessage.setPrintErrorStatements(true);
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
        Version 1.22 Indev - 4/25/15
         */
        System.out.print("Version: " + VERSION);
        System.out.println(", Last updated: " + LAST_UPDATED);
        //testing mass class and black hole component calculations
        //galaxyComponent.setLayout(new FlowLayout());
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
        	System.out.println(window.getContentPane().getComponent(i));
        }
        window.setSize(500,500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        //main loop
        while(true)
        {
        	//System.out.println(window.getComponent(0));
            //window.validate();
        	window.repaint();
        	//Testing stuff goes here
        	ErrorMessage.printTst(String.valueOf(Double.MAX_VALUE),false);
        	double[] x = new double[] {0,90}; 
        	double[] y = new double[] {0,90};
        }
    }
    
    //Hey tomorrow me, try using this link: http://stackoverflow.com/questions/20458671/how-to-add-multiple-jcomponents-to-a-jpanel
    //to fix your graphics problem.  If it doesn't work, guess what!  You can't reach back in time to punck yourself/me in the past!
    private static final String VERSION = "1.22 Indev";
    private static final String LAST_UPDATED = "4/28/15";
    //private static final JPanel galaxyComponent = new JPanel();
    public static final JFrame window = new JFrame();
    public static final Canvas content = new Canvas();
    public static final ArrayList<MatterComponent> components = new ArrayList<MatterComponent>(5);
}
