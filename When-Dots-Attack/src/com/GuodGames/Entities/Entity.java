package com.GuodGames.Entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity 
{
	public static float TOP;
	
	public static float RIGHT;
	
	public static float BOTTOM;
	
	public static float LEFT;
	
	public static Vector2 ORIGIN;
	
	public static float X;
	
	public static float Y;
	
	private Texture entity;
			
	public Entity(Texture entity,float x, float y, float width, float height) 
	{
		this.entity=entity;
		Entity.X=x;
		Entity.Y=y;
		Entity.TOP=this.entity.getHeight();
		Entity.BOTTOM=y;
		Entity.LEFT=x;
		Entity.RIGHT=width;
		Entity.ORIGIN=new Vector2(this.entity.getWidth()/2, this.entity.getHeight()/2);
	}
	
	public abstract void initialize();
	
	public abstract void draw(SpriteBatch spriteBatch);
	
	public abstract void update(float delta);
	
	public abstract void dispose();
	
}
