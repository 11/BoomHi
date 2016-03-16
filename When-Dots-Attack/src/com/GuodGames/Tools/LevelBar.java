package com.GuodGames.Tools;

import com.GuodGames.Assets.Assets;
import com.GuodGames.WDA.DotsMain;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LevelBar
{

	private Texture texture;
	private Texture backgroundTexture;
	
	private float x;
	private float y;
	public static float width;
	private float height;
	
	private float shrinkVelocity;
	
	
	
	public LevelBar(float x, float y, float width, float height)
	{
		this.x=x;
		this.y=y;
		LevelBar.width=width;
		this.height=height;
		this.initialize();
	}

	public LevelBar(float x, float y, float width, float height, float shrinkVelocity)
	{
		this.x=x;
		this.y=y;
		LevelBar.width=width;
		this.height=height;
		this.shrinkVelocity=shrinkVelocity;
	}
	
	private void initialize()
	{ 
		texture = DotsMain.asset.levelBar;
		backgroundTexture = DotsMain.asset.levelbarBackground;
	}
	
	public void draw(SpriteBatch spriteBatch)
	{
		spriteBatch.draw(backgroundTexture, x,y, Gdx.graphics.getWidth(), height);
		spriteBatch.draw(texture,x,y,width,height);
	}
	
	public void update(float deltaTime)
	{
		if(LevelBar.width>=0)
		{
			width-=shrinkVelocity*deltaTime;
		}
		
		if(LevelBar.width>=Gdx.graphics.getWidth())
		{
			LevelBar.width=25;
		}
	}
	
	public void dispose()
	{
		texture.dispose();
	}
	
	public void setShrinkVelocity(float velocity)
	{
		this.shrinkVelocity=velocity;
	}
}
