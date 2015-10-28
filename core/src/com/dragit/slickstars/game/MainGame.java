package com.dragit.slickstars.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.dragit.slickstars.screen.MenuScreen;
import com.dragit.slickstars.util.Art;
import com.dragit.slickstars.util.Font;
import com.dragit.slickstars.util.Logger;

public class MainGame extends Game {
	private final String CLASS_NAME = "MainGame";
	
	public final int WIDTH = 480;
	public final int HEIGHT = 800;
	public final float BALL_SIZE = 64f;
	public final int BALL_SPEED = 3;
	public final int DRAG_SPEED = 15;
	public final int GAME_TIME = 60;
	public final int MAX_DIFFICULTS = 4;
	
	private OrthographicCamera camera;
	
	private int difficult;
	
	public SpriteBatch batch;
	public Stage stage;
	public ShapeRenderer shapeRenderer;
	
	public int score;
	public int points;
	public static boolean isPause;
	
	public enum ObjectType {
		RED,
		GREEN
	}
	
	public enum GameStatus {
		GAME_NONE,
		GAME_PLAY,
		GAME_PAUSE,
		GAME_END
	}
	
	public enum Direction {
		NONE,
		LEFT,
		RIGHT,
		UP,
		DOWN
	}
	
	public GameStatus status = GameStatus.GAME_NONE;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, WIDTH, HEIGHT);
		stage = new Stage();
		shapeRenderer = new ShapeRenderer();
		
		Art.load();
		Font.load();
		//Particle.load();
		
		this.setScreen(new MenuScreen(this));
		Logger.log(CLASS_NAME, "started");
	}

	@Override
	public void render () {
		super.render();
	}
	
	public int getDifficult() {
		return difficult;
	}

	public void setDifficult(int difficult) {
		this.difficult = difficult;
	}
	
	public void dispose() {
		super.dispose();
		
		batch.dispose();
		stage.dispose();
		shapeRenderer.dispose();
		Art.dispose();
		Font.dispose();
		//Particle.dispose();
		
		Logger.log(CLASS_NAME, "disposed");
	}
}
