package com.mygdx.codeAssets.Handlers.EventHandlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.codeAssets.Handlers.EventHandler;
import com.mygdx.codeAssets.Handlers.MapHandler;
import com.mygdx.codeAssets.Handlers.PlayerHandler;
import com.mygdx.codeAssets.Handlers.RenderHandler;
import com.mygdx.codeAssets.Handlers.UserInterfaceHandler;

public class IngameEventHandler extends EventHandler {

	MapHandler mapHandler;
	PlayerHandler playerHandler;
	Vector2 playerDirection;
	Vector2 facingDirection;
	
	public IngameEventHandler(MapHandler a_mapHandler, PlayerHandler a_playerHandler,RenderHandler a_renderHandler, UserInterfaceHandler a_userInterfaceHandler) {
		super(a_renderHandler, a_userInterfaceHandler);
		
		mapHandler = a_mapHandler;
		playerHandler = a_playerHandler;
		
		playerDirection = new Vector2(a_playerHandler.player.getDirection());
		facingDirection = new Vector2(a_playerHandler.player.getFacingDirection());
	}
	
	@Override
	public boolean keyDown(int keycode) {

		switch (keycode) {

		case Keys.W:
			if (Gdx.input.isKeyPressed(Keys.S))
				playerDirection.y = 0;
			else
				playerDirection.y = 1;
			break;
		case Keys.S:	
			if (Gdx.input.isKeyPressed(Keys.W))
				playerDirection.y = 0;
			else
				playerDirection.y = -1;
			break;
		case Keys.D:
			if (Gdx.input.isKeyPressed(Keys.A))
				playerDirection.x = 0;
			else
				playerDirection.x = 1;
			break;
		case Keys.A:
			if (Gdx.input.isKeyPressed(Keys.D))
				playerDirection.x = 0;
			else
				playerDirection.x = -1;
			break;



		case Keys.SHIFT_LEFT:
			playerHandler.player.sprinting = true;			
			break;

		case Keys.F1:
			userInterfaceHandler.isDebug = !userInterfaceHandler.isDebug;
		default:
			break;
		}
		playerDirection.nor();
		playerHandler.player.setDirection(playerDirection);		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		switch (keycode) {
		case Keys.W:
			if (Gdx.input.isKeyPressed(Keys.S)){
				playerDirection.y = -1;
				break;
			}
			playerDirection.y = 0;
			break;
		case Keys.S:
			if (Gdx.input.isKeyPressed(Keys.W)){
				playerDirection.y = 1;
				break;
			}
			playerDirection.y = 0;
			break;
		case Keys.D:
			if (Gdx.input.isKeyPressed(Keys.A)){
				playerDirection.x = -1;
				break;
			}
			playerDirection.x = 0;
			break;
		case Keys.A:
			if (Gdx.input.isKeyPressed(Keys.D)){
				playerDirection.x = 1;
				break;
			}
			playerDirection.x = 0;
			break;
		case Keys.SHIFT_LEFT:
			playerHandler.player.sprinting = false;			
			break;
		default:
			return false;
		}

		playerDirection.nor();
		playerHandler.player.setDirection(playerDirection);

		return true;
	}
	
	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		
		facingDirection.x = (Gdx.graphics.getWidth() / 2) - screenX;
		facingDirection.y = (Gdx.graphics.getHeight() / 2) - screenY;
		
		facingDirection.nor();
		
		
		if (facingDirection.x <= -0.5f)
			facingDirection.x = 1f;
		else if (facingDirection.x >= 0.5f)
			facingDirection.x = -1f;
		else
			facingDirection.x = 0f;
		
		
		if (facingDirection.y <= -0.5f)
			facingDirection.y = -1f;
		else if (facingDirection.y >= 0.5f)
			facingDirection.y = 1f;
		else
			facingDirection.y = 0f;
		
		playerHandler.player.setFacingDirection(facingDirection);
		userInterfaceHandler.mouseMoved(screenX, screenY);
		
		return true;
	}

	
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		
		userInterfaceHandler.touchDown(screenX, screenY, button);

		return true;
	}
	
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		
		userInterfaceHandler.touchUp(screenX, screenY, button);
		
		return true;
	}
	
	
	@Override
	public boolean scrolled(int amount) {
		renderHandler.zoom(amount);
		return false;
	}
	
}
