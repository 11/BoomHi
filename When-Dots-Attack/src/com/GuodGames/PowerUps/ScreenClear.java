package com.GuodGames.PowerUps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Circle;

public class ScreenClear extends PowerUpObject
{

	private boolean circleGrowing;
	private int radius;
	
	private ShapeRenderer sRenderer;
	
	@Override
	public void initialize() 
	{
		circleGrowing=false;
		sRenderer=new ShapeRenderer();
		radius=2;
	}

	@Override
	public void update(float deltaTime) 
	{
		//if two fingers are down
		if(Gdx.input.isTouched(0) && Gdx.input.isTouched(1))
		{
			circleGrowing=true;
			radius+=5;
			
			if(radius==Gdx.graphics.getWidth())
			{
				circleGrowing=false;
			}
		}
	}
	
	@Override
	public void draw(SpriteBatch spriteBatch) 
	{
		if(circleGrowing)
		{
			sRenderer.begin(ShapeType.Line);
			sRenderer.circle(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2, radius);
			sRenderer.end();
		}
	}

	@Override
	public void dispose() 
	{
		
	}
	
}
