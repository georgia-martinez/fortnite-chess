package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
    private SpriteBatch batch;

    private ChessBoard chessBoard;

    @Override
    public void create() {
        batch = new SpriteBatch();
        chessBoard = new ChessBoard();
    }

    @Override
    public void render() {
        ScreenUtils.clear(.188f, .180f, .169f, 1);

        batch.begin();

        drawChessBoard();

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    private void drawChessBoard() {
        for (Square[] row : chessBoard.squares()) {
            for (Square square : row) {
                square.sprite().draw(batch);
            }
        }
    }
}
