package com.mygdx.codeAssets.Handlers.UserInterfaceHandlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.codeAssets.Handlers.PlayerHandler;
import com.mygdx.codeAssets.Handlers.UserInterfaceHandler;

public class IngameUIHandler extends UserInterfaceHandler{

	PlayerHandler playerHandler;
	Vector2 debugPosition;
	BitmapFont debugFont;
	
	public IngameUIHandler(PlayerHandler a_playerHandler) {
		super();
		playerHandler = a_playerHandler;
		debugPosition = new Vector2(10,0);
		debugFont = new BitmapFont();
		debugFont.setColor(Color.WHITE);
	}
	
	
	@Override
	public void touchDown(int a_screenX, int a_screenY, int a_button) {
		
		
	}
	
	@Override
	public void touchUp(int a_screenX, int a_screenY, int a_button) {
			
	}
	
	
	@Override
	public void mouseMoved(int a_screenX, int a_screenY) {
		
	}
	
	
	@Override
	public void draw() {
		if (isDebug)
			drawDebugInfo();
		super.draw();
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
