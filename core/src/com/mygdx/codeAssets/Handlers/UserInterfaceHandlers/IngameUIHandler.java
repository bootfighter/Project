package com.mygdx.codeAssets.Handlers.UserInterfaceHandlers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.codeAssets.Handlers.PlayerHandler;
import com.mygdx.codeAssets.Handlers.UserInterfaceHandler;

public class IngameUIHandler extends UserInterfaceHandler{

	PlayerHandler playerHandler;
		
	public IngameUIHandler(PlayerHandler a_playerHandler) {
		super();
		playerHandler = a_playerHandler;
		
	}
	
	
	@Override
	public void touchDown(int a_screenX, int a_screenY, int a_button) {
		
		
	}
	
	@Override
	public void touchUp(int a_screenX, int a_screenY, int a_button) {
			
	}
	
	@Override
	public void draw(SpriteBatch a_batch) {
		
		
	}
	
	@Override
	public void mouseMoved(int a_screenX, int a_screenY) {
		
	}
}
