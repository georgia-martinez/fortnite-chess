package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {

	private ShapeRenderer shapeRenderer;
	private SpriteBatch batch;

	@Override
	public void create () {
		batch = new SpriteBatch();
		shapeRenderer = new ShapeRenderer();
	}

	@Override
	public void render () {
		ScreenUtils.clear(.188f, .180f, .169f, 1);
		batch.begin();
		batch.end();

		int ARENA_SIZE = 8;
		float SQUARE_SIZE = 80;
		float BOARD_SIZE = SQUARE_SIZE * 8;

		float startX = (Gdx.graphics.getWidth() - BOARD_SIZE) / 2;
		float x = startX;

		float y = (Gdx.graphics.getHeight() - BOARD_SIZE) / 2;

		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

		for (int file = 0; file < ARENA_SIZE; file++) {
			for (int rank = 0; rank < ARENA_SIZE; rank++) {
				boolean isLightSquare = (file + rank) % 2 == 0;

				if (isLightSquare) {
					shapeRenderer.setColor(.467f, .584f, .377f, 1);
				} else {
					shapeRenderer.setColor(0.922f, 0.925f, 0.816f, 1);
				}

				shapeRenderer.rect(x, y, SQUARE_SIZE, SQUARE_SIZE);

				x += SQUARE_SIZE;
			}

			x = startX;
			y += SQUARE_SIZE;
		}

		shapeRenderer.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		shapeRenderer.dispose();
	}
}
