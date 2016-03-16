package com.GuodGames.Entities;

import com.GuodGames.Assets.Assets;
import com.GuodGames.GameStates.TimeAttack;
import com.GuodGames.WDA.DotsMain;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * child class of Dot
 * - NOT IMPLEMENTED - goldenDots Will Disappear after .5 seconds
 * - IMPLEMENTED - add bonus points to the players score
 * - NOT IMPLEMENTED - Bonus point value will increase by a multiplier 
 * 					   for every instance of GoldenDot that is clicked
 * 
 * @author Douglas
 *
 */
public class GoldenDot extends Dot
{	
	/**
	 * default constructor
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public GoldenDot(float x, float y, float width, float height)
	{
		super(x, y, width, height);
	}

	/**
	 * initializes the texture for golden dot
	 */
	@Override
	public void initialize() 
	{
		this.animation=new Animation(1/8f,
				new TextureRegion(DotsMain.asset.goldDotOne),
				new TextureRegion(DotsMain.asset.goldDotTwo),
				new TextureRegion(DotsMain.asset.goldDotThree),
				new TextureRegion(DotsMain.asset.goldDotFour),
				new TextureRegion(DotsMain.asset.goldDotFive),
				new TextureRegion(DotsMain.asset.goldDotSix));
	}
	
	/**
	 * draws animation of a golden dot to the screen
	 */
	@Override 
	public void draw(SpriteBatch spriteBatch)
	{
		spriteBatch.draw(this.animation.getKeyFrame(stateTime),x,y,width,height);
	}
	
	/**
	 * updates golden dots
	 * adds 10 to score
	 */
	@Override
	public void update()
	{
		if(this.isClicked(this))
		{
			TimeAttack.score+=10;
			
			this.isShowing=false;
			this.dispose();
		}
		
		this.stateTime+=Gdx.graphics.getDeltaTime();
	}
	
	@Override
	public void dispose()
	{
		
	}
	
}
