package com.canine505.util;
//TODO overhaul unit system to handle really large numbers BEFORE they hit complications
import java.lang.Deprecated;

/**
 * Created by Alex Kneipp on 1/30/2015.
 * Superclass of all vectors, which have a magnitude and direction
 */
public class PhysicsVector
{
  /**
   * Creates a PhysicsVector with a heading in degrees and a magnitude
   * @param directionDegrees the heading of the PhysicsVector in degrees
   * @param mag the magnitude of the PhysicsVector
   */
  public PhysicsVector(double directionDegrees, double mag)
  {
    direction = directionDegrees;
    magnitude = mag;
  }

  /**
   * Creates a PhysicsVector in direction 0 degrees
   * @param mag the magnitude of the PhysicsVector
   */
  public PhysicsVector(double mag)
  {
    magnitude = mag;
    direction = 0.0;
  }

  /**
   * Creates a PhysicsVector without a specifed direction or magnitude
   */
  public PhysicsVector()
  {
    magnitude = 0.0;
    direction = 0.0;
  }
  
  public PhysicsVector(double[] vectorMatrix)
  {
	  this.magnitude = Math.sqrt(Math.pow(vectorMatrix[0],2) + Math.pow(vectorMatrix[1], 2));
	  if(vectorMatrix[0] < 0.0)
	  {
		  if(vectorMatrix[1] <0.0)
		  {
			  this.direction = Math.toDegrees(Math.atan(vectorMatrix[1]/ vectorMatrix[0])) +180.0;
		  }
		  //if vectorMatrix[1] is positive
		  else
		  {
			  this.direction = Math.toDegrees(Math.atan(vectorMatrix[1]/vectorMatrix[0]));
		  }
	  }
	  //if vectorMatrix[0] is positive
	  else
	  {
		  if(vectorMatrix[1] < 0.0)
		  {
			  this.direction = Math.toDegrees(Math.atan(vectorMatrix[1]/vectorMatrix[0])) + 180.0;
		  }
		  //if vectorMatrix[1] is positive
		  else
		  {
			  this.direction = Math.toDegrees(Math.atan(vectorMatrix[1]/vectorMatrix[0]));
		  }
	  }
  }

  /**
   *Method to gather the direction of the vector in degrees
   * @return the direction of the PhysicsVector in degrees.
   */
  public double getDirectionDegrees()
  {
  return direction;
  }

  /**
   *Method to gather the direction of the vector in Radians
   * @return the direction of the PhysicsVector in radians.
   */
  public double getDirectionRadians()
  {
    return Math.toRadians(direction);
  }

  /**
   * Method to get the magnitude of the vector (no units)
   * @return the magnitde of the vector
   */
  public double getMagnitude()
  {
    return magnitude;
  }

  /**
   * Returns the whole vector in an array with [0] as the direction and [1] as the magnitude
   * @return the entire vector with direction represented by degrees.
   */
  public double[] getVectorDegrees()
  {
    return new double[] {direction, magnitude};
  }

  /**
   * Returns the whole vector in an array with [0] as the direction and [1] as the magnitude
   * @return the entire vector with direction represented by radians.
   */
  public double[] getVectorRadians()
  {
    return new double[] {Math.toDegrees(direction), magnitude};
  }

  /**
   * Returns the whole vector in an array as component vectors at 0 degrees and 90 degrees (0 radians and Pi/2 radians).
   * Each Array index is the magnitude of the component vector
   * @return an array holding the magnitudes of component vectors at 0 and 90 degrees
   */
  public double[] getVectorMatrixNotation()
  {
    return new double[]{magnitude*Math.cos(Math.toRadians(direction)), magnitude*Math.sin(Math.toRadians(direction))};
  }

  /**
   * Sets the direction of the PhysicsVector
   * @param directionDegrees The new direction of the PhysicsVector in degrees.
   */
  public void setDirectionDegrees(double directionDegrees)
  {
    direction = directionDegrees;
  }
  /**
   * Sets the direction of the PhysicsVector
   * @param directionRadians The new direction of the PhysicsVector in radians.
   */
  public void setDirectionRadians(double directionRadians)
  {
    direction =  Math.toDegrees(directionRadians);
  }

  /**
   * Sets the magnitude of the vector.
   * @param mag The new magnitude of the PhysicsVector.
   */
  public void setMagnitude(double mag)
  {
    magnitude = mag;
  }

  /**
   * Sets the direction and magnitude of the vector.
   * @param Vector An array with 2 elements, [0] is direction in degrees and [1] is magnitude.
   */
  public void setVectorDegrees(double[] Vector)
  {
    direction = Vector[0];
    magnitude = Vector[1];
  }

  /**
   * Sets a vector using two double arguments instead of a single array argument
   * @param direction direction of the PhysicsVector, in degrees
   * @param magnitude magnitude of the vector
   */
  public void setVectorDegrees(double direction, double magnitude)
  {
    this.direction = direction;
    this.magnitude = magnitude;
  }
  /**
   * Sets the direction and magnitude of the vector.
   * @param Vector An array with 2 elements, [0] is direction in radians and [1] is magnitude.
   */
  public void setVectorRadians(double[] Vector)
  {
    direction = Math.toDegrees(Vector[0]);
    magnitude = Vector[1];
  }

  /**
   * Sets the direction and magnitude of the vector
   * @param directionRadians new direction of the vector in radians
   * @param magnitude new magnitude of the vector
   */
  public void setVectorRadians(double directionRadians, double magnitude)
  {
    direction = Math.toDegrees(direction);
    this.magnitude = magnitude;
  }
  //TODO check math in "setVectorMatrixNotation,"  maybe undeprecate
  /**
   * Sets a PhysicsVector based on two component vectors at 0 and 90 degrees.
   * @param vectorMatrix A double array with 2 elements, [0] is the x (0 degree) vector and [1] is the y (90 degree vector)
   */
  //TODO correct direction ifs so h its for the range Pi/2 to -Pi/2 not 0 to Pi
  public void setVectorMatrixNotation(double[] vectorMatrix)
  {
	  this.magnitude = Math.sqrt(Math.pow(vectorMatrix[0],2) + Math.pow(vectorMatrix[1], 2));
	  if(vectorMatrix[0] < 0.0)
	  {
		  if(vectorMatrix[1] <0.0)
		  {
			  this.direction = Math.toDegrees(Math.atan(vectorMatrix[1]/ vectorMatrix[0])) +180.0;
		  }
		  //if vectorMatrix[1] is positive
		  else
		  {
			  this.direction = Math.toDegrees(Math.atan(vectorMatrix[1]/vectorMatrix[0]));
		  }
	  }
	  //if vectorMatrix[0] is positive
	  else
	  {
		  if(vectorMatrix[1] < 0.0)
		  {
			  this.direction = Math.toDegrees(Math.atan(vectorMatrix[1]/vectorMatrix[0])) + 180.0;
		  }
		  //if vectorMatrix[1] is positive
		  else
		  {
			  this.direction = Math.toDegrees(Math.atan(vectorMatrix[1]/vectorMatrix[0]));
		  }
	  }
  }
  //TODO finish method using correct math.

  /**
   * The direction of the PhysicsVector, stored as degrees
   */
  protected double direction;
  /**
   * The magnitude of the vector.
   */
  protected double magnitude;
}
