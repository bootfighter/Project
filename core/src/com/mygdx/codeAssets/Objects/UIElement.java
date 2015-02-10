package com.mygdx.codeAssets.Objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class UIElement {

	protected int height;
	protected int width;
	protected Vector2 position;
	protected boolean isPressed;
	protected boolean isHover;
	
	public UIElement() {
		height = 0;
		width = 0;
		position = new Vector2(0,0);
		isPressed = false;
		isHover = false;
	}
	
	public void setCenter(Vector2 a_center){
		position.x = a_center.x - width / 2;
		position.y = a_center.y - height / 2;
	}
	
	public void setPosition(Vector2 a_position){
		position = new Vector2(a_position);
	}

	public boolean isPressed() {
		return isPressed;
	}
	
	public boolean isHover() {
		return isHover;
	}
	
	public int getHeight(){
		return height;
	}

	public int getWidth(){
		return width;
	}
	
	public abstract void touchDown(int a_screenX, int a_screenY, int a_button);
	
	public abstract void touchUp(int a_screenX, int a_screenY, int a_button);
	
	public abstract void mouseMoved(int a_screenX, int a_screenY);
	
	public abstract void draw(SpriteBatch a_batch);
	
	public abstract void resize(int a_width, int a_height);
}
