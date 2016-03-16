package com.GuodGames.Tools;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class GameObject 
{

	protected float stateTime;
	
	protected float x, y, width, height;
	
	public GameObject(){}
	
	
	public GameObject(float x, float y, float width, float height)
	{
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}
	
	public abstract void initialize();
		
	public abstract void draw(SpriteBatch spriteBatch);
	
	public abstract void update(float deltatTime);
	
	public abstract void dispose();
	
}
