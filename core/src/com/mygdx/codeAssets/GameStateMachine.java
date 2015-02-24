package com.mygdx.codeAssets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.codeAssets.Scenes.SceneAbstract;

public class GameStateMachine {

	protected SceneAbstract scene;
	protected SpriteBatch batch;
	
	public GameStateMachine(SpriteBatch a_batch){
		batch = a_batch;
	}
	
	public SpriteBatch getBatch() {
		return batch;
	}
	
	public SceneAbstract getScene() {
		return scene;
	}
	public void setScene(SceneAbstract a_scene){
		scene = a_scene;
	}
	
	public void update(){
		scene.update();
	}
	
	public void render() {
		scene.render();
	}

	public void resize(int width, int height) {
		scene.resize(width, height);
	}

	public void dispose() {
		scene.dispose();
		Gdx.app.exit();
	}

}
