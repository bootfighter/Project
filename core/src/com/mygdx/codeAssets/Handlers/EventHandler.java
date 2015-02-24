package com.mygdx.codeAssets.Handlers;

import com.badlogic.gdx.InputProcessor;
import com.mygdx.codeAssets.Scenes.SceneAbstract;


public abstract class EventHandler implements InputProcessor {

	
	protected RenderHandler renderHandler;
	protected UserInterfaceHandler userInterfaceHandler;
	protected SceneAbstract scene;
	
	
	public EventHandler(RenderHandler a_renderHandler, UserInterfaceHandler a_userInterfaceHandler, SceneAbstract a_scene){
		
		renderHandler = a_renderHandler;
		userInterfaceHandler = a_userInterfaceHandler;
		scene = a_scene;
	}
	
	public void setUIHandler(UserInterfaceHandler a_uiHandler){
		userInterfaceHandler = a_uiHandler;
	}
	
	public void setRenderHandler(RenderHandler a_renderHandler){
		renderHandler = a_renderHandler;
	}
	
	
	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return true;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
		
}
