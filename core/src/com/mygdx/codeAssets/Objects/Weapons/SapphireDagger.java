package com.mygdx.codeAssets.Objects.Weapons;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.codeAssets.Objects.GameMap;
import com.mygdx.codeAssets.Objects.Weapon;

public class SapphireDagger extends Weapon{

	public SapphireDagger() {
		super("Weapons/SapphireDagger", 1f, 1f, false);
		rotation = 90;
		sprite.setCenter(14, 6);
		sprite.setOrigin(14, 6);
		sprite.setScale(0.4f, 0.4f);
		sprite.setRotation(-45f);
		offset = new Vector2(0,8);
		
	}
	
	@Override
	public void leftClickAction(GameMap a_map) {
		super.leftClickAction(a_map);
		
		
		
		
		
		
		}
	
}
