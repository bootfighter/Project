package com.mygdx.codeAssets.Handlers;

import com.badlogic.gdx.InputProcessor;


public class EventHandler implements InputProcessor {

	
	protected RenderHandler renderHandler;
	protected UserInterfaceHandler userInterfaceHandler;
	
	
	public EventHandler(RenderHandler a_renderHandler, UserInterfaceHandler a_userInterfaceHandler){
		
		renderHandler = a_renderHandler;
		userInterfaceHandler = a_userInterfaceHandler;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		
		return true;
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
