package com.javagame.game;

//import javax.swing.plaf.basic.BasicTabbedPaneUI.MouseHandler;

//import org.w3c.dom.events.MouseEvent;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
//import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;

public class MainMenuScreen implements Screen {

	final JavaGame game;

	OrthographicCamera camera;

	public MainMenuScreen(final JavaGame game) {
		this.game = game;

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
	}

    @Override
	public void render(float delta) {
		ScreenUtils.clear(1, 1, 1f, 1);

		camera.update();
		game.batch.setProjectionMatrix(camera.combined);
		game.batch.begin();
		game.font.setColor(0,0,0,1);
		game.font.draw(game.batch, "Open Dodgeball", 250, 300);
		game.font.draw(game.batch, "Tap left for 1v1", 50, 200);
		game.font.draw(game.batch, "Tap right for multiplayer", 450, 200);
		
		game.batch.end();

		if (Gdx.input.isTouched()&&Gdx.input.getX()<400) {
			game.font.setColor(1,1,1,1);
			game.setScreen(new GameScreen(game));
			dispose();
		} else if (Gdx.input.isTouched()&&Gdx.input.getX()>400){
			game.font.setColor(1,1,1,1);
			game.setScreen(new GameScreenMulti(game));
			dispose();
		}
	}
	@Override
	public void resize(int width, int height) {
	}
	@Override
	public void show() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}

}