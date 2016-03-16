package com.GuodGames.GameStates;

import com.GuodGames.Assets.Assets;
import com.GuodGames.Constants.GameStateConstants;
import com.GuodGames.Tools.BackgroundTimer;
import com.GuodGames.Tools.MenuButton;
import com.GuodGames.WDA.DotsMain;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MainMenu extends GameState
{	
	private MenuButton play;
	
	//creates infinite background
	private BackgroundTimer backgroundTimer;
	
	//title screen text animation
	private Animation titleAnimation;
	
	//delta time that runs animation
	private float stateTime;
	
	/**
	 * initializes all textures for the main menu
	 */
	@Override
	public void initialize()
	{	
		//Music.mainMenu.play();
		//Music.mainMenu.loop();
		
		backgroundTimer =new BackgroundTimer(0,0);
		backgroundTimer.setCurrentBackground(true);
		
		titleAnimation=new Animation(1/8f,
				new TextureRegion(DotsMain.asset.titleOne),
				new TextureRegion(DotsMain.asset.titleTwo),
				new TextureRegion(DotsMain.asset.titleThree),
				new TextureRegion(DotsMain.asset.titleFour),
				new TextureRegion(DotsMain.asset.titleFive),
				new TextureRegion(DotsMain.asset.titleSix),
				new TextureRegion(DotsMain.asset.titleSev),
				new TextureRegion(DotsMain.asset.titleEight),
				new TextureRegion(DotsMain.asset.titleNine));
		
		titleAnimation.setPlayMode(Animation.LOOP);
		
		stateTime=0;
		
		play=new MenuButton(DotsMain.asset.timeAttackButton,
				Gdx.graphics.getWidth()/2-50,
				Gdx.graphics.getHeight()/2-100,
				100,
				75,
				GameStateConstants.TIME_ATTACK);
	}
	
	/**
	 * draws all the textures for the main menu
	 */
	@Override
	public void draw(SpriteBatch spriteBatch)
	{
		backgroundTimer.draw(spriteBatch);
		
		spriteBatch.draw(titleAnimation.getKeyFrame(stateTime),Gdx.graphics.getWidth()/2-(200/2), Gdx.graphics.getHeight()/2,200,200);
		
		//play.draw(spriteBatch);
		play.draw(spriteBatch);
	}
	
	/**
	 * updates all buttons and objects on screen for the main menu
	 */
	@Override
	public void update(float deltaTime) 
	{
		backgroundTimer.update(deltaTime);
		this.stateTime+=deltaTime;
		
		play.update();
		//play.update();
	}

	/**
	 * disposes of all game objects on screen for the main menu
	 */
	@Override
	public void dispose()
	{
		play.dispose();
		//play.dispose();
	}
}
