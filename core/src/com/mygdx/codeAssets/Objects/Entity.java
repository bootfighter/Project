package com.mygdx.codeAssets.Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.GameParameters;

public abstract class Entity {

	public Vector3 position;
	public Vector3 tilePosition;
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
		position.add(a_amount);
	}
	
	
	public void collisionDetection(Vector3 a_moveVector, GameMap a_map)
	{
		Vector3 newPosition = new Vector3(position);
		Vector3 moveVectorNormal = new Vector3(a_moveVector);
		float moveVectorLen = a_moveVector.len();
		float currVectorLen = 0f;
		Vector3 calcFieldMin = new Vector3(0,0,0);
		Vector3 calcFieldMax = new Vector3(0,0,0);
		CollisionRect currentRect = new CollisionRect();
		
		newPosition.add(a_moveVector);
		moveVectorNormal.nor();
		
		calcFieldMin.x = Math.min(newPosition.x, Math.min(newPosition.x + collisionRect.point2.x, Math.min(position.x, position.x + collisionRect.point2.x)));
		calcFieldMin.y = Math.min(newPosition.y, Math.min(newPosition.y + collisionRect.point2.y, Math.min(position.y, position.y + collisionRect.point2.y)));
		calcFieldMin.z = Math.min(newPosition.z, position.z);
		
		calcFieldMax.x = Math.max(newPosition.x, Math.max(newPosition.x + collisionRect.point2.x, Math.max(position.x, position.x + collisionRect.point2.x)));
		calcFieldMax.y = Math.max(newPosition.y, Math.max(newPosition.y + collisionRect.point2.y, Math.max(position.y, position.y + collisionRect.point2.y)));
		calcFieldMax.z = Math.max(newPosition.z, position.z);
		
		calcFieldMin = Tile.convertWorldSpaceToTileSpace(calcFieldMin);
		calcFieldMax = Tile.convertWorldSpaceToTileSpace(calcFieldMax);
		
		Tile[][][] currentTileList = a_map.getTileSubsection(calcFieldMin, calcFieldMax);
		
		for (int dimX = 0; dimX <= calcFieldMax.x - calcFieldMin.x; dimX++) {
			for (int dimY = 0; dimY <= calcFieldMax.y - calcFieldMin.y; dimY++) {
				for (int dimZ = 0; dimZ <= calcFieldMax.z - calcFieldMin.z; dimZ++) {
					
					currVectorLen = 0;
					
					while (currVectorLen < moveVectorLen) {
						currentRect = CollisionRect.isCollidingWithTile(collisionRect,
								new Vector2(position.x + (moveVectorNormal.x * currVectorLen), newPosition.y + (moveVectorNormal.y * currVectorLen)), 
								currentTileList[dimX][dimY][dimZ], new Vector3(calcFieldMin.x + dimX, calcFieldMin.y + dimY, calcFieldMin.z + dimZ));
						
						//if a colliding Rect has been found
						if (currentRect != null) {
							
							calculateCollidedPos(currentRect, Tile.convertTileSpaceToWorldSpace((int)calcFieldMin.x + dimX,
												(int)calcFieldMin.y + dimY, (int)calcFieldMin.z + dimZ), a_moveVector);
							return;
							
							//System.out.println("collision: " + (dimX + calcFieldMin.x) + " | " + (dimY + calcFieldMin.y) + " | " + (dimZ + calcFieldMin.z));
						}
						
						currVectorLen += collisionIteration;
					}
				}
			}
		}
		
		
		//if nothing has been found
		move(a_moveVector);
		
	}
	
	private void calculateCollidedPos(CollisionRect a_rect, Vector3 a_rectPos, Vector3 a_moveVector) {
		//this collides with a_rect1 with a_rectPos1 with Vel of movevector
		CollisionRect worldPosRect = new CollisionRect(a_rect);
		Vector2 newPosition = new Vector2(0, 0);
		Vector2 closestDifference = new Vector2(0, 0);
		Vector2 move2DVector = new Vector2(a_moveVector.x, a_moveVector.y);
		worldPosRect.point1.add(new Vector2(a_rectPos.x, a_rectPos.y));
		worldPosRect.point2.add(new Vector2(a_rectPos.x, a_rectPos.y));
		
		
		
		if (a_moveVector.x >= 0){
			if (a_moveVector.y >= 0) {
				//right up
				closestDifference.x = worldPosRect.point1.x - (position.x + collisionRect.point2.x);
				closestDifference.y = worldPosRect.point1.y - (position.y + collisionRect.point2.y);
				
				System.out.println("RU" + closestDifference);
				
				if (closestDifference.angle() < move2DVector.angle()) {
					//cuts bottom part of rect
					
					newPosition.x = position.x + move2DVector.x;
					newPosition.y = worldPosRect.point1.y - collisionRect.point2.y;
				}
				else {
					//cuts left part of rect
					
					newPosition.y = position.y + move2DVector.y;
					newPosition.x = worldPosRect.point1.x - collisionRect.point2.x;
				}
				
			}else {
				//right down
				
				closestDifference.x = worldPosRect.point1.x - (position.x + collisionRect.point2.x);
				closestDifference.y = position.y - (worldPosRect.point2.y);
				
				System.out.println("RD" + closestDifference);
				
				if (closestDifference.angle() < move2DVector.angle()) {
					//cuts top part of rect
						
					newPosition.x = position.x + move2DVector.x;
					newPosition.y = worldPosRect.point2.y;
				}
				else {
					//cuts left part of rect
					
					newPosition.y = position.y + move2DVector.y;
					newPosition.x = worldPosRect.point1.x - collisionRect.point2.x;
				}
				
			}
		}
		
		
		if (a_moveVector.x < 0) {
			if (a_moveVector.y >= 0) {
				//left up
				closestDifference.x = position.x - worldPosRect.point2.x;
				closestDifference.y = worldPosRect.point1.y - (position.y + collisionRect.point2.y);
				
				System.out.println("LU" + closestDifference);
				
				if (closestDifference.angle() < move2DVector.angle()) {
					//cuts bottom part of rect
					
					newPosition.x = position.x + move2DVector.x;
					newPosition.y = worldPosRect.point1.y - collisionRect.point2.y;
				}else {
					//cuts right part of rect

					newPosition.x = worldPosRect.point2.x;
					newPosition.y = position.y + move2DVector.y;
				}
				
				
			}else {
				//left down
				
				closestDifference.x = position.x - worldPosRect.point2.x;
				closestDifference.y = position.y - worldPosRect.point2.y;
				
				System.out.println("LD" + closestDifference);
				
				if (closestDifference.angle() < move2DVector.angle()) {
					//cuts right part of rect
					
					newPosition.x = worldPosRect.point2.x;
					newPosition.y = position.y + move2DVector.y;
					
				}else {
					//cuts top part of rect
					
					newPosition.y = worldPosRect.point2.y;
					newPosition.x = position.x + move2DVector.x;
					
				}
				
			}
		
		}
		
		//System.out.println("diff: " + new Vector2(newPosition.x - position.x, newPosition.y - position.y) + " movV: " + move2DVector);
		position.set(newPosition, position.z);
	}
}
