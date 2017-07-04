package simpleChessGame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Pawn extends ChessPiece {

    boolean hasMoved;

    public Pawn(int id, String name, Field currentField, Color color){
        this( id, name, currentField, true, color);
    }

    public Pawn(int id, String name, Field currentField, boolean isAlive, Color color){
        this.id = id;
        this.name = name;
        this.currentField = currentField;
        this.isAlive = isAlive;
        this.color = color;
    }

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

        if(!hasMoved && board.getFields()[currentX][currentY+2].canPlace(getColor(), getEnemyColor())){
            fields.add(board.getFields()[currentX][currentY+2]);
        }

        return fields;
    }

    @Override
    public boolean moveTo(Field field){
        if(super.moveTo(field)){
            hasMoved = true;
            return true;
        }
        return false;

    }
}
