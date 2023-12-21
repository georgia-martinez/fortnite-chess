package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Piece {

    private Sprite sprite;
    private PieceType type;
    private boolean isWhite;
    private Square square;

    public Piece(PieceType type, boolean isWhite, Square square) {
        this.type = type;
        this.isWhite = isWhite;
        this.square = square;

        setSprite();
    }

    public Sprite sprite() {
        return sprite;
    }

    private void setSprite() {
        String color = isWhite ? "white" : "black";
        String imageName = color + "-" + type.toString().toLowerCase() + ".png";

        Texture texture = new Texture(Gdx.files.internal("pieces/"+imageName));

        sprite = new Sprite(texture);
        sprite.setPosition(square.x(), square.y());
        sprite.setScale(0.5f);
    }
}
