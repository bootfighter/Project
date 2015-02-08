package com.mygdx.codeAssets.Handlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.mygdx.codeAssets.Objects.UIElement;

public abstract class UserInterfaceHandler {
	
	
	protected UIElement[] elements;
	protected SpriteBatch userInterfaceBatch;
	protected Matrix4 normalProjection;
	public boolean isDebug;
	
	public UserInterfaceHandler() {
		userInterfaceBatch = new SpriteBatch();
		elements = new UIElement[0];
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
	
	public void resize(){
		normalProjection = new Matrix4().setToOrtho2D(0, 0, Gdx.graphics.getWidth(),  Gdx.graphics.getHeight());
		userInterfaceBatch.setProjectionMatrix(normalProjection);
		
	}
}
