package com.GuodGames.GameStates;

import com.GuodGames.Constants.GameStateConstants;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameStateManager 
{
	//current game state that is being drawn and updated to the screen
	private GameState currentGameState;
	
	/**
	 * default constructor
	 */
	public GameStateManager()
	{
		enterGameState(GameStateConstants.SPLASH_SCREEN);
	}
	
	/**
	 * allows you to enter a new game state
	 * @param index
	 */
	public void enterGameState(int state)
	{
		
		if(currentGameState!=null)
		{
			this.disposeGameState();
		}
		
		if(state==GameStateConstants.SPLASH_SCREEN)
		{
			currentGameState=new SplashScreen();
		}
		
		if(state==GameStateConstants.MAIN_MENU)
		{
			currentGameState=new MainMenu();
		}
		
		if(state==GameStateConstants.OPTIONS)
		{
			currentGameState=new Options();
		}
		
		if(state==GameStateConstants.TIME_ATTACK)
		{
			currentGameState=new TimeAttack();
		}
		
		if(state==GameStateConstants.GAME_OVER)
		{
			currentGameState=new GameOver();
		}
	}
	
	/**
	 * initializes the current game state on screen
	 */
	public void initializeGameState()
	{
		currentGameState.initialize();
	}
	
	/**
	 * draws the current game state on screen
	 * @param spriteBatch
	 */
	public void drawGameState(SpriteBatch spriteBatch)
	{
		currentGameState.draw(spriteBatch);
	}
	
	/**
	 * updates the current game state on screen
	 */
	public void updateGameState(float deltaTime)
	{
		currentGameState.update(deltaTime);
	}
	
	/**
	 * dispose of the current game state on screen
	 */
	public void disposeGameState()
	{
		currentGameState.dispose();
	}

}
