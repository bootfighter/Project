package com.mygdx.codeAssets.Objects.Weapons;

import com.mygdx.codeAssets.Objects.Weapon;

public class Dagger extends Weapon{

	
	
	
	public Dagger(String a_itemName, float a_damageValue, float a_attackSpeed, boolean a_isTwoHanded) {
		super(a_itemName, a_damageValue, a_attackSpeed, a_isTwoHanded);
		
		sprite.setCenter(14, 6);
		sprite.setOrigin(14, 6);
		sprite.setScale(0.4f, 0.4f);
		
		setState0();
		//offset = new Vector2(0,8);
		
	}
	
	private void setState0(){
		sprite.setRotation(-45f);
		
	}
	private void setState1(){
		
		
		
	}
	
	
	
}
