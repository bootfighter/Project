package com.mygdx.codeAssets.Handlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class RenderHandler {
	
	protected SpriteBatch batch;
	protected OrthographicCamera orthoCamera;
	protected UserInterfaceHandler userInterfaceHandler;
	public boolean isDebug;
	
	public RenderHandler(UserInterfaceHandler a_userInterfaceHandler, SpriteBatch a_batch){
		
		userInterfaceHandler = a_userInterfaceHandler;
		batch = a_batch;
		isDebug = false;
		
		orthoCamera = new OrthographicCamera(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		orthoCamera.position.set(new Vector3(0,0,0));
		orthoCamera.update();
	}

	
	public void resize(int a_XSize, int a_YSize) {
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
