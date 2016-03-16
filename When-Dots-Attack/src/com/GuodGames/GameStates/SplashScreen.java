package com.GuodGames.GameStates;

import com.GuodGames.Assets.Assets;
import com.GuodGames.Constants.GameStateConstants;
import com.GuodGames.Tools.SpawnTimer;
import com.GuodGames.WDA.DotsMain;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SplashScreen extends GameState{

	
	private Texture logo;
	
	private BitmapFont logoFont;
	
	private SpawnTimer time;
	@Override
	public void initialize() 
	{
		logo=DotsMain.asset.logo;
		logoFont=DotsMain.asset.gameFont;
		time= new SpawnTimer();
		time.setTime(0);
		
	}

	@Override
	public void draw(SpriteBatch spriteBatch) 
	{
		spriteBatch.draw(logo,Gdx.graphics.getWidth()/2-50, Gdx.graphics.getHeight()/2-50,50,50);
		logoFont.draw(spriteBatch, ""+(int)time.getTime(), 0, 100);
		logoFont.draw(spriteBatch, "Games", 400, 200);
	}

	@Override
	public void update(float delta) 
	{
		time.updateTimer();
		if(time.getTime()==5)
			DotsMain.stateManager.enterGameState(GameStateConstants.MAIN_MENU);
	}

	@Override
	public void dispose() 
	{
		
	}

}
