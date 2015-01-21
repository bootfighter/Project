package com.mygdx.codeAssets.Objects;

public class Inventory {

	
	Item[] itemList;
	
	public Inventory(int a_inventorySize) {
		itemList = new Item[a_inventorySize];
	}
	
	
	
	
	
	public Item getItemAtIndex(int a_index) {
		return itemList[a_index];
	}

	public void swapItem(int a_indexFrom, int a_indexTo) {
		Item tempItem = itemList[a_indexTo];
		itemList[a_indexTo] = itemList[a_indexFrom];
		itemList[a_indexFrom] = tempItem;
	}
	
	
	
	
	
	
}
