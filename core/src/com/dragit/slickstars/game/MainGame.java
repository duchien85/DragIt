package com.dragit.slickstars.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.dragit.slickstars.screen.MenuScreen;
import com.dragit.slickstars.util.Art;
import com.dragit.slickstars.util.Font;
import com.dragit.slickstars.util.Logger;

public class MainGame extends Game {
	private final String CLASS_NAME = "MainGame";
	
	public final int WIDTH = 480;
	public final int HEIGHT = 800;
	public final int BUTTON_WIDTH = 200;
	public final int BUTTON_HEIGHT = 65;
	public final float BALL_SIZE = 64f;
	public final int BALL_SPEED = 3;
	public final int DRAG_SPEED = 15;
	public final int GAME_TIME = 60;
	public final int MAX_DIFFICULTS = 4;
	public final float UI_PADDING = 30f;
	
	public final String GAME_TITLE = "DragIt";
	public final String UI_SKIN_PATH = "data/skin/uiskin.json";
	public final String UI_SKINATLAS_PATH = "data/skin/uiskin.atlas";
	
	private int difficult;
	
	public OrthographicCamera camera;
	public SpriteBatch batch;
	public Stage stage;
	public ShapeRenderer shapeRenderer;
	public Screen screen;
	public Skin skin;
	
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
	
	public void init() {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, WIDTH, HEIGHT);
		stage = new Stage();
		shapeRenderer = new ShapeRenderer();
		
		TextureAtlas atlas = new TextureAtlas(Gdx.files.internal(UI_SKINATLAS_PATH));
		skin = new Skin(Gdx.files.internal(UI_SKIN_PATH), atlas);
		Gdx.input.setInputProcessor(stage);
		Art.load();
		Font.load();
		//Particle.load();
		//Audio.load();
	}
	
	@Override
	public void create () {
		init();
		
		setGameScreen(new MenuScreen(this));
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
	
	public void setGameScreen(Screen screen) {
		if(this.screen != null) {
			this.screen.dispose();
		}
		this.screen = screen;
		this.setScreen(this.screen);
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
