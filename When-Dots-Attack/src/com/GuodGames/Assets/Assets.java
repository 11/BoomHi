package com.GuodGames.Assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class Assets 
{

	public Texture logo;
	
	public Texture lightBackground;
	
	public Texture darkBackground;
	
	public Texture blueDotOne;
	
	public Texture blueDotTwo;
	
	public Texture blueDotThree;
	
	public Texture blueDotFour;
	
	public Texture blueDotFive;
	
	public Texture blueDotSix;
	
	public Texture libgdx;
	
	public Texture optionsButton;
	
	public Texture timeAttackButton;
	
	public Texture goldDotOne;
	
	public Texture goldDotTwo;
	
	public Texture goldDotThree;
	
	public Texture goldDotFour;
	
	public Texture goldDotFive;
	
	public Texture goldDotSix;
	
	public Texture levelbarBackground;
	
	public Texture levelBar;
	
	public Texture pinkDotOne;
	
	public Texture pinkDotTwo;
	
	public Texture pinkDotThree;
	
	public Texture pinkDotFour;
	
	public Texture pinkDotFive;
	
	public Texture pinkDotSix;
	
	public Texture titleOne;
	
	public Texture titleTwo;
	
	public Texture titleThree;
	
	public Texture titleFour;
	
	public Texture titleFive;
	
	public Texture titleSix;
	
	public Texture titleSev;
	
	public Texture titleEight;
	
	public Texture titleNine;
	
	public Texture playButtonOne;
	
	public Texture playButtonTwo;
	
	public Texture playButtonThree;
	
	public Texture playButtonFour;
	
	public Texture playButtonFive;
	
	public Texture playButtonSix;
	
	public Texture playButtonSev;
	
	public Texture playButtonEight;
	
	public Texture playButtonNine;
	
	public Texture playButtonTen;
	
	public Texture playButtonElev;
	
	public BitmapFont gameFont;
	
	/**
	 * loads all game textures 
	 */
	public void loadMenu()
	{
		timeAttackButton=new Texture(Gdx.files.internal("Button/TimeAttackButton.png"));
		logo=new Texture(Gdx.files.internal("TitleText/Thumbs Up.png"));
		
		playButtonOne =  new Texture(Gdx.files.internal("PlayButton/Play Button 1_edited-2.png"));
		playButtonTwo =  new Texture(Gdx.files.internal("PlayButton/Play Button 10_edited-1.png"));
		playButtonThree =new Texture(Gdx.files.internal("PlayButton/Play Button 11_edited-1.png"));
		playButtonFour = new Texture(Gdx.files.internal("PlayButton/Play Button 2_edited-2.png"));
		playButtonFive = new Texture(Gdx.files.internal("PlayButton/Play Button 3_edited-1.png"));
		playButtonSix =  new Texture(Gdx.files.internal("PlayButton/Play Button 4_edited-1.png"));
		playButtonSev =  new Texture(Gdx.files.internal("PlayButton/Play Button 5_edited-1.png"));
		playButtonEight =new Texture(Gdx.files.internal("PlayButton/Play Button 6_edited-1.png"));
		playButtonNine = new Texture(Gdx.files.internal("PlayButton/Play Button 7_edited-1.png"));
		playButtonTen =  new Texture(Gdx.files.internal("PlayButton/Play Button 8_edited-1.png"));
		playButtonElev = new Texture(Gdx.files.internal("PlayButton/Play Button 9_edited-1.png"));
		
		lightBackground=new Texture(Gdx.files.internal("Background/Blue Gradient Background_edited-1.png"));
		darkBackground=new Texture(Gdx.files.internal("Background/Darker Blue.png"));
		
		libgdx=new Texture(Gdx.files.internal("Button/libgdx.png"));
		
		optionsButton=new Texture(Gdx.files.internal("Button/OptionsButton.png"));
		
		titleOne=new Texture(Gdx.files.internal("TitleText/Title 1.png"));
		titleTwo=new Texture(Gdx.files.internal("TitleText/Title 2.png"));
		titleThree=new Texture(Gdx.files.internal("TitleText/Title 3.png"));
		titleFour=new Texture(Gdx.files.internal("TitleText/Title 4.png"));
		titleFive=new Texture(Gdx.files.internal("TitleText/Title 5.png"));
		titleSix=new Texture(Gdx.files.internal("TitleText/Title 6.png"));
		titleSev=new Texture(Gdx.files.internal("TitleText/Title 7.png"));
		titleEight=new Texture(Gdx.files.internal("TitleText/Title 8.png"));
		titleNine=new Texture(Gdx.files.internal("TitleText/Title 9.png"));
		
	}
	
	public void loadGame()
	{
		gameFont=new BitmapFont(Gdx.files.internal("Font/pixel.fnt"));
		
		levelbarBackground=new Texture(Gdx.files.internal("LevelBar/Experience Bar Purple_edited-3.png"));
		levelBar=new Texture(Gdx.files.internal("LevelBar/Experience Bar.png"));
		lightBackground=new Texture(Gdx.files.internal("Background/Blue Gradient Background_edited-1.png"));
		darkBackground=new Texture(Gdx.files.internal("Background/Darker Blue.png"));
	
		blueDotOne=new Texture(Gdx.files.internal("BlueDot/Blue 1_edited-1.png"));
		blueDotTwo=new Texture(Gdx.files.internal("BlueDot/Blue 2_edited-1.png"));
		blueDotThree=new Texture(Gdx.files.internal("BlueDot/Blue 3_edited-1.png"));
		blueDotFour=new Texture(Gdx.files.internal("BlueDot/Blue 4_edited-1.png"));
		blueDotFive=new Texture(Gdx.files.internal("BlueDot/Blue 5_edited-1.png"));
		blueDotSix=new Texture(Gdx.files.internal("BlueDot/Blue 6_edited-1.png"));
		
		goldDotOne=new Texture(Gdx.files.internal("GoldDot/Yellow Dot 1_edited-1.png"));
		goldDotTwo=new Texture(Gdx.files.internal("GoldDot/Yellow Dot 2_edited-1.png"));
		goldDotThree=new Texture(Gdx.files.internal("GoldDot/Yellow Dot 3_edited-1.png"));
		goldDotFour=new Texture(Gdx.files.internal("GoldDot/Yellow Dot 4_edited-1.png"));
		goldDotFive=new Texture(Gdx.files.internal("GoldDot/Yellow Dot 5_edited-1.png"));
		goldDotSix=new Texture(Gdx.files.internal("GoldDot/Yellow Dot 6_edited-1.png"));
		
		pinkDotOne=new Texture(Gdx.files.internal("PinkDot/Pink 1_edited-1.png"));
		pinkDotTwo=new Texture(Gdx.files.internal("PinkDot/Pink 2_edited-1.png"));
		pinkDotThree=new Texture(Gdx.files.internal("PinkDot/Pink 3_edited-1.png"));
		pinkDotFour=new Texture(Gdx.files.internal("PinkDot/Pink 4_edited-1.png"));
		pinkDotFive=new Texture(Gdx.files.internal("PinkDot/Pink 5_edited-1.png"));
		pinkDotSix=new Texture(Gdx.files.internal("PinkDot/Pink 6_edited-1.png"));
	}
}
