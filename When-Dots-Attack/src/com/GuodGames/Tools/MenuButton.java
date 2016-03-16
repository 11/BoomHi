package com.GuodGames.Tools;

import com.GuodGames.Assets.Assets;
import com.GuodGames.Constants.GameStateConstants;
import com.GuodGames.WDA.DotsMain;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * 
 * @author Douglas
 */
public class MenuButton extends Button
{
	//stores the next game state index that will be accessed when the button is clicked
	private int nextGameStateIndex;
	
	/**
	 * menu Constructor for editing x Value
	 * @param filePath
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param nextGameStateIndex
	 */
	public MenuButton(Texture texture,float x, float y, float width,float height, int nextGameStateIndex) 
	{
		super(texture,x, y, width, height);
		this.nextGameStateIndex=nextGameStateIndex;
		this.animation=null;
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param nextGameState
	 */
	public MenuButton(float x, float y, float width, float height, int nextGameState)
	{
		super(x,y,width,height);
		this.nextGameStateIndex=nextGameState;
		
		
	}
	
	@Override
	public void initialize()
	{
		/*this.animation=new Animation(1/8f,
				new TextureRegion(Assets.playButtonOne),
				new TextureRegion(Assets.playButtonTwo),
				new TextureRegion(Assets.playButtonThree),
				new TextureRegion(Assets.playButtonFour),
				new TextureRegion(Assets.playButtonFive),
				new TextureRegion(Assets.playButtonSix),
				new TextureRegion(Assets.playButtonSev),
				new TextureRegion(Assets.playButtonEight),
				new TextureRegion(Assets.playButtonNine),
				new TextureRegion(Assets.playButtonTen),
				new TextureRegion(Assets.playButtonElev));
		
		*/
		
		
		
	}
	
	@Override
	public void draw(SpriteBatch spriteBatch)
	{
		spriteBatch.draw(tex,x,y,width,height);
	}
	
	/**
	 * updates menu buttons
	 */
	public void update()
	{
		if(this.isClicked(this))
		{
		    DotsMain.stateManager.enterGameState(this.nextGameStateIndex);
		}
	}
	
	public void updateAnimation()
	{
		if(this.isClicked(this))
		{
			if(this.nextGameStateIndex==GameStateConstants.TIME_ATTACK)
			{
				DotsMain.asset.loadGame();
			}
			DotsMain.stateManager.enterGameState(this.nextGameStateIndex);
		}
	}
	
	/**
	 * disposes of menu button objects
	 */
	@Override 
	public void dispose()
	{
		tex.dispose();
	}
}
