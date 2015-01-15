package com.mygdx.codeAssets.Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public abstract class Enity {

	private Vector3 position;
	private Vector3 tilePosition;
	private Vector2 direction;
	private Texture texture;
	private CollisionRect collisionRect;
	
	public Enity() {
		position = new Vector3(0,0,0);
		tilePosition = new Vector3(0,0,0);
		direction = new Vector2(0,0);
		texture = new Texture("missingtxt.png");
		collisionRect = new CollisionRect();
	}

	public Vector3 getPosition() {
		return position;
	}

	public void setPosition(Vector3 position) {
		this.position = position;
	}

	public Vector2 getDirection() {
		return direction;
	}

	public void setDirection(Vector2 direction) {
		this.direction = direction;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public CollisionRect getCollisionRect() {
		return collisionRect;
	}

	public void setCollisionRect(CollisionRect collisionRect) {
		this.collisionRect = collisionRect;
	}
	
	
	public void move(Vector3 a_amount)	{
		
		//newPosition = position.add(a_amount);
		
		
		
		
		
	}
	
	
	public Vector3 collisionDetection(Vector3 a_moveVector, GameMap a_map)
	{
		Vector3 collisionPoint = new Vector3(0,0,0);
		Vector3 newPosition = new Vector3(position.add(a_moveVector));
		//float moveLen = a_moveVector.len();
		Vector3 calcFieldMin = new Vector3(0,0,0);
		Vector3 calcFieldMax = new Vector3(0,0,0);
		
		
		calcFieldMin.x = Math.min(newPosition.x, Math.min(newPosition.x + collisionRect.point2.x, Math.min(position.x, position.x + collisionRect.point2.x)));
		calcFieldMin.y = Math.min(newPosition.y, Math.min(newPosition.y + collisionRect.point2.y, Math.min(position.y, position.y + collisionRect.point2.y)));
		calcFieldMin.z = Math.min(newPosition.z, position.z);
		
		calcFieldMax.x = Math.max(newPosition.x, Math.max(newPosition.x + collisionRect.point2.x, Math.max(position.x, position.x + collisionRect.point2.x)));
		calcFieldMax.y = Math.max(newPosition.y, Math.max(newPosition.y + collisionRect.point2.y, Math.max(position.y, position.y + collisionRect.point2.y)));
		calcFieldMax.z = Math.max(newPosition.z, position.z);
		
		calcFieldMin = Tile.convertWorldSpaceToTileSpace(calcFieldMin);
		calcFieldMax = Tile.convertWorldSpaceToTileSpace(calcFieldMax);
		
		Tile[][][] currentTileList = a_map.getTileSubsection(calcFieldMin, calcFieldMax);
		
		for (int dimX = 0; dimX < calcFieldMax.x - calcFieldMin.x; dimX++) {
			for (int dimY = 0; dimY < calcFieldMax.y - calcFieldMin.y; dimY++) {
				for (int dimZ = 0; dimZ < calcFieldMax.z - calcFieldMin.z; dimZ++) {
					
					
					
				}
			
			
			}
			
			
		}
		
		
		if(newPosition.x < (newPosition.x + collisionRect.point2.x))
		{
			
			
		}
			
		
		
		
		
		
		
		
		
		
		return collisionPoint;
	}
	
}
