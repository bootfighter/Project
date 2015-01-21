package com.mygdx.codeAssets.Objects;

import com.badlogic.gdx.graphics.Texture;

public class Item {

	private Texture texture;
	protected int id;
	
	public Item(int id) {
		//TODO: write function to load texture with identifier number. For now missingtxt
		texture = new Texture("missingtxt.png");
	}
	
	
	public Texture getTexture() {
		return texture;
	}
	
}
