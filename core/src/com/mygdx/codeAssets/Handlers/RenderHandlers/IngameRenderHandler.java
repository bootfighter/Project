package com.mygdx.codeAssets.Handlers.RenderHandlers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.codeAssets.Handlers.MapHandler;
import com.mygdx.codeAssets.Handlers.PlayerHandler;
import com.mygdx.codeAssets.Handlers.RenderHandler;
import com.mygdx.codeAssets.Handlers.UserInterfaceHandler;

public class IngameRenderHandler extends RenderHandler{


	PlayerHandler playerHandler;
	MapHandler mapHandler;
	
	public IngameRenderHandler(MapHandler a_mapHandler, PlayerHandler a_playerHandler, UserInterfaceHandler a_userInterfaceHandler, SpriteBatch a_batch) {
	
		super(a_userInterfaceHandler, a_batch);
		
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
				
		userInterfaceHandler.draw();
		mapHandler.draw(batch, orthoCamera.zoom, playerHandler.player.position);
		playerHandler.draw(batch);		
	}
	
	
}
