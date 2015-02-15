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
		
		boolean xPosChanged = (moveVector.x == 0) ? true : false;
		boolean yPosChanged = (moveVector.y == 0) ? true : false;
		
		newPosition.add(moveVector);
		moveVectorNormal.nor();
		
		subsectionPoint1.x = Math.min(newPosition.x, Math.min(newPosition.x + collisionRect.point2.x, Math.min(position.x, position.x + collisionRect.point2.x)));
		subsectionPoint1.y = Math.min(newPosition.y, Math.min(newPosition.y + collisionRect.point2.y, Math.min(position.y, position.y + collisionRect.point2.y)));
		subsectionPoint1.z = Math.min(newPosition.z, position.z);
		
		subsectionPoint2.x = Math.max(newPosition.x, Math.max(newPosition.x + collisionRect.point2.x, Math.max(position.x, position.x + collisionRect.point2.x)));
		subsectionPoint2.y = Math.max(newPosition.y, Math.max(newPosition.y + collisionRect.point2.y, Math.max(position.y, position.y + collisionRect.point2.y)));
		subsectionPoint2.z = Math.max(newPosition.z, position.z);
		
		subsectionPoint1 = Tile.convertWorldSpaceToTileSpace(subsectionPoint1);
		subsectionPoint2 = Tile.convertWorldSpaceToTileSpace(subsectionPoint2);
		
		subsectionPoint1 = a_map.convertToInbounds(subsectionPoint1);
		subsectionPoint2 = a_map.convertToInbounds(subsectionPoint2);
		
		Tile[][][] currentTileList = a_map.getTileSubsection(subsectionPoint1, subsectionPoint2);
		

		int posX = 0;
		int posY = 0;
		int posZ = 0;
		
		Vector3 subsectionDimensions = new Vector3(subsectionPoint2.x - subsectionPoint1.x, 
													subsectionPoint2.y - subsectionPoint1.y, 
													subsectionPoint2.z - subsectionPoint1.z);
	

		while(currVectorLen <= moveVectorLen){

			for(int dimX = 0 ; dimX <= subsectionDimensions.x; dimX++){ 

				posX = (int) (moveVector.x < 0 ? subsectionDimensions.x - dimX : dimX);

				for(int dimY = 0 ; dimY <= subsectionDimensions.y ; dimY++){

					posY = (int) (moveVector.y < 0 ? subsectionDimensions.y - dimY : dimY);

					for(int dimZ = 0 ; dimZ <= subsectionDimensions.z ; dimZ++){

						posZ = (int) (moveVector.z < 0 ? subsectionDimensions.z - dimZ : dimZ);

						currentRect = CollisionRect.isCollidingWithTile(collisionRect,
								new Vector2(position.x + (moveVectorNormal.x * currVectorLen), position.y + (moveVectorNormal.y * currVectorLen)), 
								currentTileList[posX][posY][posZ], 
								new Vector3(subsectionPoint1.x + posX, subsectionPoint1.y + posY, subsectionPoint1.z + posZ));

						//if a colliding Rect has been found

						if (currentRect != null) {
							changedPos = calculateCollidedPos(currentRect, Tile.convertTileSpaceToWorldSpace((int)subsectionPoint1.x + posX,
									(int)subsectionPoint1.y + posY, (int)subsectionPoint1.z + posZ), moveVector);
							
							//changed position is not 0 if the value has changed - therefore the new position is the changed position 
							if (changedPos.x != 0f && !xPosChanged){
								newPosition.x = changedPos.x;
								moveVector.x = 0; 
								moveVectorNormal.x = 0;
								xPosChanged = true;
							}

							if (changedPos.y != 0f && !yPosChanged){
								newPosition.y = changedPos.y; 
								moveVector.y = 0; 
								moveVectorNormal.y = 0;
								yPosChanged = true;
							}
							//both positions have been changed -- saves calculation power at high speeds
							if (xPosChanged && yPosChanged){
								position.set(newPosition);
								return;
							}
						}
					}
				}
			}
			if (moveVectorLen - currVectorLen < collisionIteration && moveVectorLen != currVectorLen)
				currVectorLen = moveVectorLen; //for a last calculation in the while loop for the final position
			else
				currVectorLen += collisionIteration;
		}
		
		//if nothing has been found
		position.set(newPosition);
		
	}
	
	private Vector3 calculateCollidedPos(CollisionRect a_rect, Vector3 a_rectPos, Vector3 a_moveVector) {
		
		//this collides with a_rect1 with a_rectPos1 with Vel of move vector
		CollisionRect worldPosRect = new CollisionRect(a_rect);
		Vector2 entityCollRectCenter = new Vector2(0, 0);
		float fxone = 0f;
		float fxtwo = 0f;
		float fyone = 0f;
		float fytwo = 0f;

		//inflating world rect up
		worldPosRect.point1.x = a_rectPos.x + a_rect.point1.x - (collisionRect.point2.x - collisionRect.point1.x) / 2;
		worldPosRect.point1.y = a_rectPos.y + a_rect.point1.y - (collisionRect.point2.y - collisionRect.point1.y) / 2;
		worldPosRect.point2.x = a_rectPos.x + a_rect.point2.x + (collisionRect.point2.x - collisionRect.point2.x) * 1.5f;
		worldPosRect.point2.y = a_rectPos.y + a_rect.point2.y + (collisionRect.point2.y - collisionRect.point2.y) * 1.5f;
		
		entityCollRectCenter.x = position.x + collisionRect.point1.x + collisionRect.point2.x / 2;
		entityCollRectCenter.y = position.y + collisionRect.point1.y + collisionRect.point2.y / 2;

		
		
		if(a_moveVector.x != 0){
			fxone = (worldPosRect.point1.x - entityCollRectCenter.x) / a_moveVector.x;
			fxtwo = (worldPosRect.point2.x - entityCollRectCenter.x) / a_moveVector.x;
		}
		if(a_moveVector.y != 0){
			fyone = (worldPosRect.point1.y - entityCollRectCenter.y) / a_moveVector.y;
			fytwo = (worldPosRect.point2.y - entityCollRectCenter.y) / a_moveVector.y;
		}
		
		if (fxone > fxtwo) {
			float swapVar = fxtwo;
			fxtwo = fxone;
			fxone = swapVar;			
		}
		if (fyone > fytwo) {
			float swapVar = fytwo;
			fytwo = fyone;
			fyone = swapVar;			
		}
		
		if (a_moveVector.x == 0) {
			if (a_moveVector.y > 0) {
				return new Vector3(0, a_rectPos.y - collisionRect.point2.y, position.z);
			}else {
				return new Vector3(0, a_rectPos.y + a_rect.point2.y - collisionRect.point1.y, position.z);
			} 
		}
		
		if (a_moveVector.y == 0) {
			if (a_moveVector.x > 0) {
				return new Vector3(a_rectPos.x - collisionRect.point2.x, 0, position.z);
			}else {
				return new Vector3(a_rectPos.x + a_rect.point2.x - collisionRect.point1.x, 0, position.z);
			}
		}
		
		if (fxone <= fyone && fyone <= fxtwo) { //fyone in interval of fxone and fxtwo
			
			if (a_moveVector.y > 0) {
				return new Vector3(0, a_rectPos.y - collisionRect.point2.y, position.z);
			}else {
				return new Vector3(0, a_rectPos.y + a_rect.point2.y - collisionRect.point1.y, position.z);
			} 
			
		}
		
		if (fxone <= fytwo && fytwo <= fxtwo) { //fytwo in interval of fxone and fxtwo
			
			if (a_moveVector.x > 0) {
				return new Vector3(a_rectPos.x - collisionRect.point2.x, 0, position.z);
			}else {
				return new Vector3(a_rectPos.x + a_rect.point2.x - collisionRect.point1.x, 0, position.z);
			}
		}

		//should never happen
		return new Vector3(0,0,0);
	}
}
