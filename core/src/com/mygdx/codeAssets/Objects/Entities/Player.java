package com.mygdx.codeAssets.Objects.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.codeAssets.AnimationData.PlayerAnimationData;
import com.mygdx.codeAssets.Handlers.AnimationBoneHandler;
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
	
	AnimationBoneHandler animBoneHandler;
	
	
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

		
		animBoneHandler = new AnimationBoneHandler(PlayerAnimationData.getAnimationStructureNorth(),
													PlayerAnimationData.getAnimationStructureEast(),
													PlayerAnimationData.getAnimationStructureSouth(),
													PlayerAnimationData.getAnimationStructureWest());
		animBoneHandler.startAnimation(0, currentDir);
		
		animBoneHandler.setGlobalScale(0.5f, 0.5f);
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
		
		if ((direction.x == 0 && direction.y == 0) && (moveVector.x != 0 || moveVector.y !=0)) {
			animBoneHandler.reset();
		}
		
		moveVector.x = 0;
		moveVector.y = 0;
		
		
		//no change in position
		if (direction.x == 0 && direction.y == 0){
			animBoneHandler.changeAnimation(1); //Idle
			animBoneHandler.update(new Vector2(position.x, position.y), currentDir);
			return;
		} 
		
		
		if (!sprinting) {
			
			moveVector.x += direction.x * walkSpeed * Gdx.graphics.getDeltaTime();
			moveVector.y += direction.y * walkSpeed * Gdx.graphics.getDeltaTime();
			animBoneHandler.changeAnimation(0); //Walking
			this.collisionDetection(moveVector, a_map);
			
		} else {
			
			moveVector.x += direction.x * sprintSpeed * Gdx.graphics.getDeltaTime();
			moveVector.y += direction.y * sprintSpeed * Gdx.graphics.getDeltaTime();
			animBoneHandler.changeAnimation(0); //Walking
			this.collisionDetection(moveVector, a_map);
		}
		
		animBoneHandler.update(new Vector2(position.x, position.y), currentDir);
		
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
	
		animBoneHandler.draw(a_batch);
		
	}
}
