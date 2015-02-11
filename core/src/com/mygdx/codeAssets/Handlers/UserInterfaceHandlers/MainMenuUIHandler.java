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
import com.mygdx.codeAssets.Objects.UIElements.UIText;
import com.mygdx.codeAssets.Objects.UIElements.UITexture;

public class MainMenuUIHandler extends UserInterfaceHandler{

	
	public MainMenuUIHandler(GameStateMutable a_currentGameState) {
		super(a_currentGameState); 

		initButtons();
		
	}
	
	private void initButtons(){
		
		elements = new UIElement[7];
		
		BitmapFont font = new BitmapFont(Gdx.files.internal("Fonts/MenuFont.fnt"));
		int width = Gdx.graphics.getWidth();
		int height = Gdx.graphics.getHeight();
		elements[0] = new UIButton("MenuButton", "Start New Game", font);
		elements[1] = new UIButton("MenuButton", "Load Game", font);
		elements[2] = new UIButton("MenuButton", "Credits", font);
		elements[3] = new UIButton("MenuButton", "Quit Game", font);
		elements[4] = new UITexture(new Texture("UIElements/Title.png"));
		elements[5] = new UIText("RPG_FS v0.0.1", font);
		elements[6] = new UIText("All right reserved by <insert companyname>", font);
				
		setElementPositions(width, height);		
	}
	
	protected void setElementPositions(int a_width, int a_height){
		elements[0].setCenter(new Vector2(a_width / 2, a_height / 2 + 60));
		elements[1].setCenter(new Vector2(a_width / 2, a_height / 2));
		elements[2].setCenter(new Vector2(a_width / 2, a_height / 2 - 60));
		elements[3].setCenter(new Vector2(a_width / 2, a_height / 2 - 120));
		elements[4].setCenter(new Vector2(a_width / 2, a_height / 2 + 160));
		elements[5].setPosition((new Vector2(10, 20)));
		elements[6].setPosition(new Vector2(a_width - elements[6].getWidth() - 10, 20));
		
	}
	
	@Override
	public void resize(int a_width, int a_height) {		
		super.resize(a_width, a_height);
	}
	
	@Override
	public void draw() {
		super.draw();
	}
	
	@Override
	public void touchDown(int a_screenX, int a_screenY, int a_button) {
		super.touchDown(a_screenX, a_screenY, a_button);
		
		if (elements[0].isPressed()) {
			currentGameState.gameState = GameState.INGAME;
		}
		if (elements[3].isPressed()) {
			Gdx.app.exit();
		}
		
	}
	
	@Override
	public void keyDown(int keycode) {
		
	}
	
	@Override
	public void keyUp(int keycode) {

	}
	
}
