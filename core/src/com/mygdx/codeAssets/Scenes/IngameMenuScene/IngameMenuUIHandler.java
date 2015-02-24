package com.mygdx.codeAssets.Scenes.IngameMenuScene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.mygdx.codeAssets.Handlers.UserInterfaceHandler;
import com.mygdx.codeAssets.Objects.GameStateMutable.GameState;
import com.mygdx.codeAssets.Objects.UIElement;
import com.mygdx.codeAssets.Objects.UIElements.UIButton;
import com.mygdx.codeAssets.Scenes.SceneAbstract;

public class IngameMenuUIHandler extends UserInterfaceHandler {

	BitmapFont font;
	
	public IngameMenuUIHandler(SceneAbstract a_scene) {
		super(a_scene);
		
		font = new BitmapFont();
		font.setColor(Color.BLACK);
		
		initalizeElements();
	}
	
	private void initalizeElements(){
		elements = new UIElement[3];
		
		elements[0] = new UIButton("MenuButton", "Resume to Game", font);
		elements[1] = new UIButton("MenuButton", "Options", font);
		elements[2] = new UIButton("MenuButton", "Save and Quit", font);
		
		setElementPositions(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
	}
	
	@Override
	protected void setElementPositions(int a_width, int a_height) {
		elements[0].setCenter(a_width / 2, a_height / 2 + 60);
		elements[1].setCenter(a_width / 2, a_height / 2);
		elements[2].setCenter(a_width / 2, a_height / 2 - 60);
		
	}
	
	@Override
	public void update() {
		
	}

	@Override
	public boolean touchDown(int a_screenX, int a_screenY, int a_button) {
		if (super.touchDown(a_screenX, a_screenY, a_button)) {
			if (elements[0].isPressed()) {
				scene.setNewState(GameState.INGAME);
			}
			if (elements[1].isPressed()) {
				//Options scene
			}
			if (elements[2].isPressed()){
				scene.setNewState(GameState.MAINMENU);
			}
			return true;
		}
		
		return false;
	}
	
	
	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

	

}
