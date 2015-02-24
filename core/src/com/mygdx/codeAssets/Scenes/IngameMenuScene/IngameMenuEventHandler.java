package com.mygdx.codeAssets.Scenes.IngameMenuScene;

import com.mygdx.codeAssets.Handlers.EventHandler;
import com.mygdx.codeAssets.Handlers.RenderHandler;
import com.mygdx.codeAssets.Handlers.UserInterfaceHandler;
import com.mygdx.codeAssets.Scenes.SceneAbstract;

public class IngameMenuEventHandler extends EventHandler {

	public IngameMenuEventHandler(RenderHandler a_renderHandler, UserInterfaceHandler a_userInterfaceHandler, SceneAbstract a_scene) {
		super(a_renderHandler, a_userInterfaceHandler, a_scene);
		
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {

		if(userInterfaceHandler.touchDown(screenX, screenY, button))
			return true;
		
		return false;
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
	
	@Override
	public boolean keyDown(int keycode) {
		
		if(userInterfaceHandler.keyDown(keycode))
			return true;
		
		return false;
	}
	
}
