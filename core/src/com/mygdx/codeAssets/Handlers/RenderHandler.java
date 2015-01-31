package com.mygdx.codeAssets.Handlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.codeAssets.Objects.GameMap;

public class RenderHandler {
	
	SpriteBatch batch;

	OrthographicCamera orthoCamera;
	
	PlayerHandler playerHandler;
	MapHandler mapHandler;
	
	GameMap currentMap;
	
	private BitmapFont debugFont;
	SpriteBatch debugBatch;
	Matrix4 normalProjection;
	Vector2 debugPosition;
	public boolean isDebug;

	
	public RenderHandler(MapHandler a_mapHandler, PlayerHandler a_playerHandler, SpriteBatch a_batch){
		mapHandler = a_mapHandler;
		playerHandler = a_playerHandler;
		batch = a_batch;
		
		isDebug = false;
		debugFont = new BitmapFont();
		debugFont.setColor(Color.WHITE);
		debugBatch = new SpriteBatch();
		normalProjection = new Matrix4();
		debugPosition = new Vector2(10,0);
		
		orthoCamera = new OrthographicCamera(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		orthoCamera.position.set(new Vector3(0,0,0));
		orthoCamera.update();
	}
	
	

	public void zoom(int a_deltaZoom) {
		if (orthoCamera.zoom + a_deltaZoom * 0.1f <= 1.3f && orthoCamera.zoom + a_deltaZoom * 0.1f >= 0.0f) {
			orthoCamera.zoom += a_deltaZoom * 0.1f;
		}
	}
	
	public void resize(int a_XSize, int a_YSize) {
		orthoCamera.viewportHeight = a_YSize;
		orthoCamera.viewportWidth = a_XSize;
	}
	
	public void draw() {
		
		orthoCamera.position.set(new Vector2(playerHandler.player.position.x, playerHandler.player.position.y), 0f);
		orthoCamera.update();
		
		
		
		
		batch.setProjectionMatrix(orthoCamera.combined);
		
		
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
		//System.out.println((Gdx.graphics.getHeight() - 30));
		debugBatch.end();
	}
	

}
