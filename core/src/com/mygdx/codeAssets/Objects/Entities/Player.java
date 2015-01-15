package com.mygdx.codeAssets.Objects.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.codeAssets.Objects.CollisionRect;
import com.mygdx.codeAssets.Objects.Entity;
import com.mygdx.codeAssets.Objects.GameMap;

public class Player extends Entity{
	
	Vector2 facingDirection;
	private Vector3 moveVector;
	private int walkSpeed;
	private int sprintSpeed;
	public boolean sprinting;
	
	public Player() {
		super();
		facingDirection = new Vector2(0, 0);
		moveVector = new Vector3(0,0,0);
		walkSpeed = 100;
		sprintSpeed = 200;
		sprinting = false;
		texture = new Texture("player.png");
		collisionRect = new CollisionRect(new Vector2(0, 0), new Vector2(16, 16));
	}
	
	public int getWalkSpeed() {
		return walkSpeed;
	}
	public int getSprintSpeed() {
		return sprintSpeed;
	}
	public Vector2 getFacingDirection() {
		return facingDirection;
	}
	public void setFacingDirection(Vector2 facingDirection) {
		this.facingDirection = facingDirection;
	}
	
	public void update(GameMap a_map) {
		
		moveVector.x = 0;
		moveVector.y = 0;
		
		if (direction.x == 0 && direction.y == 0) 
			return;
		
		
		if (!sprinting) {
			
			moveVector.x += direction.x * walkSpeed * Gdx.graphics.getDeltaTime();
			moveVector.y += direction.y * walkSpeed * Gdx.graphics.getDeltaTime();
			
			this.collisionDetection(moveVector, a_map);
			
			this.move(moveVector);
			
		} else {
			
			moveVector.x += direction.x * sprintSpeed * Gdx.graphics.getDeltaTime();
			moveVector.y += direction.y * sprintSpeed * Gdx.graphics.getDeltaTime();
			this.collisionDetection(moveVector, a_map);
			this.move(moveVector);
		}
		
		
	}
}
