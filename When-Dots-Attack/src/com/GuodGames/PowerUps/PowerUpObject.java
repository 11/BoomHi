package com.GuodGames.PowerUps;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class PowerUpObject 
{

	protected float x,y,width,height;
	
	protected float stateTime;
	
	public abstract void initialize();
	
	public abstract void draw(SpriteBatch spriteBatch);
	
	public abstract void update(float deltaTime);
	
	public abstract void dispose();


}
