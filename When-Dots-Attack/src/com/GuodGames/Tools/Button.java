package com.GuodGames.Tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * 
 * @author Douglas Rudolph
 */
public abstract class Button 
{
	//button x coordinate
	protected float x;
	
	//button y coordinate
	protected float y;
	
	//button width
	protected float width;
	
	//button height
	protected float height;

	//button texture
	protected Texture tex;
	
	protected Animation animation;
	
	/**
	 * default constructor
	 * @param filePath
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public Button(Texture texture, float x, float y, float width, float height)
	{
		this.x=x;
		this.y=y;
		this.height=height;
		this.width=width;
		this.tex=texture;
	}
	
	public Button(float x, float y, float width, float height)
	{
		this.x=x;
		this.y=y;
		this.height=height;
		this.width=width;
	}
	public abstract void initialize();
	
	/**
	 * draws buttons to screen
	 * @param spriteBatch
	 */
	public void draw(SpriteBatch spriteBatch)
	{
		if(this.animation==null)
		{	
			spriteBatch.draw(tex,x,y,width,height);
		}
	}
	
	/**
	 * abstract method that updates buttons
	 */
	protected abstract void update();
	
	/**
	 * disposes of button object
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
	public boolean isClicked(Button button)
	{
		float touchY=Math.abs(Gdx.graphics.getHeight()-Gdx.input.getY());
		float touchX=Gdx.input.getX();
		
		
		//if the mouse is hovering over the dot return true
			if(touchX>=button.x 
				&& touchY<=height+button.y
				&& touchX<=button.x+button.width
				&& touchY>=button.y
				&& Gdx.input.isTouched())
				{
					return true;
				}
			
		//else return false
		return false;
	}
}
