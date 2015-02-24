package com.mygdx.codeAssets.Scenes.IngameScene;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.codeAssets.Handlers.MapHandler;
import com.mygdx.codeAssets.Handlers.PlayerHandler;
import com.mygdx.codeAssets.Handlers.RenderHandler;
import com.mygdx.codeAssets.Handlers.UserInterfaceHandler;
import com.mygdx.codeAssets.Scenes.SceneAbstract;

public class IngameRenderHandler extends RenderHandler{


	PlayerHandler playerHandler;
	MapHandler mapHandler;
	
	public IngameRenderHandler(MapHandler a_mapHandler, PlayerHandler a_playerHandler, UserInterfaceHandler a_userInterfaceHandler, 
								SpriteBatch a_batch, SceneAbstract a_scene) {
	
		super(a_userInterfaceHandler, a_batch, a_scene);
		
		playerHandler = a_playerHandler;
		mapHandler = a_mapHandler;
		
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
				
		mapHandler.draw(batch, orthoCamera.zoom, playerHandler.player.position);
		playerHandler.draw(batch);
		userInterfaceHandler.draw();
	}
	
	@Override
	public void resize(int a_XSize, int a_YSize) {
		userInterfaceHandler.resize(a_XSize, a_YSize);
		super.resize(a_XSize, a_YSize);
	}
	
}
