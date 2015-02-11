package com.mygdx.codeAssets.Handlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.mygdx.codeAssets.Objects.GameStateMutable;
import com.mygdx.codeAssets.Objects.UIElement;

public abstract class UserInterfaceHandler {
	
	
	protected UIElement[] elements;
	protected SpriteBatch userInterfaceBatch;
	protected Matrix4 normalProjection;
	protected GameStateMutable currentGameState;
	public boolean isDebug;
	
	public UserInterfaceHandler(GameStateMutable a_currentGameState) {
		userInterfaceBatch = new SpriteBatch();
		elements = new UIElement[0];
		currentGameState = a_currentGameState;
		normalProjection = new Matrix4().setToOrtho2D(0, 0, Gdx.graphics.getWidth(),  Gdx.graphics.getHeight());
		isDebug = false;
	}
	
	public void touchDown(int a_screenX, int a_screenY, int a_button){
		for (UIElement uiElement : elements) {
			uiElement.touchDown(a_screenX, a_screenY, a_button);
		}		
	}
	
	public void touchUp(int a_screenX, int a_screenY, int a_button){
		for (UIElement uiElement : elements) {
			uiElement.touchUp(a_screenX, a_screenY, a_button);
		}
	}

	public void mouseMoved(int a_screenX, int a_screenY){
		for (UIElement uiElement : elements) {
			uiElement.mouseMoved(a_screenX, a_screenY);
		}		
	}
	
	public void draw(){
		for (UIElement uiElement : elements) {
			uiElement.draw(userInterfaceBatch);
		}
	}
	
	public abstract void keyDown(int keycode);
	
	public abstract void keyUp(int keycode);
	
	protected abstract void setElementPositions(int a_width, int a_height);
	
	public void resize(int a_width, int a_height){
		setElementPositions(a_width, a_height);
		normalProjection = new Matrix4().setToOrtho2D(0, 0, Gdx.graphics.getWidth(),  Gdx.graphics.getHeight());
		userInterfaceBatch.setProjectionMatrix(normalProjection);
	}
}
