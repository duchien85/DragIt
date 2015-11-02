package com.dragit.slickstars.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextTooltip;
import com.dragit.slickstars.game.MainGame;
import com.dragit.slickstars.game.MainGame.GameStatus;
import com.dragit.slickstars.util.Font;
import com.dragit.slickstars.util.Logger;

public class MenuScreen implements Screen {
		
	private final String CLASS_NAME = "MenuScreen";
	
	private MainGame game;
	private OrthographicCamera camera;
	
	public MenuScreen(MainGame game) {
		this.game = game;
		this.game.status = GameStatus.GAME_NONE;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, this.game.WIDTH, this.game.HEIGHT);
		
		//createUI();
		
		Logger.log(CLASS_NAME, "started");
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	
	private void createUI() {
		// Todo
		Skin skin = new Skin(Gdx.files.internal(game.UI_SKIN_PATH));
		
		Button buttonStart = new Button(skin);
		//button.addListener(new TextTooltip("This is a tooltip!", skin));
		Table table = new Table();
		table = new Table();
		table.setFillParent(true);
		table.setDebug(true);
		game.stage.addActor(table);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		camera.update();
		game.batch.setProjectionMatrix(camera.combined);
		
		game.batch.begin();
		Font.titleFont.draw(game.batch, "DragIt", (game.WIDTH / 2) - 90f, game.HEIGHT - 200f);
		Font.mainFont.draw(game.batch, "Tap to start", (game.WIDTH / 2) - 45f, game.HEIGHT / 2);
		game.batch.end();
		
		if(Gdx.input.isTouched()) {
			game.setGameScreen(new GameScreen(game));
		}
		
		game.stage.getViewport().setCamera(game.camera);
		game.stage.act(delta);
		game.stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		Logger.log(CLASS_NAME, "disposed");
	}
}
