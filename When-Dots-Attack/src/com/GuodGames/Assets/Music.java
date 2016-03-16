package com.GuodGames.Assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class Music 
{

	public static Sound mainMenu;
	
	public static Sound inGame;
	
	public static void load()
	{
		mainMenu=Gdx.audio.newSound(Gdx.files.internal("Sound/8bitgamesonglol.wav"));
	}
	
}
