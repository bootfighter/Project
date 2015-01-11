package com.mygdx.codeAssets.Handlers;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.codeAssets.Objects.CollisionRect;
import com.mygdx.codeAssets.Objects.Tile;

public class PlayerHandler {
	

	Vector3 position;
	Vector3 newPosition;
	Vector2 direction;
	Vector2 facingDirection;
	
	private int walkSpeed;
	private int sprintSpeed;
	
	
	private final int tileSize;
	private CollisionRect collisionRect;
	private MapHandler mapHandler;
	private Tile[][] tileList;
	private Vector3 tilePosition;
	private Vector2 inTilePosition;
	private Tile currentTile;
	
	boolean sprinting;
	Texture texture;
	
	public PlayerHandler(MapHandler a_mapHandler) {
		position = new Vector3(0,0,0);
		newPosition = new Vector3(0,0,0);
		facingDirection = new Vector2(0,0);
		direction = new Vector2(0,0);
		walkSpeed = 100;
		sprintSpeed = 200;
		sprinting = false;
		texture = new Texture("player.png");
		
		mapHandler = a_mapHandler;
		tileList = new Tile[2][2];
		tilePosition = new Vector3(0,0,0);
		inTilePosition = new Vector2(0,0);
		currentTile = new Tile();
		tileSize = 16;
		collisionRect = new CollisionRect(new Vector2(0,0), new Vector2(16,16));
	}
	
	
	
	
	private boolean isColliding(Vector3 a_newPosition){
		
		ArrayList<CollisionRect> currentColRectList;
		
		//mapHandler.getTileFromPosition(a_newPosition);
		tilePosition.x = (int) a_newPosition.x / tileSize;
		tilePosition.y = (int) a_newPosition.y / tileSize;
		tilePosition.z = (int) a_newPosition.z / tileSize;
		
		
		if(tilePosition.x + collisionRect.point1.x > tileSize){
			
		}
		if(tilePosition.y + collisionRect.point1.y > tileSize){
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		tileList[0][0] = mapHandler.getTileFromPosition(tilePosition);
		tilePosition.x++;
		tileList[1][0] = mapHandler.getTileFromPosition(tilePosition);
		tilePosition.y++;
		tileList[1][1] = mapHandler.getTileFromPosition(tilePosition);
		tilePosition.x--;
		tileList[0][1] = mapHandler.getTileFromPosition(tilePosition);
		
		System.out.println("----------");
		
		for (int x = 0; x < 2; x++) {
			for (int y = 0; y < 2; y++) {
				
				currentTile = tileList[x][y];
				
				inTilePosition.x = ((int)a_newPosition.x % tileSize) + (x * (collisionRect.point2.x - tileSize));
				inTilePosition.y = ((int)a_newPosition.y % tileSize) + (y * (collisionRect.point2.y - tileSize));
				
				currentColRectList = currentTile.getCollision_boxes();
				
				System.out.println(inTilePosition + " " + x + " " + y);
				
				for (CollisionRect curCollisionRect : currentColRectList) {
					
					if (inTilePosition.x >= curCollisionRect.point1.x && 
						inTilePosition.y >= curCollisionRect.point1.y &&
						inTilePosition.x <= curCollisionRect.point2.x &&
						inTilePosition.y <= curCollisionRect.point2.y) {
						

						System.out.println("true");
						return true;
					}
					
				}
				
				
			}
		}
		
		*/
		
		return false;
	}
	

	
	public void update()
	{
		if (direction.x == 0 && direction.y == 0) 
			return;
		
		newPosition.set(position);
		
		if (!sprinting) {
			newPosition.x += direction.x * walkSpeed * Gdx.graphics.getDeltaTime();
			newPosition.y += direction.y * walkSpeed * Gdx.graphics.getDeltaTime();
		} else {
			newPosition.x += direction.x * sprintSpeed * Gdx.graphics.getDeltaTime();
			newPosition.y += direction.y * sprintSpeed * Gdx.graphics.getDeltaTime();
		}
		
		if(!this.isColliding(newPosition)){
			position.set(newPosition);
		}
		
		
	}
	
	public void draw(SpriteBatch a_batch) {
		
		a_batch.begin();
		
		//TODO: Multi equipment animation and rendering
		//		Jedes item hat eine texture die an einer position zeichnet wird
		//		die position werden mit animation verändert. keine ahnung was hier noch kommt ^^ vllt ein skript?
		a_batch.draw(texture, position.x, position.y);
		
		a_batch.end();
	}
}
