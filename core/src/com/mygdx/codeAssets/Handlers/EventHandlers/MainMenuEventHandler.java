package com.mygdx.codeAssets.Handlers.EventHandlers;

import com.mygdx.codeAssets.Handlers.EventHandler;
import com.mygdx.codeAssets.Handlers.RenderHandler;
import com.mygdx.codeAssets.Handlers.UserInterfaceHandler;

public class MainMenuEventHandler extends EventHandler {

	
	
	public MainMenuEventHandler(RenderHandler a_renderHandler, UserInterfaceHandler a_userInterfaceHandler) {
		super(a_renderHandler, a_userInterfaceHandler);

	}
	
	
	@Override
	public boolean keyDown(int keycode) {
		return super.keyDown(keycode);
	}
	
	@Override
	public boolean keyUp(int keycode) {
		return super.keyUp(keycode);
	}
	
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		userInterfaceHandler.touchDown(screenX, screenY, button);

		return super.touchDown(screenX, screenY, pointer, button);
	}
	
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		userInterfaceHandler.touchUp(screenX, screenY, button);

		return super.touchUp(screenX, screenY, pointer, button);
	}
	
	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		userInterfaceHandler.mouseMoved(screenX, screenY);
		
		return super.mouseMoved(screenX, screenY);
	}
	
}
