package com.GuodGames.Tools;

import com.GuodGames.Constants.EntityConstants;
import com.GuodGames.Constants.GameStateConstants;
import com.GuodGames.Entities.Dot;
import com.GuodGames.Entities.EvilDot;
import com.GuodGames.Entities.GoodDot;
import com.GuodGames.WDA.DotsMain;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Spawns Dots randomly on the screen
 * @author Douglas Rudolph
 */
public class RandomGrid 
{
	//constant that stores all maximum amount of dots allowed on screen
	private final int MAX_DOTS_ON_SCREEN=7;
	
	//
	private int numOfGoodDots;
	
	//boolean variable keep track of spawn timing if the grid has been set
	private boolean hasSet;
	
	//array of dots that will be generated to the screen
	private Dot [] dotsOnScreen;
	
	//timer used to control, increase, and decrease the spawn rate
	private SpawnTimer spawnTimer;
	
	/**
	 * constructor
	 * declares each instance of random grid
	 */
	public RandomGrid()
	{
		this.numOfGoodDots=0;
		this.dotsOnScreen=new Dot[this.MAX_DOTS_ON_SCREEN];
		this.spawnTimer=new SpawnTimer();
		this.hasSet=true;
	}
	
	/**
	 * draws dots to the screen
	 * @param spriteBatch
	 */
	public void draw(SpriteBatch spriteBatch)
	{
		for(int count=0; count<this.MAX_DOTS_ON_SCREEN; count++)
		{
			if(dotsOnScreen[count]!=null)
			{
				this.dotsOnScreen[count].draw(spriteBatch);
			}
		}
	}
	
	/**
	 * updates all dots that are currently generated to the screen
	 * @throws InterruptedException 
	 */
	public void update() 
	{		
		if(!(LevelBar.width<=0))
		{
			this.numOfGoodDots=0;
			for(int count=0; count<this.MAX_DOTS_ON_SCREEN;count++)
			{
				if(this.dotsOnScreen[count]!=null)
				{
					this.dotsOnScreen[count].update();
				}
				
				if(dotsOnScreen[count] instanceof GoodDot && dotsOnScreen[count].getIsShowing())
				{	
					numOfGoodDots+=1;
				}
			
			}
			if(this.numOfGoodDots==0)
			{
				hasSet=true;
			}
			
				//if it has been 1 second
				if(this.spawnTimer.getTime()==1)
				{
					//spawn objects
					this.hasSet=true;
				}	
				
				//spawn objects
				if(this.hasSet)
				{
					//randomly draw dots to the screen
					this.setGrid();
					this.hasSet=false;
					this.spawnTimer.reset();
				}
				
				//spawn object
				spawnTimer.updateTimer();
		}
		//if game time = 0
		else
		{
			//go to game over screen
			DotsMain.stateManager.enterGameState(GameStateConstants.GAME_OVER);
 		}
	}
	
	/**
	 * disposes of all dots currently generated to the screen
	 */
	public void dispose()
	{
		for(int count=0; count<this.dotsOnScreen.length;count++)
		{
			if(this.dotsOnScreen!=null)
			{
				this.dotsOnScreen[count].dispose();
			}
		}
	}
	
	/**
	 * spawning algorithm
	 * - ERROR - decrease the y spawn coordinates as it loops through to prevent overlapping
	 */
	private void setGrid()
	{
		int num;
		int counter=0;
		for(int count=0;count<this.MAX_DOTS_ON_SCREEN; count++)
		{
			num=1 + (int)(Math.random() * ((this.MAX_DOTS_ON_SCREEN- 1) + 1));
				
			if(num%2==0)
			{
				this.dotsOnScreen[count]=new GoodDot(this.setEntityLocation().x, this.setEntityLocation().y,
							EntityConstants.DOT_WIDTH, EntityConstants.DOT_HEIGHT);
				counter++;
			}
			if(num%4==0)
			{
				this.dotsOnScreen[count]=new EvilDot(this.setEntityLocation().x, this.setEntityLocation().y,
						EntityConstants.DOT_WIDTH, EntityConstants.DOT_HEIGHT);
				counter++;
			}
			
			//if more than 3 dots have spawned, break
			if(counter==2)
			{
				break;
			}
		}
	}
	
	/**
	 * returns a random vector 2 object that sets random spawning coordinates for Dots
	 * @return
	 */
	private Vector2 setEntityLocation()
	{
		int x= 10 + (int)(Math.random() * ((Gdx.graphics.getWidth()-
				(EntityConstants.DOT_WIDTH+EntityConstants.DOT_DELTA_DISTANCE) - 10) + 1));
		int y= 10 + (int)(Math.random() * ((Gdx.graphics.getHeight()-
				(EntityConstants.DOT_HEIGHT+EntityConstants.DOT_DELTA_DISTANCE+25)) + 1));
		return new Vector2(x,y);
	}

	
}
