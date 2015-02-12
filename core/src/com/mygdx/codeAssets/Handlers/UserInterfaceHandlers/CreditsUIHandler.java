package com.mygdx.codeAssets.Handlers.UserInterfaceHandlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.mygdx.codeAssets.Handlers.UserInterfaceHandler;
import com.mygdx.codeAssets.Objects.GameStateMutable;
import com.mygdx.codeAssets.Objects.GameStateMutable.GameState;
import com.mygdx.codeAssets.Objects.UIElement;
import com.mygdx.codeAssets.Objects.UIElements.UIText;

public class CreditsUIHandler extends UserInterfaceHandler{

	private BitmapFont font;
	private int creditsRollTime;
	private float currentTime;
	private int viewportWidth;
	private int viewportHeight;
	
	public CreditsUIHandler(GameStateMutable a_currentGameState) {
		super(a_currentGameState);
		
		font = new BitmapFont();
		font.setColor(Color.BLACK);
		
		currentTime = 0;
		creditsRollTime = 10 * 1000;
		
		viewportWidth = Gdx.graphics.getWidth();
		viewportHeight = Gdx.graphics.getHeight();
		
		initElements();
	}
	
	private void initElements(){
		elements = new UIElement[1];
		
		elements[0] = new UIText("Title\n\n" + "Work done by\n" + "<names>\n", font, true);
		setElementPositions(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}
	
	
	@Override
	protected void setElementPositions(int a_width, int a_height) {
		
		elements[0].setCenter(a_width / 2, (int)(0 + currentTime * 0.1f));
		
	}
	
	@Override
	public void update() {
		currentTime += Gdx.graphics.getDeltaTime() * 1000;
		
		setElementPositions(viewportWidth, viewportHeight);
		
		if (currentTime > creditsRollTime) {
			currentGameState.gameState = GameState.MAINMENU;
		}
		
	}
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		

		super.draw();
	}
	
	
	@Override
	public boolean keyDown(int keycode) {
		switch (keycode) {
		case Keys.ESCAPE:
			currentGameState.gameState = GameState.MAINMENU;
			break;
		default:
			return false;
		}
		return true;
	}
	
	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean scrolled(int amount) {
		return false;
	}

	@Override
	public void resize(int a_width, int a_height) {
		viewportWidth = a_width;
		viewportHeight = a_height;
		super.resize(a_width, a_height);
	}
}
