package com.mygdx.codeAssets.Scenes.MainMenuScene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.mygdx.codeAssets.Handlers.UserInterfaceHandler;
import com.mygdx.codeAssets.Objects.GameStateMutable.GameState;
import com.mygdx.codeAssets.Objects.UIElement;
import com.mygdx.codeAssets.Objects.UIElements.UIButton;
import com.mygdx.codeAssets.Objects.UIElements.UIText;
import com.mygdx.codeAssets.Objects.UIElements.UITexture;
import com.mygdx.codeAssets.Scenes.SceneAbstract;

public class MainMenuUIHandler extends UserInterfaceHandler{

	
	public MainMenuUIHandler(SceneAbstract a_scene) {
		super(a_scene);
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
		elements[5] = new UIText("RPG_FS v0.0.2", font, false);
		elements[6] = new UIText("All right reserved by <insert companyname>", font, false);
				
		setElementPositions(width, height);		
	}
	
	protected void setElementPositions(int a_width, int a_height){
		elements[0].setCenter(a_width / 2, a_height / 2 + 60);
		elements[1].setCenter(a_width / 2, a_height / 2);
		elements[2].setCenter(a_width / 2, a_height / 2 - 60);
		elements[3].setCenter(a_width / 2, a_height / 2 - 120);
		elements[4].setCenter(a_width / 2, a_height / 2 + 160);
		elements[5].setPosition(10, 20);
		elements[6].setPosition(a_width - elements[6].getWidth() - 10, 20);
		
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
	public void update() {
		
	}
	
	@Override
	public boolean touchDown(int a_screenX, int a_screenY, int a_button) {
		if(super.touchDown(a_screenX, a_screenY, a_button)){
			if (elements[0].isPressed()) {
				scene.setNewState(GameState.INGAME);
			}
			if (elements[2].isPressed()) {
				scene.setNewState(GameState.CREDITS);
			}
			if (elements[3].isPressed()) {
				scene.setNewState(GameState.EXIT);
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
