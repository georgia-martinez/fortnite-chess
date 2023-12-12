package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class ChessBoard {

    private int ARENA_SIZE = 8;
    private final int SQUARE_SIZE = 80;
    private final float BOARD_SIZE = SQUARE_SIZE * 8;

    private Texture lightSquare = initTexture(true);
    private Texture darkSquare = initTexture(false);

    private Sprite[][] squares;

    public ChessBoard() {
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

    public Sprite[][] squares() {
        return squares;
    }

    private Texture initTexture(boolean isLightSquare) {
        Pixmap pixmap = new Pixmap(SQUARE_SIZE, SQUARE_SIZE, Pixmap.Format.RGBA8888);

        if (isLightSquare) {
            pixmap.setColor(.467f, .584f, .377f, 1);
        } else {
            pixmap.setColor(0.922f, 0.925f, 0.816f, 1);
        }

        pixmap.fillRectangle(0, 0, SQUARE_SIZE, SQUARE_SIZE);

        return new Texture(pixmap);
    }

}
