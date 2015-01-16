package com.mygdx.codeAssets.Handlers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.codeAssets.Objects.Entities.Player;

public class PlayerHandler {
	


	private MapHandler mapHandler;
	Player player;


	
	public PlayerHandler(MapHandler a_mapHandler) {
		mapHandler = a_mapHandler;
		player = new Player();
		player.position = new Vector3(30, 30, 0);
	}
	
	
	public void update()
	{
		
		player.update(mapHandler.getCurrentMap());
		
	}
	
	public void draw(SpriteBatch a_batch) {
		
		a_batch.begin();
		
		//TODO: Multi equipment animation and rendering
		//		Jedes item hat eine texture die an einer position zeichnet wird
		//		die position werden mit animation verändert. keine ahnung was hier noch kommt ^^ vllt ein skript?
		a_batch.draw(player.getTexture(), player.position.x, player.position.y);
		
		a_batch.end();
	}
}
