package com.mygdx.codeAssets.Objects.UIElements;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class UITexture extends UIElementClickable{

	private Texture texture;
	
	public UITexture(Texture a_texture) {
		super();
		texture = a_texture;
		width = texture.getWidth();
		height = texture.getHeight();
	}

	
	@Override
	public boolean touchDown(int a_screenX, int a_screenY, int a_button) {
		return super.touchDown(a_screenX, a_screenY, a_button);
	}


	@Override
	public boolean touchUp(int a_screenX, int a_screenY, int a_button) {
		return super.touchUp(a_screenX, a_screenY, a_button);
	}


	@Override
	public boolean mouseMoved(int a_screenX, int a_screenY) {
		return super.mouseMoved(a_screenX, a_screenY);
	}
	
	@Override
	public void draw(SpriteBatch a_batch) {
		a_batch.begin();
		
		a_batch.draw(texture, position.x, position.y);
		
		a_batch.end();
	}
	
	@Override
	public void resize(int a_width, int a_height) {
		
	}
}
