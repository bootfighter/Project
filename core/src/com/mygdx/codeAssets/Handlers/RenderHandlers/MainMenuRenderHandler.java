package com.mygdx.codeAssets.Handlers.RenderHandlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.codeAssets.Handlers.RenderHandler;
import com.mygdx.codeAssets.Handlers.UserInterfaceHandler;

public class MainMenuRenderHandler extends RenderHandler{

	
	public MainMenuRenderHandler(UserInterfaceHandler a_userInterfaceHandler, SpriteBatch a_batch) {
	
		super(a_userInterfaceHandler, a_batch);
		
		orthoCamera.position.set(new Vector3(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 0));
	}
	
	@Override
	public void draw() {
		userInterfaceHandler.draw();
		super.draw();
	}

}
