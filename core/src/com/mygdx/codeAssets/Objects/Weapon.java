package com.mygdx.codeAssets.Objects;

import com.badlogic.gdx.math.Vector2;


public class Weapon extends Item{
	
	protected final float damageValue;
	protected final float attackSpeed;
	protected final boolean isTwoHanded;
	protected float rotation;
	protected int milliSeconds;
	protected Vector2 offset;
	
	public Weapon(String a_itemName, float a_damageValue, float a_attackSpeed, boolean a_isTwoHanded) {
		super(a_itemName);
		
		damageValue = a_damageValue;
		attackSpeed = a_attackSpeed;
		isTwoHanded = a_isTwoHanded;
		milliSeconds = 0;
	}
	
	@Override
	public void leftClickAction(GameMap a_map) {
		super.leftClickAction(a_map);
	}
	
	@Override
	public void rightClickAction(GameMap a_map) {
		super.rightClickAction(a_map);
	}
	
	public Vector2 getOffset() {
		return offset;
	}

}
