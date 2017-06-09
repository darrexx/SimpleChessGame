package simpleChessGame;

import java.util.Collection;


public class Queen implements ChessPiece {
    @Override
    public int getID() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Field getCurrentField() {
        return null;
    }

    @Override
    public boolean isAlive() {
        return false;
    }

    @Override
    public boolean moveTo(Field field) {
        return false;
    }

    @Override
    public Collection<Field> canMoveTo() {
        return null;
    }

    @Override
    public Collection<ChessPiece> isInDangerFrom() {
        return null;
    }

    @Override
    public Color GetColor() {
        return null;
    }
}
