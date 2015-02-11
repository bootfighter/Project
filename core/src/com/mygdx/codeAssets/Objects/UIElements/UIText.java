package com.mygdx.codeAssets.Objects.UIElements;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.codeAssets.Objects.UIElement;

public class UIText extends UIElement {

	private String text;
	private BitmapFont font;
	private BitmapFont.TextBounds bounds;
	
	public UIText(String a_text, BitmapFont a_font) {
		super();
		text = a_text;
		font = a_font;
		bounds = font.getBounds(text);
		width = (int)bounds.width;
		height = (int)bounds.height;
	}
	
	
	@Override
	public void draw(SpriteBatch a_batch) {
		a_batch.begin();
		
		font.draw(a_batch, text, position.x, position.y);
		
		a_batch.end();
	}
	
	@Override
	public void mouseMoved(int a_screenX, int a_screenY) {
		
	}
	
	@Override
	public void touchDown(int a_screenX, int a_screenY, int a_button) {
		
	}
	
	@Override
	public void touchUp(int a_screenX, int a_screenY, int a_button) {
		
	}
	
	@Override
	public void resize(int a_width, int a_height) {
		
	}
}
