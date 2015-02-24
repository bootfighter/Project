package com.mygdx.codeAssets.Scenes.IngameScene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.codeAssets.Handlers.PlayerHandler;
import com.mygdx.codeAssets.Handlers.UserInterfaceHandler;
import com.mygdx.codeAssets.Objects.GameStateMutable.GameState;
import com.mygdx.codeAssets.Objects.UIElement;
import com.mygdx.codeAssets.Objects.UIElements.UITexture;
import com.mygdx.codeAssets.Scenes.SceneAbstract;

public class IngameUIHandler extends UserInterfaceHandler{

	PlayerHandler playerHandler;
	Vector2 debugPosition;
	BitmapFont debugFont;
	
	Pixmap debugPixmap;
	Texture debugTexture;
	
	public IngameUIHandler(PlayerHandler a_playerHandler, SceneAbstract a_scene) {
		super(a_scene);
		playerHandler = a_playerHandler;
		debugPosition = new Vector2(10,0);
		debugFont = new BitmapFont();
		debugFont.setColor(Color.WHITE);
		
		
		debugPixmap = new Pixmap(250, 100, Format.RGBA8888);
		debugPixmap.setColor(.3f, .3f, .3f, .7f);
		debugPixmap.fill();
		debugTexture = new Texture(debugPixmap);
		
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
		elements[0].setCenter(a_width / 2, elements[0].getHeight());
		elements[1].setPosition(0, a_height - elements[1].getHeight());
	}
	
	
	@Override
	public boolean touchDown(int a_screenX, int a_screenY, int a_button) {
		
		if (super.touchDown(a_screenX, a_screenY, a_button)) {
			if (elements[0].isPressed()) {
				scene.setNewState(GameState.MAINMENU);
			}
			return true;
		}
		return false;
	}
	
	@Override
	public boolean touchUp(int a_screenX, int a_screenY, int a_button) {
			
		return super.touchUp(a_screenX, a_screenY, a_button);
	}
	
	
	@Override
	public boolean mouseMoved(int a_screenX, int a_screenY) {
		
		return super.mouseMoved(a_screenX, a_screenY);
	}
	
	
	@Override
	public void draw() {
		super.draw();
		
		if (isDebug)
			drawDebugInfo();
	}
	
	@Override
	public void update() {
		
	}

	@Override
	public boolean keyDown(int keycode) {
		switch (keycode) {
		case Keys.F1:
			isDebug = !isDebug;
			break;
		case Keys.ESCAPE:
			scene.setNewState(GameState.INGAMEMENU);
			break;
		default:
			return false;
		}
		return true;
	}
	
	@Override
	public boolean keyUp(int keycode) {
		return false;
	}
	
	@Override
	public boolean scrolled(int amount) {
		return false;
	}
	
	private void drawDebugInfo()
	{
		debugPosition.y = Gdx.graphics.getHeight() - debugPosition.x;
		
				
		userInterfaceBatch.setProjectionMatrix(normalProjection);
		
		
		userInterfaceBatch.begin();
		
		userInterfaceBatch.draw(debugTexture, debugPosition.x - 10, debugPosition.y - 90);
				
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
