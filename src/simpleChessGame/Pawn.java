package simpleChessGame;

import java.util.Collection;

public class Pawn extends ChessPiece {

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
    Collection<Field> canMoveToWithoutEndangered() {
        return null;
    }
}
