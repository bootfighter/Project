package com.mygdx.codeAssets.Objects;

import com.badlogic.gdx.graphics.Texture;
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
		
		Vector3 newPositionP1 = position.add(a_moveVector);
		Vector3 newPositionP2 = new Vector3((newPositionP1.x + collisionRect.point2.x), 
				(newPositionP1.y + collisionRect.point2.y), newPositionP1.z);
		Vector3 newTilePositionP1 = Tile.convertWorldSpaceToTileSpace(newPositionP1);
		Vector3 newTilePositionP2 = Tile.convertWorldSpaceToTileSpace(newPositionP2);
		

		Vector3 positionP2 = new Vector3(position.x + collisionRect.point2.x, position.y + collisionRect.point2.y, position.z);
		
		tilePosition = Tile.convertWorldSpaceToTileSpace(position);
		Vector3 tilePositionP2 = Tile.convertWorldSpaceToTileSpace(positionP2);
		
		
		
		
		
		
		
		
		
		
		return collisionPoint;
	}
	
}
