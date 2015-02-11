package com.mygdx.codeAssets.Handlers.EventHandlers;

import com.mygdx.codeAssets.Handlers.EventHandler;
import com.mygdx.codeAssets.Handlers.MapHandler;
import com.mygdx.codeAssets.Handlers.PlayerHandler;
import com.mygdx.codeAssets.Handlers.RenderHandler;
import com.mygdx.codeAssets.Handlers.UserInterfaceHandler;

public class IngameEventHandler extends EventHandler {

	MapHandler mapHandler;
	PlayerHandler playerHandler;

	
	public IngameEventHandler(MapHandler a_mapHandler, PlayerHandler a_playerHandler,RenderHandler a_renderHandler, UserInterfaceHandler a_userInterfaceHandler) {
		super(a_renderHandler, a_userInterfaceHandler);
		
		mapHandler = a_mapHandler;
		playerHandler = a_playerHandler;
	}
	
	@Override
	public boolean keyDown(int keycode) {

		playerHandler.keyDown(keycode);
		userInterfaceHandler.keyDown(keycode);
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		
		playerHandler.keyUp(keycode);
		userInterfaceHandler.keyUp(keycode);

		return true;
	}
	
	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		
		playerHandler.mouseMoved(screenX, screenY);
		userInterfaceHandler.mouseMoved(screenX, screenY);
		
		return true;
	}

	
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		
		userInterfaceHandler.touchDown(screenX, screenY, button);

		return true;
	}
	
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		
		userInterfaceHandler.touchUp(screenX, screenY, button);
		
		return true;
	}
	
	
	@Override
	public boolean scrolled(int amount) {
		renderHandler.zoom(amount);
		return false;
	}
	
}
