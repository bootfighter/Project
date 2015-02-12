package com.mygdx.codeAssets.Objects.UIElements;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class UIButton extends UIElementClickable{

	private Texture texture;
	private Texture texturePressed;
	private BitmapFont.TextBounds bounds;
	private BitmapFont font;
	private String text;

	
 	public UIButton(String a_buttonName, String a_buttonText, BitmapFont a_font) {
		
		super();
		try{
			texture = new Texture("UIElements/Buttons/" + a_buttonName + ".png");
			texturePressed = new Texture("UIElements/Buttons/" + a_buttonName + "_pressed.png");
		}catch(Exception e){
			texture = new Texture("missingtxt.png");
			texturePressed = new Texture("missingtxt.png");
		}
		width = texture.getWidth();
		height = texture.getHeight();
		
		text = a_buttonText;
		font = a_font;
		bounds = new BitmapFont.TextBounds(font.getBounds(text));

	}
	
	
	public void draw(SpriteBatch a_batch){
		
		a_batch.begin();
		
		if (isPressed)
			a_batch.draw(texturePressed, position.x, position.y);
		else
			a_batch.draw(texture, position.x, position.y);
		
		font.draw(a_batch, text, position.x + (width / 2) - (bounds.width / 2), position.y + (height / 2) + (bounds.height / 2));
				
		a_batch.end();
	}

	

	@Override
	public boolean touchDown(int a_screenX, int a_screenY, int a_button) {
		mouseMoved(a_screenX, a_screenY);
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
	public void resize(int a_width, int a_height) {
		
	}
}
