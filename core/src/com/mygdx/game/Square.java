package com.mygdx.game;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Square {

    private Sprite sprite;
    public static int SQUARE_SIZE = 80;
    private float x;
    private float y;

    private Texture lightSquare = initTexture(true);
    private Texture darkSquare = initTexture(false);

    public Square(float x, float y, boolean isLight) {
        sprite = (isLight) ? new Sprite(lightSquare) : new Sprite(darkSquare);
        sprite.setSize(SQUARE_SIZE, SQUARE_SIZE);

        sprite.setPosition(x, y);
        this.x = x;
        this.y = y;
    }

    public Sprite sprite() {
        return sprite;
    }

    public float x() {
        return x;
    }

    public float y() {
        return y;
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
