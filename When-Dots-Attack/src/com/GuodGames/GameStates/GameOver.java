package com.GuodGames.GameStates;

import com.GuodGames.Constants.GameStateConstants;
import com.GuodGames.WDA.DotsMain;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * 
 * @author Douglas Rudolph
 */
public class GameOver extends GameState
{
	/**
	 * initializes all game over objects
	 */
	@Override
	public void initialize() 
	{
		
	}

	/**
	 * draws all game over objects to the screen
	 */
	@Override
	public void draw(SpriteBatch spriteBatch) 
	{
		spriteBatch.draw(DotsMain.asset.libgdx, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}

	/**
	 * updates all game over objects on screen
	 */
	@Override
	public void update(float deltaTime) 
	{
		if(Gdx.input.isTouched())
		{
			DotsMain.stateManager.enterGameState(GameStateConstants.MAIN_MENU);
			DotsMain.asset.loadMenu();
		}
	}

	/**
	 * dispose all game over objects
	 */
	@Override
	public void dispose() 
	{
		
	}

}
