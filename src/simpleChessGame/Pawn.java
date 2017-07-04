package simpleChessGame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Pawn extends ChessPiece {

    //Todo: Implement the en passant Move(https://en.wikipedia.org/wiki/En_passant)
    @Override
    public Collection<Field> canMoveTo() {
        List<Field> fields = new ArrayList<>();
        Board board = currentField.getBoard();
        short currentX = currentField.getX();
        short currentY = currentField.getY();

        if(board.getFields()[currentX][currentY+1].canPlace(getColor(), getEnemyColor())){
            fields.add(board.getFields()[currentX][currentY+1]);
        }

        if(board.getFields()[currentX][currentY+2].canPlace(getColor(), getEnemyColor())){
            fields.add(board.getFields()[currentX][currentY+2]);
        }

        return fields;
    }
}
