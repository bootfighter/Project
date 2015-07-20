package com.mygdx.game;

public class GameParameters {
	
		
	public static enum Direction {
		NORTH,
		EAST,
		SOUTH,
		WEST
	}
	
	
	public static final int tileSize = 16; //size of side-lenght of quadratic tiles in pixel
	public static final int particleSize = 4;
	public static final float collisionIteration = 1f;
	
	//temporary startup map sizes
	public static final int mapSizeX = 100;
	public static final int mapSizeY = 100;
	public static final int mapSizeZ = 5;

	public static final int tileSideTextureHeight = 8;
	
	public static String mapFolderPath = "../core/assets/";	
	
	public static String particleFolderPath = "Particles/";
	public static String tileFolderPath = "Tiles/TileTextures/";
	public static String tileSpriteSheetFolderPath = "Tiles/SpriteSheets/";
	public static String sideTextureFolderPath = "Tiles/SideTextures/";
	public static String overlayFolderPath = "Overlays/";

}
