package com.mygdx.game;

import com.badlogic.gdx.Gdx;

import java.util.Map;

public class ChessBoard {

    private int ARENA_SIZE = 8;
    private final float BOARD_SIZE = Square.SQUARE_SIZE * 8;

    private Square[][] squares = new Square[ARENA_SIZE][ARENA_SIZE];
    private Piece[][] pieces = new Piece[ARENA_SIZE][ARENA_SIZE];

    Map<Character, PieceType> pieceMap = Map.of(
            'p', PieceType.PAWN,
            'n', PieceType.KNIGHT,
            'b', PieceType.BISHOP,
            'r', PieceType.ROOK,
            'q', PieceType.QUEEN,
            'k', PieceType.KING
    );

    private final String START_FEN = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";

    public ChessBoard() {
        createBoard();
        setPieces(START_FEN);
    }

    public Square[][] squares() {
        return squares;
    }

    public Piece[][] pieces() {
        return pieces;
    }

    private void createBoard() {
        float startX = (Gdx.graphics.getWidth() - BOARD_SIZE) / 2;
        float x = startX;
        float y = (Gdx.graphics.getHeight() - BOARD_SIZE) / 2;

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

    public void setPieces(String FEN) {
        int file = 0;
        int rank = 7;

        for (char c : FEN.toCharArray()) {
            if (c == '/') {
                file = 0;
                rank--;

                continue;
            }

            if (Character.isDigit(c)) {
                file += Character.getNumericValue(c);
                continue;
            }

            Piece piece = new Piece(
                    pieceMap.get(Character.toLowerCase(c)),
                    Character.isUpperCase(c),
                    squares[rank][file]
            );

            pieces[file][rank] = piece;

            file++;
        }
    }
}
