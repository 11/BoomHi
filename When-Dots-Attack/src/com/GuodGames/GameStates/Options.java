package com.GuodGames.GameStates;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * 
 * @author Douglas Rudolph
 */
public class Options extends GameState
{
	
	//array lists of all textures on screen
	private ArrayList <Texture> textures;
	
	/**
	 * initializes all objects
	 */
	@Override
	public void initialize() 
	{
		textures= new ArrayList<Texture>();
		textures.add(new Texture("data/background.png"));
	}

	/**
	 * draws all objects to the screen
	 */
	@Override
	public void draw(SpriteBatch spriteBatch) 
	{
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		spriteBatch.draw(textures.get(0),0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/2);
	}

	/**
	 * updates all objects on screen
	 */
	@Override
	public void update(float deltaTime) 
	{
		
	}

	/**
	 * disposes of all objects on screen
	 */
	@Override
	public void dispose() 
	{
		for(Texture tex:textures)
		{
			tex.dispose();
		}
	}
}
