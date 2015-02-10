package com.mygdx.codeAssets.Handlers.UserInterfaceHandlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.codeAssets.Handlers.UserInterfaceHandler;
import com.mygdx.codeAssets.Objects.GameStateMutable;
import com.mygdx.codeAssets.Objects.GameStateMutable.GameState;
import com.mygdx.codeAssets.Objects.UIElement;
import com.mygdx.codeAssets.Objects.UIElements.UIButton;
import com.mygdx.codeAssets.Objects.UIElements.UITexture;

public class MainMenuUIHandler extends UserInterfaceHandler{

	
	public MainMenuUIHandler(GameStateMutable a_currentGameState) {
		super(a_currentGameState); 
		elements = new UIElement[4];

		initButtons();
		
	}
	
	private void initButtons(){
		BitmapFont font = new BitmapFont(Gdx.files.internal("Fonts/MenuFont.fnt"));
		int width = Gdx.graphics.getWidth();
		int height = Gdx.graphics.getHeight();
		elements[0] = new UIButton("MenuButton", "Hallo test", font);
		elements[1] = new UIButton("MenuButton", "Du hast keine Hose ", font);
		elements[2] = new UIButton("MenuButton", "Da test", font);
		elements[3] = new UITexture(new Texture("UIElements/Title.png"));

		setElementPositions(width, height);		
	}
	
	protected void setElementPositions(int a_width, int a_height){
		elements[0].setCenter(new Vector2(a_width / 2, a_height / 2 + 60));
		elements[1].setCenter(new Vector2(a_width / 2, a_height / 2));
		elements[2].setCenter(new Vector2(a_width / 2, a_height / 2 - 60));
		elements[3].setCenter(new Vector2(a_width / 2, a_height / 2 + 160));
		
	}
	
	@Override
	public void resize(int a_width, int a_height) {		
		super.resize(a_width, a_height);
	}
	
	@Override
	public void draw() {
	
		if (elements[1].isPressed()) {
			currentGameState.gameState = GameState.INGAME;
		}
		super.draw();
	}
	
}
