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
		if (!userInterfaceHandler.keyDown(keycode))
			if(!playerHandler.keyDown(keycode))
				return false; //input not handled
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		if(!userInterfaceHandler.keyUp(keycode))
			if(!playerHandler.keyUp(keycode))
				return false; //input not handled
		return true;
	}
	
	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		
		if(!userInterfaceHandler.mouseMoved(screenX, screenY))
			if(!playerHandler.mouseMoved(screenX, screenY))
				return false; //input not handled
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
