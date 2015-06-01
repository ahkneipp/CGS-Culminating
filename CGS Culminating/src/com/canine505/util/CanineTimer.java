package com.canine505.util;

public class CanineTimer 
{
	public void start()
	{
		if(!isRunning)
		{
			this.startTime = System.currentTimeMillis();
			this.isRunning = true;
		}
	}
	public void stop()
	{
		if(isRunning)
		{
			this.endTime = System.currentTimeMillis();
			this.isRunning = false;
		}
	}
	public void reset()
	{
		this.startTime = 0;
		this.endTime = 0;
	}
	public double getTime()
	{
		if(isRunning)
			return System.currentTimeMillis() - this.startTime ;
		else
			return this.endTime-this.startTime;
	}
	private boolean isRunning;
	private double startTime;
	private double endTime;
}
