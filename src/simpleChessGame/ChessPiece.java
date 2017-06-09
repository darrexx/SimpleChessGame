package simpleChessGame;


import java.util.Collection;

public interface ChessPiece {

    int getID();

    String getName();

    Field getCurrentField();

    boolean isAlive();

    boolean moveTo(Field field);

    Collection<Field> canMoveTo();

    Collection<ChessPiece> isInDangerFrom();

    Color GetColor();
}
