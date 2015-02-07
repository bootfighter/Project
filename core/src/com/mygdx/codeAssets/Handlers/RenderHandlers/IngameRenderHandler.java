package com.mygdx.codeAssets.Handlers.RenderHandlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.codeAssets.Handlers.MapHandler;
import com.mygdx.codeAssets.Handlers.PlayerHandler;
import com.mygdx.codeAssets.Handlers.RenderHandler;
import com.mygdx.codeAssets.Handlers.UserInterfaceHandler;

public class IngameRenderHandler extends RenderHandler{


	PlayerHandler playerHandler;
	MapHandler mapHandler;

	
	
	private BitmapFont debugFont;
	SpriteBatch debugBatch;
	Matrix4 normalProjection;
	Vector2 debugPosition;

	
	public IngameRenderHandler(MapHandler a_mapHandler, PlayerHandler a_playerHandler, UserInterfaceHandler a_userInterfaceHandler, SpriteBatch a_batch) {
	
		super(a_userInterfaceHandler, a_batch);
		
		playerHandler = a_playerHandler;
		mapHandler = a_mapHandler;
		
		debugFont = new BitmapFont();
		debugFont.setColor(Color.WHITE);
		debugBatch = new SpriteBatch();
		normalProjection = new Matrix4();
		debugPosition = new Vector2(10,0);
	
	}
	
	public void zoom(int a_deltaZoom) {
		if (orthoCamera.zoom + a_deltaZoom * 0.1f <= 1.3f && orthoCamera.zoom + a_deltaZoom * 0.1f >= 0.0f) {
			orthoCamera.zoom += a_deltaZoom * 0.1f;
		}
	}
	
	
	public void draw()
	{
		orthoCamera.position.set(new Vector2(playerHandler.player.position.x + playerHandler.player.collisionDimension.x / 2 , 
				 playerHandler.player.position.y + playerHandler.player.collisionDimension.y / 2 ), 0f);
		super.draw();
				
		userInterfaceHandler.draw(batch);
		mapHandler.draw(batch, orthoCamera.zoom, playerHandler.player.position);
		playerHandler.draw(batch);
		
		if (isDebug)
			this.drawDebugInfo();
		
	}
	
	private void drawDebugInfo()
	{
		normalProjection = new Matrix4().setToOrtho2D(0, 0, Gdx.graphics.getWidth(),  Gdx.graphics.getHeight());
		debugPosition.y = Gdx.graphics.getHeight() - debugPosition.x;
		
		debugBatch.setProjectionMatrix(normalProjection);
		debugBatch.begin();
		
				
		debugFont.draw(debugBatch, "FPS: " + Gdx.graphics.getFramesPerSecond(), debugPosition.x , debugPosition.y);
		debugFont.draw(debugBatch, "XYZ: " 
				+ String.format("%.2f", playerHandler.player.position.x) + " | " 
				+ String.format("%.2f", playerHandler.player.position.y) + " | "  
				+ String.format("%.2f", playerHandler.player.position.z), debugPosition.x, debugPosition.y - debugFont.getLineHeight() - 2);
		debugFont.draw(debugBatch, "t-XYZ: " 
				+ String.format("%.0f", playerHandler.player.tilePosition.x) + " | "   
				+ String.format("%.0f", playerHandler.player.tilePosition.y) + " | "  
				+ String.format("%.0f", playerHandler.player.tilePosition.z), debugPosition.x, debugPosition.y - (2 * debugFont.getLineHeight()) - 2);
		debugFont.draw(debugBatch, "Facing: "  + String.format("%2.0f", playerHandler.player.getFacingDirection().x)
				+ String.format("%2.0f", playerHandler.player.getFacingDirection().y), debugPosition.x, debugPosition.y - (3 * debugFont.getLineHeight())- 2);
		
		debugBatch.end();
	}
	
}
