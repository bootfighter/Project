package com.mygdx.codeAssets.Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class Item {

	protected Sprite sprite;
	protected final String itemName;
	
	public Item(String a_itemName) {
		//TODO: write function to load texture with identifier number. For now missingtxt
		itemName = a_itemName;
		try {
			sprite = new Sprite(new Texture(itemName + ".png"));
		} catch (Exception e) {
			sprite = new Sprite(new Texture("missingtxt.png"));
		}
	}
	
	
	public Sprite getTexture() {
		return sprite;
	}
	
	public void leftClickAction (GameMap a_map){
	}
	
	public void rightClickAction (GameMap a_map){
	}
}
