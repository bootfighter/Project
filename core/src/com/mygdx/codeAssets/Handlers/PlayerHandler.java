package com.mygdx.codeAssets.Handlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.codeAssets.Objects.Weapon;
import com.mygdx.codeAssets.Objects.Entities.Player;
import com.mygdx.codeAssets.Objects.Items.SapphireDagger;

public class PlayerHandler {
	


	private MapHandler mapHandler;
	Player player;
	Weapon weapon;
	Sprite weaponSprite;
	Vector2 weaponOffset;
	int millis;
	
	public PlayerHandler(MapHandler a_mapHandler) {
		mapHandler = a_mapHandler;
		player = new Player();
		player.position = new Vector3(30, 30, 0);
		millis = 0;
		
		weapon  = new SapphireDagger();
		weaponSprite = weapon.getTexture();

		weaponSprite.setOrigin(00, 0);
		weaponSprite.rotate(-45f);
		weaponSprite.setScale(0.5f, 0.5f);		
		
		weaponOffset = new Vector2(7, 18);
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
		weaponSprite.setPosition(player.position.x + weaponOffset.x, player.position.y + weaponOffset.y);
		
		millis += Gdx.graphics.getDeltaTime() * 1000;
		
		if (millis >= 10) {
			millis = 0;
			weaponSprite.rotate(-15);
		}
		
		weaponSprite.draw(a_batch);
		
		a_batch.end();
	}
}
