package com.canine505.util;

public class CanineTimer 
{
	public void start()
	{
		this.startTime = System.currentTimeMillis();
		this.isRunning = true;
	}
	public void stop()
	{
		this.endTime = System.currentTimeMillis();
		this.isRunning = false;
	}
	public void reset()
	{
		this.startTime = 0;
		this.endTime = 0;
	}
	public double getTime()
	{
		if(isRunning)
			return this.startTime - System.currentTimeMillis();
		else
			return this.startTime - this.endTime;
	}
	private boolean isRunning;
	private double startTime;
	private double endTime;
}
