package com.mygdx.codeAssets.Objects;



public class Weapon extends Item{
	
	protected final float damageValue;
	protected final float attackSpeed;
	protected final boolean isTwoHanded;
	protected boolean isAttacking;
	protected int milliSeconds;
	
	public Weapon(String a_itemName, float a_damageValue, float a_attackSpeed, boolean a_isTwoHanded) {
		super(a_itemName);
		
		damageValue = a_damageValue;
		attackSpeed = a_attackSpeed;
		isTwoHanded = a_isTwoHanded;
		isAttacking = false;
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

}
