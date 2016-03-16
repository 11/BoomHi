package com.GuodGames.Entities;

import com.GuodGames.Assets.Assets;
import com.GuodGames.Tools.LevelBar;
import com.GuodGames.WDA.DotsMain;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Child of Dot 
 * GoodDot should be clicked by the player
 * Will add points to the players score
 * - ERROR - cant dispose animation
 * 
 * @author Douglas Rudolph
 *
 */
public class GoodDot extends Dot
{
	/**
	 * Good Dot Constructor
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public GoodDot(float x, float y, float width, float height) 
	{
		super(x, y, width, height);
	}
	
	/**
	 * initializes the texture object if set to be visible
	 */
	@Override
	public void initialize()
	{
		
		this.stateTime=0;
		this.animation=new Animation(1/8f,
				new TextureRegion(DotsMain.asset.blueDotOne),
				new TextureRegion(DotsMain.asset.blueDotTwo),
				new TextureRegion(DotsMain.asset.blueDotThree),
				new TextureRegion(DotsMain.asset.blueDotFour),
				new TextureRegion(DotsMain.asset.blueDotFive),
				new TextureRegion(DotsMain.asset.blueDotSix));
		
	}
	
	@Override
	public void draw(SpriteBatch spriteBatch)
	{
		if(isShowing)
		{
			spriteBatch.draw(animation.getKeyFrame(stateTime),x,y,width,height);
		}
	}
	
	/**
	 * checks to see if a dot has been clicked
	 * checks to see if the dot has currently been up for a set amount of time
	 */
	@Override
	public void update()
	{
		if(this.isClicked(this))
		{
			LevelBar.width+=25;
			this.setIsShowing(false);
			this.dispose();
		}
		
		stateTime+=Gdx.graphics.getDeltaTime();
		
	}
	
	@Override
	public void dispose()
	{
		
	}
	
}
