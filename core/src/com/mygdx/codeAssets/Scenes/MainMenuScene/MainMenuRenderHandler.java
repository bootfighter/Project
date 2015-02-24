package com.mygdx.codeAssets.Scenes.MainMenuScene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.codeAssets.Handlers.RenderHandler;
import com.mygdx.codeAssets.Handlers.UserInterfaceHandler;
import com.mygdx.codeAssets.Scenes.SceneAbstract;

public class MainMenuRenderHandler extends RenderHandler{

	
	public MainMenuRenderHandler(UserInterfaceHandler a_userInterfaceHandler, SpriteBatch a_batch, SceneAbstract a_scene) {
	
		super(a_userInterfaceHandler, a_batch, a_scene);
		
		orthoCamera.position.set(new Vector3(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 0));
	}
	
	@Override
	public void draw() {
		userInterfaceHandler.draw();
		super.draw();
	}

	@Override
	public void resize(int a_XSize, int a_YSize) {
		userInterfaceHandler.resize(a_XSize, a_YSize);
		super.resize(a_XSize, a_YSize);
	}
}
