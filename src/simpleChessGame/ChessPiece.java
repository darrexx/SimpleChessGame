package simpleChessGame;


import java.util.Collection;

public abstract class ChessPiece {

    int id;

    String name;

    Field currentField;

    boolean isAlive;

    Color color;

    abstract int getID();

    abstract String getName();

    abstract Field getCurrentField();

    abstract boolean isAlive();

    abstract boolean moveTo(Field field);

    abstract Collection<Field> canMoveTo();

    abstract Collection<ChessPiece> isInDangerFrom();

    abstract Color GetColor();
}
