package com.mygdx.codeAssets.Objects;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;

public class Tile {
	
	Texture texture; 
	boolean is_solid; 
	ArrayList<CollisionRect> collision_boxes;
	
	
	// Constructors
	public Tile(Texture a_texture, boolean a_is_solid, ArrayList<CollisionRect> a_collision_boxes){
		texture = a_texture;
		is_solid = a_is_solid;
		collision_boxes = a_collision_boxes;
	}
	

	public Tile(Texture a_texture, boolean a_is_solid){
		texture = a_texture;
		is_solid = a_is_solid;
	}
	
	public Tile(){
		texture = new Texture("missingtxt.png");
		is_solid = true;
		collision_boxes = new ArrayList<CollisionRect>();
	}
	
}