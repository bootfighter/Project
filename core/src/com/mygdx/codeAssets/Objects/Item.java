package com.mygdx.codeAssets.Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class Item {

	private Sprite texture;
	protected final String itemName;
	
	public Item(String a_itemName) {
		//TODO: write function to load texture with identifier number. For now missingtxt
		itemName = a_itemName;
		try {
			texture = new Sprite(new Texture(itemName + ".png"));
		} catch (Exception e) {
			texture = new Sprite(new Texture("missingtxt.png"));
		}
	}
	
	
	public Sprite getTexture() {
		return texture;
	}
	
	public void leftClickAction (){
	}
	
	public void rightClickAction (){
	}
}
