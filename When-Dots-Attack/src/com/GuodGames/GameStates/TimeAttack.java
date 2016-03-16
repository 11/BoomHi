package com.GuodGames.GameStates;

import com.GuodGames.Assets.Assets;
import com.GuodGames.Constants.EntityConstants;
import com.GuodGames.Tools.BackgroundTimer;
import com.GuodGames.Tools.LevelBar;
import com.GuodGames.Tools.RandomGrid;
import com.GuodGames.WDA.DotsMain;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * 
 * @author Douglas Rudolph
 */
public class TimeAttack extends GameState{
	
	//font that draws score to the screen
	private BitmapFont scoreFont;

	private BackgroundTimer backgroundTimer;
	
	//RandomGrid object used to spawn all entities in TimeAttack
	private RandomGrid randomGrid;
	
	//Visual Bar that lets the user the know the difficulty of spawning
	private LevelBar levelBar;
	
	/**
	 * initializes all objects on screen
	 */
	@Override
	public void initialize()
	{
		
		GameState.score=0;
		GameState.gameTime=20;
		this.timeAttack=true;
		
		this.randomGrid=new RandomGrid();
		
		this.levelBar=new LevelBar(0,0,Gdx.graphics.getWidth()-200,25);
		this.levelBar.setShrinkVelocity(50f);
		
		this.backgroundTimer=new BackgroundTimer(0,0);
		
		this.scoreFont=DotsMain.asset.gameFont;
	}
	
	/**
	 * draws all objects to the screen in time attack
	 */
	@Override
	public void draw(SpriteBatch spriteBatch)
	{
		backgroundTimer.draw(spriteBatch);
		scoreFont.draw(spriteBatch, "Score: "+score, 10, Gdx.graphics.getHeight()-EntityConstants.DOT_DELTA_DISTANCE);
		levelBar.draw(spriteBatch);
		randomGrid.draw(spriteBatch);
	}
	
	/**
	 * updates all objects in time attack
	 */
	@Override 
	public void update(float deltaTime)  
	{
		if(!this.isPaused)
		{
			this.randomGrid.update();
			this.levelBar.update(deltaTime);	
		}
		backgroundTimer.update(deltaTime);
	}
	
	/**
	 * disposes of all objects in time attack
	 * - ERROR - the grid is not disposed of properly when the game state isnt switched
	 */
	@Override
	public void dispose()
	{
		
	}
}
