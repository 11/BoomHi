package com.GuodGames.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * parent class for all instances of Dot
 * @author Douglas Rudolph
 */
public abstract class Dot
{
	//the amount of rows in the sprite sheet
	protected static final int FRAME_ROW=6;
	
	//size of each frame
	protected static final int FRAME_SIZE=256;
	
	//boolean that returns the visibility state of an instance of Dot
	protected boolean isShowing;
	
	//the x coordinate an instance of Dot is drawn to
	protected int xCoordinate;
	
	//the y coordinate an instance of Dot is drawn to
	protected int yCoordinate;
	
	//texture of Dot
	protected Texture tex;
	
	//all four dimensions of an instance of Dot
	protected float x, y, width,height;
	
	//time that updates the animations speed
	protected float stateTime;
	
	//array of spawning animation frames 
	protected TextureRegion[] frames;
	
	//spawning animation
	protected Animation animation;
	
	//current frame of animation
	protected TextureRegion currentFrame;
	
	
	/**
	 * Constructor for every instance of Dot
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public Dot(float x, float y, float width, float height)
	{
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		isShowing=true; 
		initialize();
	}
	
	/**
	 * initializes all objects for an instance of Dot
	 */
	public abstract void initialize();
	
	/**
	 * draws the texture for an instance of Dot
	 * @param spriteBatch
	 */
	public void draw(SpriteBatch spriteBatch)
	{
		if(isShowing)
			spriteBatch.draw(tex, x, y, width, height);
	}
	
	/**
	 * updates a given instance of Dot
	 */
	public void update()
	{
		if(this.isClicked(this))
		{
			this.isShowing=false;	
		}
	}
	
	/**
	 * disposes of all disposable objects from memory
	 */
	public void dispose()
	{
		tex.dispose();
	}
	
	/**
	 * checks to see if an instance of Dot is clicked
	 * @param dot
	 * @return
	 */
	public boolean isClicked(Dot dot)
	{
		float touchY=Math.abs(Gdx.graphics.getHeight()-Gdx.input.getY());
		float touchX=Gdx.input.getX();
		
		
		//if the mouse is hovering over the dot return true
			if(touchX>=dot.x 
				&& touchY<=height+dot.y
				&& touchX<=dot.x+dot.width
				&& touchY>=dot.y
				&& Gdx.input.isTouched()
				&& isShowing==true)
				{
					return true;
				}
			
		//else return false
		return false;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setIsShowing(boolean value)
	{
		this.isShowing=value;
	}
	
	/**
	 * returns isShowing for an instance of Dot
	 * @return
	 */
	public boolean getIsShowing()
	{
		return isShowing;
	}
	
	/**
	 * allows you to set both coordinates for an instance of Dot
	 * @param x
	 * @param y
	 */
	public void setDotCoordinates(int x, int y)
	{
		this.xCoordinate=x;
		this.yCoordinate=y;
	}
	
	/**
	 * returns the y coordinate of an instance of Dot
	 * @return
	 */
	public int getXDotCoordinate()
	{
		return this.xCoordinate;
	}
	
	/**
	 * sets the x coordinate of an instance of Dot
	 * @param x
	 */
	public void setXDotCooridinate(int x)
	{
		this.xCoordinate=x;
	}
	
	/**
	 * returns the y coordinate of an instance of Dot
	 * @return
	 */
	public int getYDotCoordinate()
	{
		return this.yCoordinate;
	}
	
	/**
	 * sets the y coordinate for an instance of Dot
	 * @param y
	 */
	public void setYDotCoordinate(int y)
	{
		this.yCoordinate=y;
	}
}
