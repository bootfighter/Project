package com.mygdx.codeAssets.Handlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.codeAssets.Objects.GameMap;

public class RenderHandler {
	
	SpriteBatch batch;

	OrthographicCamera orthoCamera;
	
	PlayerHandler playerHandler;
	MapHandler mapHandler;
	
	GameMap currentMap;
	
	public RenderHandler(MapHandler a_mapHandler, PlayerHandler a_playerHandler, SpriteBatch a_batch){
		mapHandler = a_mapHandler;
		playerHandler = a_playerHandler;
		batch = a_batch;
		orthoCamera = new OrthographicCamera(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		orthoCamera.position.set(new Vector3(0,0,0));
		orthoCamera.update();
	}
	
	
	public void zoom(int a_deltaZoom) {
		if (orthoCamera.zoom + a_deltaZoom * 0.1f <= 2f && orthoCamera.zoom + a_deltaZoom * 0.1f >= 0.5f) {
			orthoCamera.zoom += a_deltaZoom * 0.1f;
		}
		
	}
	
	
	public void draw() {
		
		orthoCamera.position.set(new Vector2(playerHandler.position.x, playerHandler.position.y), 0f);
		orthoCamera.update();
		currentMap = mapHandler.getCurrentMap();
		
		batch.setProjectionMatrix(orthoCamera.combined);
		
		
		currentMap.draw(batch);
		playerHandler.draw(batch);
		
	}	
	
	
	

}
