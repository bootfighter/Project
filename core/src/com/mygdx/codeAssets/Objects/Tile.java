package com.mygdx.codeAssets.Objects;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.GameParameters;

public class Tile {
	
	Texture texture; 
	ArrayList<CollisionRect> collision_boxes;
	private static int tileSize = GameParameters.tileSize;
	
	// Constructors
	public Tile(Texture a_texture, ArrayList<CollisionRect> a_collision_boxes){
		texture = a_texture;
		collision_boxes = a_collision_boxes;
	}
	

	public Tile(Texture a_texture, boolean a_is_solid){
		texture = a_texture;
		collision_boxes = new ArrayList<CollisionRect>();
		if (a_is_solid)
			collision_boxes.add(new CollisionRect(new Vector2(0, 0), new Vector2(tileSize, tileSize)));
	}
	
	public Tile(){
		texture = new Texture("missingtxt.png");
		collision_boxes = new ArrayList<CollisionRect>();
		collision_boxes.add(new CollisionRect(new Vector2(0, 0), new Vector2(tileSize, tileSize)));
	}
	
	public ArrayList<CollisionRect> getCollision_boxes() {
		return collision_boxes;
	}
	
	
	
	
	
	//static functions
	
	public static Vector3 convertTileSpaceToWorldSpace (Vector3 a_tileSpace){
		return new Vector3(	a_tileSpace.x * tileSize, 
				a_tileSpace.y * tileSize,
				a_tileSpace.z * tileSize);
	}
	
	public static int convertTileSpaceToWorldSpace(int a_tileSpace){
		return (a_tileSpace * tileSize);
	}
	
	public static Vector3 convertTileSpaceToWorldSpace(int a_tileSpaceDimX, int a_tileSpaceDimY, int a_tileSpaceDimZ ){
		return (new Vector3(a_tileSpaceDimX * tileSize, a_tileSpaceDimY * tileSize, a_tileSpaceDimZ * tileSize));
	}
	
	public static Vector3 convertWorldSpaceToTileSpace (Vector3 a_tileSpace){
		return new Vector3(	(int)a_tileSpace.x / tileSize, 
				(int)a_tileSpace.y / tileSize,
				(int)a_tileSpace.z / tileSize);
	}
	
	public static int convertWorldSpaceToTileSpace (int  a_tileSpace){
		return (a_tileSpace / tileSize);
	}
	
	
}