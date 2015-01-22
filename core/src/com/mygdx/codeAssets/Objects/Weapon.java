package com.mygdx.codeAssets.Objects;

public class Weapon extends Item{
	
	protected final float damageValue;
	protected final float attackSpeed;
	protected final boolean isTwoHanded;
	
	public Weapon(String a_itemName, float a_damageValue, float a_attackSpeed, boolean a_isTwoHanded) {
		super(a_itemName);
		
		damageValue = a_damageValue;
		attackSpeed = a_attackSpeed;
		isTwoHanded = a_isTwoHanded;
	}
	
	@Override
	public void leftClickAction() {
		// TODO Auto-generated method stub
		super.leftClickAction();
	}

}
