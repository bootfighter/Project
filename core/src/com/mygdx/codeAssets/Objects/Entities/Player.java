package com.mygdx.codeAssets.Objects.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.codeAssets.Animation.AnimationSkeleton;
import com.mygdx.codeAssets.Objects.CollisionRect;
import com.mygdx.codeAssets.Objects.Entity;
import com.mygdx.codeAssets.Objects.GameMap;
import com.mygdx.codeAssets.Objects.Tile;
import com.mygdx.game.GameParameters.Direction;

public class Player extends Entity{
	
	Vector2 facingDirection;
	private Vector3 moveVector;
	private Direction currentDir;
	private int walkSpeed;
	private int sprintSpeed;
	public boolean sprinting;
	
	AnimationSkeleton animSkel;
	
	
	public Player() {
		super();
		facingDirection = new Vector2(0, 0);
		moveVector = new Vector3(0,0,0);
		currentDir = Direction.NORTH;
		walkSpeed = 100;
		sprintSpeed = 500;
		sprinting = false;
		texture = new Texture("player.png");
		collisionRect = new CollisionRect(new Vector2(0, 0), new Vector2(16, 16));
		animSkel = new AnimationSkeleton(new Vector2(position.x, position.y));
		animSkel.startAnimation(0, currentDir);
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
	
	@Override
	public void update(GameMap a_map) {
		
		tilePosition = Tile.convertWorldSpaceToTileSpace(position);
		
		caculateDirection();
		
		moveVector.x = 0;
		moveVector.y = 0;
		
		
		//no change in position
		if (direction.x == 0 && direction.y == 0){
			animSkel.changeAnimation(1); //Idle
			animSkel.update(currentDir, new Vector2(position.x, position.y));
			return;
		} 
		
		
		if (!sprinting) {
			
			moveVector.x += direction.x * walkSpeed * Gdx.graphics.getDeltaTime();
			moveVector.y += direction.y * walkSpeed * Gdx.graphics.getDeltaTime();
			animSkel.changeAnimation(0); //Walking
			this.collisionDetection(moveVector, a_map);
			
		} else {
			
			moveVector.x += direction.x * sprintSpeed * Gdx.graphics.getDeltaTime();
			moveVector.y += direction.y * sprintSpeed * Gdx.graphics.getDeltaTime();
			animSkel.changeAnimation(0); //Walking
			this.collisionDetection(moveVector, a_map);
		}
		
		animSkel.update(currentDir, new Vector2(position.x, position.y));
		
	}
	
	private void caculateDirection(){
		
		if (direction.x > 0.5f) {
			currentDir = Direction.EAST;
		}
		if (direction.x < -0.5f) {
			currentDir = Direction.WEST;
		}
		if (direction.y > 0.5f) {
			currentDir = Direction.NORTH;
		}
		if (direction.y < -0.5f) {
			currentDir = Direction.SOUTH;
		}
	}
	
	
	public void draw(SpriteBatch a_batch) {
		
		animSkel.draw(a_batch);
		
	}
}
