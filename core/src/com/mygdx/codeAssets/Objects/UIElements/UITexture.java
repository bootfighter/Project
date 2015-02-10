package com.mygdx.codeAssets.Objects.UIElements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.codeAssets.Objects.UIElement;

public class UITexture extends UIElement{

	Texture texture;
	
	public UITexture(Texture a_texture) {
		super();
		texture = a_texture;
		width = texture.getWidth();
		height = texture.getHeight();
	}

	
	@Override
	public void touchDown(int a_screenX, int a_screenY, int a_button) {
		
		
		if (!isHover) //mouse is not over element
			return;
		isPressed = true;

	}


	@Override
	public void touchUp(int a_screenX, int a_screenY, int a_button) {
		if (!isHover) //mouse is not over element
			return;
		isPressed = false;
	}


	@Override
	public void mouseMoved(int a_screenX, int a_screenY) {
		a_screenY = Gdx.graphics.getHeight() - a_screenY;
		if (a_screenX < position.x || a_screenX > position.x + width ||
				a_screenY < position.y || a_screenY > position.y + height){
			isHover = false;
			return;
		}
		isHover = true;
	}

	@Override
	public void draw(SpriteBatch a_batch) {
		a_batch.begin();
		
		a_batch.draw(texture, position.x, position.y);
		
		a_batch.end();
	}
	
	@Override
	public void resize(int a_width, int a_height) {
		// TODO Auto-generated method stub
		
	}
}
