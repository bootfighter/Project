package com.mygdx.codeAssets.Objects.UIElements;

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
	}

	@Override
	public void touchUp(int a_screenX, int a_screenY, int a_button) {		
	}

	@Override
	public void mouseMoved(int a_screenX, int a_screenY) {		
	}

	@Override
	public void draw(SpriteBatch a_batch) {
		a_batch.begin();
		
		a_batch.draw(texture, position.x, position.y);
		
		a_batch.end();
	}
}
