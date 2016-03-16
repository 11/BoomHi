package com.GuodGames.Entities;

import com.GuodGames.Assets.Assets;
import com.GuodGames.GameStates.TimeAttack;
import com.GuodGames.WDA.DotsMain;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * 
 * @author Douglas Rudolph
 */
public class EvilDot extends Dot
{
	/**
	 * default constructor
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public EvilDot(float x, float y, float width, float height) 
	{
		super(x, y, width, height);
		
	}
	
	/**
	 * initializes all evil dot objects
	 */
	@Override 
	public void initialize()
	{
		this.animation=new Animation(1/8f,
				new TextureRegion(DotsMain.asset.pinkDotOne),
				new TextureRegion(DotsMain.asset.pinkDotTwo),
				new TextureRegion(DotsMain.asset.pinkDotThree),
				new TextureRegion(DotsMain.asset.pinkDotFour),
				new TextureRegion(DotsMain.asset.pinkDotFive),
				new TextureRegion(DotsMain.asset.pinkDotSix));
	}
	
	@Override 
	public void draw(SpriteBatch spriteBatch)
	{
		if(this.isShowing)
		{
			spriteBatch.draw(this.animation.getKeyFrame(stateTime), x, y, width, height);
		}	
	}
	
	/**
	 * updates evil dot
	 */
	@Override
	public void update()
	{
		if(this.isClicked(this))
		{
			TimeAttack.score-=2;
			TimeAttack.gameTime-=2;
			this.setIsShowing(false);
			this.dispose();
		}
		
		this.stateTime+=Gdx.graphics.getDeltaTime();
		
		//if(this.fadeOut(this))
		//{
		//	this.setIsShowing(false);
		//}
	}	
	
	@Override 
	public void dispose(){}
}
