package com.mygdx.codeAssets.Handlers.UserInterfaceHandlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.codeAssets.Handlers.PlayerHandler;
import com.mygdx.codeAssets.Handlers.UserInterfaceHandler;
import com.mygdx.codeAssets.Objects.GameStateMutable;
import com.mygdx.codeAssets.Objects.GameStateMutable.GameState;
import com.mygdx.codeAssets.Objects.UIElement;
import com.mygdx.codeAssets.Objects.UIElements.UITexture;

public class IngameUIHandler extends UserInterfaceHandler{

	PlayerHandler playerHandler;
	Vector2 debugPosition;
	BitmapFont debugFont;
	
	public IngameUIHandler(PlayerHandler a_playerHandler, GameStateMutable a_currentGameState) {
		super(a_currentGameState);
		playerHandler = a_playerHandler;
		debugPosition = new Vector2(10,0);
		debugFont = new BitmapFont();
		debugFont.setColor(Color.WHITE);
		
		initElements();
		
	}
	
	private void initElements(){
		elements = new UIElement[2];
		
		elements[0] = new UITexture(new Texture("missingtxt.png"));
		elements[1] = new UITexture(new Texture("UIElements/IngameHUDTest.png"));
		
		setElementPositions(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}
	
	@Override
	protected void setElementPositions(int a_width, int a_height) {
		elements[0].setCenter(new Vector2(a_width / 2, elements[0].getHeight()));
		elements[1].setPosition(new Vector2(0, a_height - elements[1].getHeight()));
	}
	
	
	@Override
	public void touchDown(int a_screenX, int a_screenY, int a_button) {
		
		super.touchDown(a_screenX, a_screenY, a_button);
	}
	
	@Override
	public void touchUp(int a_screenX, int a_screenY, int a_button) {
			
		super.touchUp(a_screenX, a_screenY, a_button);
	}
	
	
	@Override
	public void mouseMoved(int a_screenX, int a_screenY) {
		
		super.mouseMoved(a_screenX, a_screenY);
	}
	
	
	@Override
	public void draw() {
		
		if (elements[0].isPressed()) {
			currentGameState.gameState = GameState.MAINMENU;
		}
		
		
		if (isDebug)
			drawDebugInfo();
		super.draw();
	}
	
	

	@Override
	public void keyDown(int keycode) {
		switch (keycode) {
		case Keys.F1:
			isDebug = !isDebug;
			break;
		default:
			break;
		}
	}
	
	@Override
	public void keyUp(int keycode) {
		
	}
	
	private void drawDebugInfo()
	{
		debugPosition.y = Gdx.graphics.getHeight() - debugPosition.x;
		
				
		userInterfaceBatch.setProjectionMatrix(normalProjection);
		userInterfaceBatch.begin();
		
				
		debugFont.draw(userInterfaceBatch, "FPS: " + Gdx.graphics.getFramesPerSecond(), debugPosition.x , debugPosition.y);
		debugFont.draw(userInterfaceBatch, "XYZ: " 
				+ String.format("%.2f", playerHandler.player.position.x) + " | " 
				+ String.format("%.2f", playerHandler.player.position.y) + " | "  
				+ String.format("%.2f", playerHandler.player.position.z), debugPosition.x, debugPosition.y - debugFont.getLineHeight() - 2);
		debugFont.draw(userInterfaceBatch, "t-XYZ: " 
				+ String.format("%.0f", playerHandler.player.tilePosition.x) + " | "   
				+ String.format("%.0f", playerHandler.player.tilePosition.y) + " | "  
				+ String.format("%.0f", playerHandler.player.tilePosition.z), debugPosition.x, debugPosition.y - (2 * debugFont.getLineHeight()) - 2);
		debugFont.draw(userInterfaceBatch, "Facing: "  + String.format("%2.0f", playerHandler.player.getFacingDirection().x)
				+ String.format("%2.0f", playerHandler.player.getFacingDirection().y), debugPosition.x, debugPosition.y - (3 * debugFont.getLineHeight())- 2);
		
		userInterfaceBatch.end();
	}
	
}
