package com.mygdx.codeAssets.Handlers.UserInterfaceHandlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.codeAssets.Handlers.UserInterfaceHandler;
import com.mygdx.codeAssets.Objects.UIElement;
import com.mygdx.codeAssets.Objects.UIElements.UIButton;
import com.mygdx.codeAssets.Objects.UIElements.UITexture;

public class MainMenuUIHandler extends UserInterfaceHandler{

	
	public MainMenuUIHandler() {
		super(); 
		elements = new UIElement[4];

		initButtons();
		
	}
	
	private void initButtons(){
		BitmapFont font = new BitmapFont(Gdx.files.internal("Fonts/MenuFont.fnt"));
		elements[0] = new UIButton("MenuButton", "Hallo test", new Vector2(30, 30), 300, font);
		elements[1] = new UIButton("MenuButton", "Du hast keine Hose ", new Vector2(30, 130), 300, font);
		elements[2] = new UIButton("MenuButton", "Da test", new Vector2(30, 230), 300, font);
		elements[3] = new UITexture(new Texture("UIElements/Title.png"));
		
		elements[0].setCenter(new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2 + 60));
		elements[1].setCenter(new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2));
		elements[2].setCenter(new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2 - 60));
		elements[3].setCenter(new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2 + 160));
		
	}
	
	@Override
	public void resize() {
		
		//TODO: resize every UI element to right position (repositioning)
		//"magnet" sticking to left / right / top / bottom
		
		super.resize();
	}
	

	
}
