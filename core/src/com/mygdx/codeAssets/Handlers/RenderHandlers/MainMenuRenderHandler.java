package com.mygdx.codeAssets.Handlers.RenderHandlers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.codeAssets.Handlers.RenderHandler;
import com.mygdx.codeAssets.Handlers.UserInterfaceHandler;

public class MainMenuRenderHandler extends RenderHandler{

	
	public MainMenuRenderHandler(UserInterfaceHandler a_userInterfaceHandler, SpriteBatch a_batch) {
	
		super(a_userInterfaceHandler, a_batch);
	
	}
	
	@Override
	public void draw() {
		
		
		//TODO: background and stuff
		userInterfaceHandler.draw(batch);

		super.draw();
	}
}
