package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class ChessBoard {

    private int ARENA_SIZE = 8;
    private final float BOARD_SIZE = Square.SQUARE_SIZE * 8;

    private Square[][] squares;

    public ChessBoard() {

        float startX = (Gdx.graphics.getWidth() - BOARD_SIZE) / 2;
        float x = startX;
        float y = (Gdx.graphics.getHeight() - BOARD_SIZE) / 2;

        squares = new Square[ARENA_SIZE][ARENA_SIZE];

        for (int file = 0; file < ARENA_SIZE; file++) {
            for (int rank = 0; rank < ARENA_SIZE; rank++) {
                boolean isLightSquare = (file + rank) % 2 == 0;

                Square square = new Square(x, y, isLightSquare);

                squares[file][rank] = square;

                x += Square.SQUARE_SIZE;
            }

            x = startX;
            y += Square.SQUARE_SIZE;
        }
    }

    public Square[][] squares() {
        return squares;
    }

}
