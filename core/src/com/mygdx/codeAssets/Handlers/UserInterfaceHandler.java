package com.mygdx.codeAssets.Handlers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class UserInterfaceHandler {
	
	
	
	
	public UserInterfaceHandler() {

	}
	
	
	
	public abstract void touchDown(int a_screenX, int a_screenY, int a_button);
	
	public abstract void touchUp(int a_screenX, int a_screenY, int a_button);
	
	public abstract void draw(SpriteBatch a_batch);
	
	public abstract void mouseMoved(int a_screenX, int a_screenY);
	

}
