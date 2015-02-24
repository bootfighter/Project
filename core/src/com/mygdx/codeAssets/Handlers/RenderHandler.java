package com.mygdx.codeAssets.Handlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.codeAssets.Scenes.SceneAbstract;

public abstract class RenderHandler {
	
	protected SpriteBatch batch;
	protected OrthographicCamera orthoCamera;
	protected UserInterfaceHandler userInterfaceHandler;
	protected SceneAbstract scene;
	public boolean isDebug;
	
	public RenderHandler(UserInterfaceHandler a_userInterfaceHandler, SpriteBatch a_batch, SceneAbstract a_scene){
		
		userInterfaceHandler = a_userInterfaceHandler;
		scene = a_scene;
		batch = a_batch;
		isDebug = false;
		
		orthoCamera = new OrthographicCamera(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		orthoCamera.viewportHeight =  Gdx.graphics.getHeight();
		orthoCamera.viewportWidth = Gdx.graphics.getWidth();
		orthoCamera.position.set(new Vector3(0,0,0));
		orthoCamera.update();
		batch.setProjectionMatrix(orthoCamera.combined);
	}

	public void setUIHandler(UserInterfaceHandler a_uiHandler){
		userInterfaceHandler = a_uiHandler;
	}
	
	public void resize(int a_XSize, int a_YSize) {
		userInterfaceHandler.resize(a_XSize, a_YSize);
		orthoCamera.viewportHeight = a_YSize;
		orthoCamera.viewportWidth = a_XSize;
	}
	
	public void draw() {
		
		orthoCamera.update();
		batch.setProjectionMatrix(orthoCamera.combined);
		
	}	
	
	public void zoom(int a_deltaZoom){
		
		
	}
}
