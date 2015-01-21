package com.mygdx.game;

public class GameParameters {
	
	
	//NOT final version of all gamestates, these are just a collection of possible states
	public static enum Gamestate{
		STARTUPMENU,
		INGAMEMENU,
		INGAME, 
		INVENTORY, 
		NPCINTERACTION,
		CUTSCENE
	}
	
	public static final int tileSize = 16; //size of side-lenght of quadratic tiles in pixel
	public static final float collisionIteration = 1.0f;
	
}
