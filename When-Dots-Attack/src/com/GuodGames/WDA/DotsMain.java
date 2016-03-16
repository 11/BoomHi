package com.GuodGames.WDA;

import com.GuodGames.Assets.Assets;
import com.GuodGames.Assets.Music;
import com.GuodGames.Constants.EntityConstants;
import com.GuodGames.Constants.GameStateConstants;
import com.GuodGames.GameStates.GameStateManager;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * 
 * @author Douglas Rudolph
 */
public class DotsMain implements ApplicationListener {
	
	/*
	 * public GameStateManager that can be accessed on every class
	 * allows for all classes to have the capability to manipulate GameStates
	 * and access components from GameStates they may be needed 
	*/
	public static GameStateManager stateManager;
	
	//main camera that we draw all images to the screen
	private OrthographicCamera camera;
	
	//main SpriteBatch that used to draw all throughout the different GameStates
	private SpriteBatch batch;
	
	public static Assets asset;
	
	/**
	 * main create method that initializes all objects on this main class
	 */
	@Override
	public void create() {	
		asset=new Assets();
		asset.loadMenu();
		asset.loadGame();
		Music.load();
		
		stateManager=new GameStateManager();
		
		stateManager.initializeGameState();
		stateManager.enterGameState(GameStateConstants.MAIN_MENU);
		
		camera = new OrthographicCamera(1, EntityConstants.SCREEN_HEIGHT/EntityConstants.SCREEN_WIDTH);
		camera.setToOrtho(false,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		batch = new SpriteBatch();
		
	}

	/**
	 * Main dispose method that releases all memory for the the currently running GameState
	 */
	@Override
	public void dispose() 
	{	
		stateManager.disposeGameState();
	}

	/**
	 * Main render method the renders and updates the current GameState
	 */
	@Override
	public void render() {				
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		
		//update cycle
		stateManager.updateGameState(Gdx.graphics.getDeltaTime());
		
		//drawing cycle
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		stateManager.drawGameState(batch);
		batch.end();
		
		if(Gdx.input.isKeyPressed(Keys.ESCAPE))
			Gdx.app.exit();
		
	}

	/**
	 * allows you to resize the screen
	 */
	@Override
	public void resize(int width, int height) {}

	/**
	 * allows you to set specified manipulations for when the game is paused
	 */
	@Override
	public void pause() {}

	/**
	 * allows you to set specified manipulations for when the game is resumed
	 */
	@Override
	public void resume() {}
}
