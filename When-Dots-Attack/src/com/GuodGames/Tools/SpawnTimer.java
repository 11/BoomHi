package com.GuodGames.Tools;

/**
 * 
 * @author Douglas
 */
public class SpawnTimer 
{
	//current time of the spawner
	private float time;
	
	/**
	 * default constructor
	 */
	public SpawnTimer() 
	{
		this.time=0;
	}
	
	/**
	 * constructor that allows you to set the time 
	 * @param time
	 */
	public SpawnTimer(int time)
	{
		this.time=time;
	}
	
	/**
	 * updates instances of timer 
	 */
	public void updateTimer()
	{
		this.time=(int)System.currentTimeMillis();
	}
	
	/**
	 * resets timer back to 0 
	 */
	public void reset()
	{
		this.time=0;
		this.updateTimer();
	}
	
	/**
	 * allows you to set the time on timer
	 * @param time
	 */
	public void setTime(int time)
	{
		this.time=time;
	}
	
	/**
	 * allows you to get time
	 * @return
	 */
	public int getTime()
	{
		return (int)this.time;
	}
}
