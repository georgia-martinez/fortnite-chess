package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {

	private ShapeRenderer shapeRenderer;
	private SpriteBatch batch;
	private Pixmap pixmap;

	private int ARENA_SIZE = 8;
	private final int SQUARE_SIZE = 80;
	private final float BOARD_SIZE = SQUARE_SIZE * 8;

	private Texture lightSquare;
	private Texture darkSquare;

	private Sprite[][] squares;

	@Override
	public void create () {
		batch = new SpriteBatch();
		shapeRenderer = new ShapeRenderer();

		pixmap = new Pixmap(SQUARE_SIZE, SQUARE_SIZE, Pixmap.Format.RGBA8888);

		pixmap.setColor(.467f, .584f, .377f, 1);
		pixmap.fillRectangle(0, 0, SQUARE_SIZE, SQUARE_SIZE);

		lightSquare = new Texture(pixmap);

		pixmap.setColor(0.922f, 0.925f, 0.816f, 1);
		pixmap.fillRectangle(0, 0, SQUARE_SIZE, SQUARE_SIZE);

		darkSquare = new Texture(pixmap);

		float startX = (Gdx.graphics.getWidth() - BOARD_SIZE) / 2;
		float x = startX;

		float y = (Gdx.graphics.getHeight() - BOARD_SIZE) / 2;

		squares = new Sprite[ARENA_SIZE][ARENA_SIZE];

		for (int file = 0; file < ARENA_SIZE; file++) {
			for (int rank = 0; rank < ARENA_SIZE; rank++) {
				boolean isLightSquare = (file + rank) % 2 == 0;

				Sprite square = (isLightSquare) ? new Sprite(lightSquare) : new Sprite(darkSquare);
				square.setSize(SQUARE_SIZE, SQUARE_SIZE);
				square.setPosition(x, y);

				squares[file][rank] = square;

				x += SQUARE_SIZE;
			}

			x = startX;
			y += SQUARE_SIZE;
		}
	}

	@Override
	public void render () {
		ScreenUtils.clear(.188f, .180f, .169f, 1);

		batch.begin();

		for (Sprite[] row : squares) {
			for (Sprite square : row) {
				square.draw(batch);
			}
		}

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		shapeRenderer.dispose();
		pixmap.dispose();
	}
}
