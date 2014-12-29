package com.mygdx.codeAssets;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class GameMap {

	private Tile[][][] tileList;
	private int length;
	private int width;
	private int height;

	private SpriteBatch batch;
	
	final int textureSize = 16;
	

	// Constructors
	public GameMap(int a_length, int a_width, int a_heigth) {

		length = a_length;
		width = a_width;
		height = a_heigth;
		tileList = new Tile[length][width][height];
		
		fillWithTile(new Tile());
		
		batch = new SpriteBatch();
	}

	public GameMap() {

		length = 1;
		width = 1;
		height = 0;
		tileList = new Tile[length][width][height];
		
		fillWithTile(new Tile());
		
		batch = new SpriteBatch();
	}

	// Setters
	public boolean setTileAtPosition(Tile a_tile, int a_length, int a_width,
			int a_height) {

		// check for out of bounds
		if (a_length > length || a_width > width || a_height > height) {
			return false;
		}

		tileList[a_length][a_width][a_height] = a_tile;

		return true;
	}

	// Getters
	public Tile getTileAtPosition(int a_length, int a_width, int a_height) {
		return tileList[a_length][a_width][a_height];
	}

	public int getLength() {
		return length;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	// this function is just for testing purposes
	public int getVolume() {
		return (length + 1) * (width + 1) * (height + 1);
	}

	public void fillWithTile(Tile a_tile) {

		for (int i = 0; i < length; i++) {

			for (int j = 0; j < width; j++) {

				for (int k = 0; k < height; k++) {
					tileList[i][j][k] = a_tile;
				}
			}
		}
	}

	public void fillWithTile(Tile a_tile, Vector3 a_point1, Vector3 a_point2) {

		for (int i = (int) a_point1.x; i < a_point2.x; i++) {

			for (int j = (int) a_point1.y; j < a_point2.y; j++) {

				for (int k = (int) a_point1.z; k < a_point2.z + 1; k++) {
					tileList[i][j][k] = a_tile;
				}
			}
		}
	}

	
	
	public void renderGameMap() {
		batch.begin();

		// spriteBatch.draw(tileList[1][1][0].texture, 10, 10);

		
		for (int len = 0; len < length; len++) {
			
			for (int wid = 0; wid < width; wid++) {
				
				for (int hei = 0; hei < height; hei++) {
					
					batch.draw(tileList[len][wid][hei].texture, len * textureSize,  wid* textureSize);
					
				}
			
			}
			
		}
		
		batch.end();

	}

}
