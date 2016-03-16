package com.GuodGames.GameStates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class GameState 
{
	//time that is shown to the player
	public static float gameTime;
	
	//time for how long the current state has been playing for
	protected float stateDuration;
	
	//score for the current state
	public static int score;
	
	//boolean to see if time attack is being played
	protected boolean timeAttack;
	
	//boolean that keeps track if the game is paused
	protected boolean isPaused;

	/**
	 * Parent constructor for all game states
	 */
	public GameState()
	{
		score=0;
		timeAttack=false;
		this.stateDuration=0;
		initialize();
	}
	
	/**
	 * abstract method that initializes all objects in game states
	 */
	public abstract void initialize();
	
	/**
	 * abstract method that draws all textures to the screen
	 * @param spriteBatch
	 */
	public abstract void draw(SpriteBatch spriteBatch);
	
	/**
	 * abstract method that updates all objects on screen
	 */
	public abstract void update(float delta);

	/**
	 * abstract method that disposes of all objects on screen
	 */
	public abstract void dispose();
	
	/**
	 * returns the stateDuration
	 * @return
	 */
	public int getStateDuration()
	{
		return (int) this.stateDuration;
	}
	
	/**
	 * updates State Duration
	 */
	public void updateStateDuration()
	{
		stateDuration+=Gdx.graphics.getDeltaTime();
	}
	
	/**
	 * returns the boolean value of timeAttack
	 * @return
	 */
	public boolean getTimeAttack()
	{
		return this.timeAttack;
	}
	
	/**
	 * allows you to set the boolean value of timeAttack
	 * @param swap
	 */
	public void setTimeAttack(boolean swap)
	{
		this.timeAttack=swap;
	}
}
