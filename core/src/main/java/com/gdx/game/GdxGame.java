package com.gdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gdx.game.entities.Entity;
import com.gdx.game.manager.RessourceManager;
import com.gdx.game.screen.GameScreen;
import com.gdx.game.screen.MenuScreen;

import java.util.Map;

public class GdxGame extends Game {
	private SpriteBatch batch;
	private Map<String, Entity> entityMap;
	private RessourceManager ressourceManager;
	private MenuScreen menuScreen;
	private GameScreen gameScreen;

	public SpriteBatch getBatch() {
		return batch;
	}

	public Map<String, Entity> getEntityMap() {
		return entityMap;
	}

	public void setEntityMap(Map<String, Entity> entityMap) {
		this.entityMap = entityMap;
	}

	public MenuScreen getMenuScreen() {
		return menuScreen;
	}

	public GameScreen getGameScreen() {
		return gameScreen;
	}

	public void create() {
		batch = new SpriteBatch();
		ressourceManager = new RessourceManager();

		menuScreen = new MenuScreen(this, ressourceManager);
		gameScreen = new GameScreen(this, ressourceManager);

		this.setScreen(menuScreen);
	}

	@Override
	public void dispose() {
		super.dispose();
		batch.dispose();
		menuScreen.dispose();
		gameScreen.dispose();
		ressourceManager.dispose();
	}
}
