package com.mygdx.codeAssets.Handlers.EventHandlers;

import com.mygdx.codeAssets.Handlers.EventHandler;
import com.mygdx.codeAssets.Handlers.RenderHandler;
import com.mygdx.codeAssets.Handlers.UserInterfaceHandler;

public class CreditsEventHandler extends EventHandler{

	
	public CreditsEventHandler(RenderHandler a_renderHandler, UserInterfaceHandler a_userInterfaceHandler) {
		super(a_renderHandler, a_userInterfaceHandler);
		
	}
	
	@Override
	public boolean keyDown(int keycode) {
		userInterfaceHandler.keyDown(keycode);
		return super.keyDown(keycode);
	}
}
