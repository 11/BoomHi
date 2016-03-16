package com.GuodGames.Tools;
import com.GuodGames.Assets.Assets;
import com.GuodGames.WDA.DotsMain;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * 
 * @author Douglas
 */
public class BackgroundTimer 
{
	/*
	 * vibrant and bright background
	 * meant for when the player is playing consistently 
	 */
	private Texture consistentBackground;
	
	/*
	 * gloomy styled background
	 * meant for when the player is playing inconsistently
	 */
	private Texture gloomyBackground;
	
	//current background being drawing to the screen 
	private Texture currentBackground;
	
	//copy of current background being drawn
	private Texture currentBackgroundCopy;
	
	//scrolling velocity of wrapped backgrounds
	private float scrollVelocity;
	
	//x coordinate
	private float x;
	
	//y coordinate 
	private float y;
	
	//y coordinate for the copy of the current background being drawn
	private float yCopy;
	
	/**
	 * default constructor
	 */
	public BackgroundTimer()
	{
		scrollVelocity=1;
		x=0;
		y=0;
		this.initialize();
	}
	
	/**
	 * constructor that allows for vector coordinates to be chosen
	 * @param x
	 * @param y
	 */
	public BackgroundTimer(float x, float y)
	{
		this.x=x;
		this.y=y;
		scrollVelocity=400;
		this.initialize();
	}
	
	/**
	 * constructor that allows for the scrolling velocity and Vector coordinates to be chosen
	 * @param x
	 * @param y
	 * @param scrollVelocity
	 */
	public BackgroundTimer(float x, float y, float scrollVelocity)
	{
		this.x=x;
		this.y=y;
		this.scrollVelocity=scrollVelocity;
		this.initialize();
	}
	
	/**
	 * initializes all backgrounds on screen
	 */
	public void initialize()
	{
		consistentBackground=DotsMain.asset.lightBackground;
		gloomyBackground=DotsMain.asset.darkBackground;
		currentBackground=consistentBackground;
		currentBackgroundCopy=currentBackground;
		yCopy=currentBackground.getHeight();
		
	}
	
	/**
	 * draws the wrapped backgrounds on screen
	 * @param spriteBatch
	 */
	public void draw(SpriteBatch spriteBatch)
	{
		spriteBatch.draw(currentBackground,x,y,Gdx.graphics.getWidth(), currentBackground.getHeight());
		spriteBatch.draw(currentBackgroundCopy,x,yCopy,Gdx.graphics.getWidth(),currentBackgroundCopy.getHeight());
	}
	
	/**
	 * updates all wrapped backgrounds on screen
	 */
	public void update(float deltaTime)
	{
		y-=scrollVelocity*deltaTime;	
		yCopy-=scrollVelocity*deltaTime;
		
		if(Math.abs(y)>=currentBackground.getHeight())
		{
			y=yCopy+currentBackgroundCopy.getHeight();
			
		}
		
		else if(Math.abs(yCopy)>=currentBackground.getHeight())
		{
			yCopy=y+currentBackground.getHeight();
		}
		
	}
	
	/**
	 * disposes of all backgrounds from memory
	 */
	public void dispose()
	{
		consistentBackground.dispose();
		gloomyBackground.dispose();
		currentBackground.dispose();
	}
	
	/**
	 * sets the background that will be wrapped on screen
	 * @param isConsistent
	 */
	public void setCurrentBackground(boolean isConsistent)
	{
		
		if(isConsistent)
		{
			currentBackground=this.consistentBackground;
			currentBackgroundCopy=currentBackground;
		}
		
		else
		{
			currentBackground=this.gloomyBackground;
			currentBackgroundCopy=currentBackground;
		}	
	}
}
