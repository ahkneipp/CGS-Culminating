package com.canine505.util.libs;

import java.util.Scanner;

import com.canine505.main.BlackHoleSimulator;
import com.canine505.util.PhysicsVector;
import com.canine505.util.Velocity;
import com.canine505.util.visualComponents.BlackHoleComponent;
import com.canine505.util.visualComponents.MatterComponent;
import com.canine505.util.visualComponents.PlanetComponent;
import com.canine505.util.visualComponents.StarComponent;

/**
 * Created by Alex Kneipp on 2/26/2015.
 */
public class StdLib
{
    /**
     * Checks if a and b are near to each other within 10 decimal places
     * @Deprecated on 3/15/15 because I realized there was a built in version (Double.compare)
     * @param a The first number to be compared
     * @param b The second number to be compared
     * @return true if they are equal within 10 decimal places and false if not.
     */
    @Deprecated
    public static boolean isEqualTo(double a, double b)
    {
        //Multiply doubles by ten to the 10th and cast as long to eliminate the roundoff errors often found in doubles
        if((long)Math.pow(10,10)*a == (long)Math.pow(10,10)*b)
            return true;
        else
            return false;
    }
    
	public static int randomWithRange(int min, int max)
	{
	   int range = (max - min) + 1;     
	   return (int)(Math.random() * range) + min;
	}

    public static void parseCommand(String command)
    {
    	String message =  "I would really like to do what you want me to do, but I didn't understand you.";
    	String message1 = "The desired selection cannot be made, because the number you gave me is too big, or another component"
    			+ " is already selected.";
    	try
    	{
	    	switch(command.substring(0, 4))
	    	{
	    	case "sele": //select
	    		if(command.substring(0,6).equalsIgnoreCase("select"))
	    		{
	    			//System.out.println(command.substring(7,command.length()));
	    			if(Integer.parseInt(command.substring(7,command.length())) < BlackHoleSimulator.components.size() && 
	    					!BlackHoleSimulator.componentIsSelected)
	    			{
	    				BlackHoleSimulator.componentIsSelected = true;
	    				BlackHoleSimulator.components.get(Integer.parseInt(command.substring(7, command.length())))
	    					.setIsSelected(true);
	    				System.out.println("You have selected a "+ getComponentType(BlackHoleSimulator.components.get
	    						(getSelectedComponent()).getID()) + ".");    				
	    			}
	    			else
	    			{
	    				System.out.println(message1);
	    			}
	    		}
	    		else
	    		{
	    			System.out.println(message);
	    		}
	    		break;
	    		
	    	case "dese": //deselect
	    		
	    		if(command.substring(0,8).equalsIgnoreCase("deselect"))
	    		{
	    			if(BlackHoleSimulator.componentIsSelected)
	    			{
	    				System.out.println("You have deselected a "+ getComponentType(BlackHoleSimulator.components.get
	    						(getSelectedComponent()).getID()));
	    				BlackHoleSimulator.componentIsSelected = false;
	    				BlackHoleSimulator.components.get(getSelectedComponent())
	    					.setIsSelected(false);    				
	    			}
	    			else
	    			{
	    				System.out.println("You couldn't deselect anything because nothing was selected.");
	    			}
	    		}
	    		else
	    		{
	    			System.out.println(message);
	    		}
	    		break;
	    		
	    	case "dele": //delete
	    		if(command.substring(0,6).equalsIgnoreCase("delete") && (BlackHoleSimulator.componentIsSelected || 
	    				Integer.parseInt(command.substring(7,command.length())) < BlackHoleSimulator.components.size() ))
	    		{
	    			if(!BlackHoleSimulator.componentIsSelected)
	    				BlackHoleSimulator.components.remove(Integer.parseInt(command.substring(7,command.length())));
	    			else
	    				BlackHoleSimulator.components.remove(getSelectedComponent());
	    		}
	    		else
	    		{
	    			System.out.println(message);
	    		}
	    		break;
	    		
	    	case "add ": //add
	    		//System.out.println("Paused the simulation");
				parseCommand("pause");
	    		switch(command.substring(4,command.length()))
	    		{
	    		case "blackhole":
	    			BlackHoleSimulator.components.add(new BlackHoleComponent());
	    			System.out.println("Added a black hole with a mass of 1000 KG and a null velocity as component" + 
	    					" " + (BlackHoleSimulator.components.size() - 1) + ".");
	    			break;
	    		case "planet":
	    			BlackHoleSimulator.components.add(new PlanetComponent());
	    			System.out.println("Added a planet with a null mass, a null velocity, "
	    					+ "and color " +BlackHoleSimulator.components.get(BlackHoleSimulator.components.size() - 1).getColor() +
	    					"as component" +" " + (BlackHoleSimulator.components.size() - 1) + ".");
	    			break;
	    		case "star":
	    			BlackHoleSimulator.components.add(new StarComponent());
	    			System.out.println("Added a star with a null mass, a null velocity, "
	    					+ "and color " +BlackHoleSimulator.components.get(BlackHoleSimulator.components.size() - 1).getColor() +
	    					"as component" +" " + (BlackHoleSimulator.components.size() - 1) + ".");
	    			break;
	    		default:
	    			System.out.println(message);
	    			break;
	    		}
	    		break;
	    		
	    	case "lumi": //luminosity (only applicable to black holes)
	    		if(command.substring(0,10).equalsIgnoreCase("luminosity") && ( BlackHoleSimulator.componentIsSelected ||
	    				Integer.parseInt(command.substring(11,command.length())) < BlackHoleSimulator.components.size()))
	    		{
	    			if(BlackHoleSimulator.componentIsSelected && BlackHoleSimulator.components.get(getSelectedComponent())
	    					.getID().equals("BHC-MC"))
	    			{
	    				//takes the schwarzchild radius of the black hole and the apparent temperature of the black hole, plugs it 
	    				//into the Stefan-Boltzman law and prints the result
	    				System.out.println("Luminosity of Black hole Component: " + 4.0 * Math.PI * 
	    						Math.pow(((2.0 * StdLib.GRAVITATIONAL_CONSTANT * BlackHoleSimulator.components.get(
	    						getSelectedComponent()).getMass().getValue()))/ Math.pow(StdLib.SPEED_OF_LIGHT,2),2) 
	    						* (5.67 * Math.pow(10,-5) * ((6.0 * Math.pow(10,-8))* BlackHoleSimulator.components.get(
	    						getSelectedComponent()).getMass().getValue()/(1.9891 * Math.pow(10,30)))));
	    			}
	    			else if(!BlackHoleSimulator.componentIsSelected && BlackHoleSimulator.components.get(
	    					Integer.parseInt(command.substring(11,command.length()-1))).getID().equals("BHC-MC"))
	    			{
	    				System.out.println("Luminosity of Black hole Component: " + 4.0 * Math.PI * 
	    						Math.pow(((2.0 * StdLib.GRAVITATIONAL_CONSTANT * BlackHoleSimulator.components.get(
	    						Integer.parseInt(command.substring(11,command.length()-1))).getMass().getValue()))/ 
	    						Math.pow(StdLib.SPEED_OF_LIGHT,2),2)* (5.67 * Math.pow(10,-5) * ((6.0 * Math.pow(10,-8))
	    						* BlackHoleSimulator.components.get(Integer.parseInt(command.substring(11,command.length()-1)))
	    						.getMass().getValue()/(1.9891 * Math.pow(10,30)))));
	    			}
	    			else
	    			{
	    				System.out.println("This command is only applicable to black hole objects.");
	    			}
	    		}
	    		else
	    		{
	    			System.out.println(message);
	    		}
	    		break;
	    		
	    	case "appe": //apperantTemperature (only applicable to black holes)
	    		if(command.substring(0,19).equalsIgnoreCase("apperantTemperature") && (BlackHoleSimulator.componentIsSelected ||
	    				Integer.parseInt(command.substring(19,command.length())) < BlackHoleSimulator.components.size()))
	    		{
	    			if(BlackHoleSimulator.componentIsSelected && BlackHoleSimulator.components.get(getSelectedComponent())
	    					.getID().equals("BHC-MC"))
	    			{
	    				System.out.println("Apperant temperature of the Black hole Component: " + (6 * Math.pow(10,-8))/
	    						BlackHoleSimulator.components.get(getSelectedComponent()).getMass().getValue()/(1.9891 
	    						* Math.pow(10,30)) );
	    			}
	    			else if(!BlackHoleSimulator.componentIsSelected && BlackHoleSimulator.components.get(
	    					Integer.parseInt(command.substring(19,command.length()))).getID().equals("BHC-MC"))
	    			{
	    				System.out.println("Apperant temperature of the Black hole Component: " + (6 * Math.pow(10,-8))/
	    						BlackHoleSimulator.components.get(Integer.parseInt(command.substring(19,command.length())))
	    						.getMass().getValue()/(1.9891 * Math.pow(10,30)) );
	    			}
	    			else
	    			{
	    				System.out.println("This command is only applicable to black hole objects.");
	    			}
	    		}
	    		else
	    		{
	    			System.out.println(message);
	    		}
	    		break;
	    	case "posi": //position
	    		if(command.substring(0,8).equalsIgnoreCase("position") && (BlackHoleSimulator.componentIsSelected || Integer.parseInt
	    				(command.substring(9,command.length())) < BlackHoleSimulator.components.size()))
	    		{
	    			if(BlackHoleSimulator.componentIsSelected)
	    			{
	    				System.out.println("Component " + getSelectedComponent() + " is at " + 
	    						"(" + BlackHoleSimulator.components.get(getSelectedComponent()).getX() + ", " +
	    						BlackHoleSimulator.components.get(getSelectedComponent()).getY() + ")");
	    			}
	    			else if(!BlackHoleSimulator.componentIsSelected)
	    			{
	    				System.out.println("Component " + (Integer.parseInt(command.substring(9,command.length()-1))) + "is at " + 
	    						BlackHoleSimulator.components.get(Integer.parseInt(command.substring(9,command.length()-1))).getX() + ", " +
	    						BlackHoleSimulator.components.get(Integer.parseInt(command.substring(9,command.length()-1))).getY());
	    			}
	    		}
	    		else
	    		{
	    			System.out.println(message);
	    		}
	    		break;
	    	case "velo": //velocity
	    		if((command.substring(0,8).equalsIgnoreCase("velocity") && (BlackHoleSimulator.componentIsSelected||
	    				Integer.parseInt(command.substring(9,command.length())) < BlackHoleSimulator.components.size()) ))
	    		{
	    			if(BlackHoleSimulator.componentIsSelected)
	    			{
	    				System.out.println("Component " + getSelectedComponent() + " has a velocity of <" + 
	    						BlackHoleSimulator.components.get(getSelectedComponent()).getVelocity().getVectorMatrixNotation()[0]
	    						+ ", " + BlackHoleSimulator.components.get(getSelectedComponent()).getVelocity().
	    						getVectorMatrixNotation()[1] + ">");
	    			}
	    			else if(!BlackHoleSimulator.componentIsSelected)
	    			{
	    				System.out.println("Component " + (Integer.parseInt(command.substring(9,command.length()))) + 
	    						" has a velocity of <" +	BlackHoleSimulator.components.get(Integer.parseInt(command.substring
	    						(9,command.length()))).getVelocity().getVectorMatrixNotation()[0] + ", " + 
	    						BlackHoleSimulator.components.get(Integer.parseInt(command.substring(9,command.length()))).
	    						getVelocity().getVectorMatrixNotation()[1] + ">");
	    			}
	    		}
	    		else
	    		{
	    			System.out.println(message);
	    		}
	    		break;
	    	case "paus": //pause
	    		if(command.equalsIgnoreCase("pause"))
	    		{
	    			BlackHoleSimulator.isPaused = true;
	    			System.out.println("Paused the simulation");
	    		}
	    		break;
	    	case "resu": //resume
	    		if(command.equalsIgnoreCase("resume"))
	    		{
	    			BlackHoleSimulator.isPaused = false;
	    			System.out.println("Resumed the simulation");
	    		}
	    		break;
	    	case "list": //list
	    		System.out.println("Index    Component type    Position");
	    		for(int i = 0; i < BlackHoleSimulator.components.size(); i++)
	    		{
	    			System.out.print(i);
	    			System.out.print("         ");
	    			System.out.print(getComponentType(BlackHoleSimulator.components.get(i).getID()));
	    			System.out.print("         ");
	    			System.out.println("(" + BlackHoleSimulator.components.get(i).getX() + ", " + 
	    					BlackHoleSimulator.components.get(i).getY() + ")");
	    		}
	    		break;
	    	case "edit": //edit
	    		if(BlackHoleSimulator.componentIsSelected)
	    			editComponent(BlackHoleSimulator.components.get(getSelectedComponent()),new Scanner(System.in));
	    		else
	    		{
	    			System.out.println("Please select a component to edit using the select command");
	    		}
	    		break;
	    	case "exit": //exit
	    		System.exit(0);
	    		break;
	    	case "mass": //mass
	    		if(BlackHoleSimulator.componentIsSelected)
	    			System.out.println("Mass: " + BlackHoleSimulator.components.get(getSelectedComponent()).getMass().getValue() + " KG");
	    		else
	    		{
	    			System.out.println("Please select a component to find the mass of using the select command");
	    		}
	    		break;
	    	default: 
	    		System.out.println(message);
	    		break;
	    	}
    	}
    	catch(StringIndexOutOfBoundsException e)
    	{
    		System.out.println(message);
    	}
    }
    
    private static String getComponentType(String componentID)
    {
    	String returnable;
    	//System.out.println(componentID);
    	switch(componentID)
    	{
    	case "BHC-MC":
    		returnable = "black hole";
    		break;
    	case "MC-JC":
    		returnable = "generic";
    		break;
    	case "SC-MC":
    		returnable = "star";
    		break;
    	case "PC-MC":
    		returnable = "planet";
    		break;
    	default:
    		returnable = null;
    	}
    	return returnable;
    }
    
    private static int getSelectedComponent()
    {
    	for(int i = 0; i<BlackHoleSimulator.components.size();i++)
    	{
    		if(BlackHoleSimulator.components.get(i).getIsSelected())
    			return i;
    	}
    	return -1;
    }
    
    private static void editComponent(MatterComponent component, Scanner scanner)
    {
    	int temp = 0;
    	System.out.println("What would you like to edit?");
    	System.out.println("1. Mass      2. Velocity     3. Position");
    	temp = scanner.nextInt();
    	switch(temp)
    	{
    	case 1:
    		System.out.println("Please enter a new mass for the component in Kilograms.");
    		component.getMass().setValue(scanner.nextDouble());
    		//scanner.close();
    		break;
    	case 2:
    		System.out.println("Please give the horizontal component of the Vector.");
    		double temp1 = scanner.nextDouble();
    		System.out.println("Please give the vertical component of the Vector.");
    		double temp2 = scanner.nextDouble();
    		double[] temp3 = new double[] {temp1, temp2};
    		component.getVelocity().setVectorMatrixNotation(temp3);
    		//scanner.close();
    		break;
    	case 3:
    		System.out.println("Please give the x value of the new position.");
    		component.setX(scanner.nextDouble());;
    		System.out.println("Please give the y value of the new position.");
    		component.setY(scanner.nextDouble());
    		//scanner.close();
    		break;
    	}
    }
    
    public static PhysicsVector calculateGravity(MatterComponent m1, MatterComponent m2)
    {
    	if(BlackHoleSimulator.components.size() > 1)
    	{
    		//System.out.println("calculating legit gravity");
    		return new Velocity(Math.toDegrees(Math.atan((m2.getY()-m1.getY())/(m2.getX()-m1.getX()))),
    			(StdLib.GRAVITATIONAL_CONSTANT * m1.getMass().getValue() * m2.getMass().getValue())
    			/ (Math.sqrt(Math.pow(m2.getX() - m1.getX(), 2) + (Math.pow(m2.getY() - m1.getY(), 2)))*1000)/*multiply by 1000 because 
    			 * it needs to be converted to meters from the KM handed to it */);
    	}
    	else
    	{
    		//System.out.println("returning no gravity");
    		return new PhysicsVector(0,0);
    	}
    }
    
    public static PhysicsVector calculateGravity(double m1, double m2, double[] xs, double[]ys)
    {
		return new PhysicsVector(Math.toDegrees(Math.atan((ys[0]-ys[1])/(xs[0]-xs[1]))), (StdLib.GRAVITATIONAL_CONSTANT * m1 * m2)
    			/ (Math.sqrt(Math.pow(xs[1] - xs[0], 2) + (Math.pow(ys[1] + ys[0], 2)))*1000)/*multiply by 1000 because 
    			 * it needs to be converted to meters from the KM handed to it */);    	
    }
    //unit in n-m/kg^2
    public static final double GRAVITATIONAL_CONSTANT = 6.67384 * Math.pow(10,-11);
    public static final String GRAVITATIONAL_CONSTANT_UNIT = "m^3 Kg^-1 s^-2";
    public static final double SPEED_OF_LIGHT = 299792458.0;
    public static final String SPEED_OF_LIGHT_UNIT = "m/s";
}
