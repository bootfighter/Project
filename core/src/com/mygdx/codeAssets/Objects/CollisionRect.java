package com.mygdx.codeAssets.Objects;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.GameParameters;

public class CollisionRect {
	
	public Vector2 point1;
	public Vector2 point2;
	
	
	// Constructors
	public CollisionRect(Vector2 a_point1, Vector2 a_point2) {
		point1 = a_point1;
		point2 = a_point2;
	}
	
	
	public CollisionRect() {
		point1 = new Vector2(0,0);
		point2 = new Vector2(0,0);
	}
	public CollisionRect(CollisionRect a_collisionRect) {
		this.point1 = new Vector2(a_collisionRect.point1);
		this.point2 = new Vector2(a_collisionRect.point2);
	}
	
	public static boolean isColliding(CollisionRect a_rect1, CollisionRect a_rect2, Vector2 a_rect1Pos, Vector2 a_rect2Pos) {
		
		CollisionRect rect1 = new CollisionRect(a_rect1);
		CollisionRect rect2 = new CollisionRect(a_rect2);
		
		rect1.point1.add(a_rect1Pos);
		rect1.point2.add(a_rect1Pos);
		rect2.point1.add(a_rect2Pos);
		rect2.point2.add(a_rect2Pos);
		
		if (rect1.point2.x <= rect2.point1.x ||
				rect2.point2.x <= rect1.point1.x ||
				rect2.point2.y <= rect1.point1.y ||
				rect1.point2.y <= rect2.point1.y) 
			return false;
			
		return true;
	}
	
	
	public static CollisionRect isCollidingWithTile(CollisionRect a_rect, Vector2 a_rectPos, Tile a_tile, Vector3 a_tilePosition){
		
		ArrayList<CollisionRect> collRectList = a_tile.getCollision_boxes();
		Vector2 tilePositionInWorldCoord = new Vector2(a_tilePosition.x * GameParameters.tileSize, a_tilePosition.y * GameParameters.tileSize);
		CollisionRect rect = new CollisionRect(a_rect);
		
		for (CollisionRect currRect : collRectList) {
			if(CollisionRect.isColliding(rect, currRect, a_rectPos, tilePositionInWorldCoord))
				return currRect;
		}
		return null;
	}
	
}
