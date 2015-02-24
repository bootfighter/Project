package com.mygdx.codeAssets.Scenes.CreditsScene;

import com.mygdx.codeAssets.Handlers.EventHandler;
import com.mygdx.codeAssets.Handlers.RenderHandler;
import com.mygdx.codeAssets.Handlers.UserInterfaceHandler;
import com.mygdx.codeAssets.Scenes.SceneAbstract;

public class CreditsEventHandler extends EventHandler{

	
	public CreditsEventHandler(RenderHandler a_renderHandler, UserInterfaceHandler a_userInterfaceHandler, SceneAbstract a_scene) {
		super(a_renderHandler, a_userInterfaceHandler, a_scene);
		
	}
	
	@Override
	public boolean keyDown(int keycode) {
		userInterfaceHandler.keyDown(keycode);
		return super.keyDown(keycode);
	}
}
