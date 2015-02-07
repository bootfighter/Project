package com.mygdx.codeAssets.Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.GameParameters;

public abstract class Entity {

	public Vector3 position;
	public Vector3 tilePosition;
	public final Vector2 collisionDimension;
	protected Vector2 direction;
	protected Texture texture;
	protected CollisionRect collisionRect;
	private float collisionIteration = GameParameters.collisionIteration;
	
	public Entity() {
		position = new Vector3(0,0,0);
		tilePosition = new Vector3(0,0,0);
		direction = new Vector2(0,0);
		texture = new Texture("missingtxt.png");
		collisionRect = new CollisionRect();
		collisionDimension = new Vector2(Math.abs(collisionRect.point2.x - collisionRect.point1.x),
										Math.abs(collisionRect.point2.x - collisionRect.point1.x));
	}
	
	public Entity(Vector3 a_position, Texture a_texture, CollisionRect a_collisionRect){
		position = a_position;
		tilePosition = Tile.convertWorldSpaceToTileSpace(position);
		direction = new Vector2(0,0);
		texture = a_texture;
		collisionRect = a_collisionRect;
		collisionDimension= new Vector2(Math.abs(collisionRect.point2.x - collisionRect.point1.x),
										Math.abs(collisionRect.point2.x - collisionRect.point1.x));
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
		
	public abstract void update(GameMap a_map);
	
	public void move(Vector3 a_amount)	{
		position.add(a_amount);
	}
	
	public abstract void draw(SpriteBatch a_batch);
	
	public void collisionDetection(Vector3 a_moveVector, GameMap a_map)
	{
		Vector3 newPosition = new Vector3(position);
		Vector3 moveVector = new Vector3(a_moveVector);
		Vector3 moveVectorNormal = new Vector3(a_moveVector);
		
		float moveVectorLen = moveVector.len();
		float currVectorLen = 0f;
		Vector3 subsectionPoint1 = new Vector3(0,0,0);
		Vector3 subsectionPoint2 = new Vector3(0,0,0);
		CollisionRect currentRect = new CollisionRect();
		Vector3 changedPos = new Vector3(0, 0, 0);
		
		newPosition.add(a_moveVector);
		moveVectorNormal.nor();
		
		subsectionPoint1.x = Math.min(newPosition.x, Math.min(newPosition.x + collisionRect.point2.x, Math.min(position.x, position.x + collisionRect.point2.x)));
		subsectionPoint1.y = Math.min(newPosition.y, Math.min(newPosition.y + collisionRect.point2.y, Math.min(position.y, position.y + collisionRect.point2.y)));
		subsectionPoint1.z = Math.min(newPosition.z, position.z);
		
		subsectionPoint2.x = Math.max(newPosition.x, Math.max(newPosition.x + collisionRect.point2.x, Math.max(position.x, position.x + collisionRect.point2.x)));
		subsectionPoint2.y = Math.max(newPosition.y, Math.max(newPosition.y + collisionRect.point2.y, Math.max(position.y, position.y + collisionRect.point2.y)));
		subsectionPoint2.z = Math.max(newPosition.z, position.z);
		
		subsectionPoint1 = Tile.convertWorldSpaceToTileSpace(subsectionPoint1);
		subsectionPoint2 = Tile.convertWorldSpaceToTileSpace(subsectionPoint2);
		
		
		Tile[][][] currentTileList = a_map.getTileSubsection(subsectionPoint1, subsectionPoint2);
		
		
		int posX = 0;
		int posY = 0;
		int posZ = 0;
			
		for(int dimX = 0 ; dimX <= (subsectionPoint2.x - subsectionPoint1.x) ; dimX++){ 
			posX = (int) (moveVector.x < 0 ? (subsectionPoint2.x - subsectionPoint1.x) - dimX : dimX);
			
			for(int dimY = 0 ; dimY <= (subsectionPoint2.y - subsectionPoint1.y) ; dimY++){
				posY = (int) (moveVector.y < 0 ? (subsectionPoint2.y - subsectionPoint1.y) - dimY : dimY);
				
				for(int dimZ = 0 ; dimZ <= (subsectionPoint2.z - subsectionPoint1.z) ; dimZ++){
					posZ = (int) (moveVector.z < 0 ? (subsectionPoint2.z - subsectionPoint1.z) - dimZ : dimZ);

					currVectorLen = 0;

					while(currVectorLen < moveVectorLen){
						
						currentRect = CollisionRect.isCollidingWithTile(collisionRect,
								new Vector2(newPosition.x + (moveVectorNormal.x * currVectorLen), newPosition.y + (moveVectorNormal.y * currVectorLen)), 
								currentTileList[posX][posY][posZ], new Vector3(subsectionPoint1.x + posX, subsectionPoint1.y + posY, subsectionPoint1.z + posZ));

						//if a colliding Rect has been found
						if (currentRect != null) {

							changedPos = calculateCollidedPos(currentRect, Tile.convertTileSpaceToWorldSpace((int)subsectionPoint1.x + posX,
									(int)subsectionPoint1.y + posY, (int)subsectionPoint1.z + posZ), moveVector);
							
							if (changedPos.x != 0){
								newPosition.x = changedPos.x;
								moveVector.x = 0;
								moveVectorNormal.x = 0;
							}
							if (changedPos.y != 0){
								newPosition.y = changedPos.y;
								moveVector.y = 0;
								moveVectorNormal.y = 0;
							}

						}

						currVectorLen += collisionIteration;
					}
				}
			}
		}
		
		
		//if nothing has been found
		position.set(newPosition);
		
	}
	
	private Vector3 calculateCollidedPos(CollisionRect a_rect, Vector3 a_rectPos, Vector3 a_moveVector) {
		//this collides with a_rect1 with a_rectPos1 with Vel of movevector
		CollisionRect worldPosRect = new CollisionRect(a_rect);
		Vector2 newPosition = new Vector2(0, 0);

		worldPosRect.point1.add(new Vector2(a_rectPos.x, a_rectPos.y));
		worldPosRect.point2.add(new Vector2(a_rectPos.x, a_rectPos.y));
		
		if (position.x + collisionRect.point2.x <= worldPosRect.point1.x) {
			//coming from left

			newPosition.x = worldPosRect.point1.x - collisionRect.point2.x;
			return new Vector3(newPosition, position.z);
		}

		if (position.x >= worldPosRect.point2.x) {
			//coming from right

			newPosition.x = worldPosRect.point2.x;
			return new Vector3(newPosition, position.z);
		}
		
		if (position.y + collisionRect.point2.y <= worldPosRect.point1.y) {
			//coming from under

			newPosition.y = worldPosRect.point1.y - collisionRect.point2.y;
			return new Vector3(newPosition, position.z);

		}
		if (position.y >= worldPosRect.point2.y) {
			//coming from up

			newPosition.y = worldPosRect.point2.y;
			return new Vector3(newPosition, position.z);
		}
		
		return new Vector3(newPosition, position.z);
	}
}
