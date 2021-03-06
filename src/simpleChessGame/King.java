package simpleChessGame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class King extends ChessPiece {

    public King(int id, String name, Field currentField, Color color){
        this(id, name, currentField, true, color);
    }

    public King(int id, String name, Field currentField, boolean isAlive, Color color){
        this.id = id;
        this.name = name;
        this.currentField = currentField;
        this.isAlive = isAlive;
        this.color = color;
    }

    //Todo Implement Castling(https://en.wikipedia.org/wiki/Castling)
    @Override
    public Collection<Field> canMoveTo() {
        List<Field> fields = new ArrayList<>();
        Board board = currentField.getBoard();
        short currentX = currentField.getX();
        short currentY = currentField.getY();

        if(board.getFields()[currentX][currentY+1].canPlace(getColor(), getEnemyColor())){
            fields.add(board.getFields()[currentX][currentY+1]);
        }

        if(board.getFields()[currentX+1][currentY+1].canPlace(getColor(), getEnemyColor())){
            fields.add(board.getFields()[currentX+1][currentY+1]);
        }

        if(board.getFields()[currentX+1][currentY].canPlace(getColor(), getEnemyColor())){
            fields.add(board.getFields()[currentX+1][currentY]);
        }

        if(board.getFields()[currentX+1][currentY-1].canPlace(getColor(), getEnemyColor())){
            fields.add(board.getFields()[currentX+1][currentY-1]);
        }

        if(board.getFields()[currentX][currentY-1].canPlace(getColor(), getEnemyColor())){
            fields.add(board.getFields()[currentX][currentY-1]);
        }

        if(board.getFields()[currentX-1][currentY-1].canPlace(getColor(), getEnemyColor())){
            fields.add(board.getFields()[currentX-1][currentY-1]);
        }

        if(board.getFields()[currentX-1][currentY].canPlace(getColor(), getEnemyColor())){
            fields.add(board.getFields()[currentX-1][currentY]);
        }

        if(board.getFields()[currentX-1][currentY+1].canPlace(getColor(), getEnemyColor())){
            fields.add(board.getFields()[currentX-1][currentY+1]);
        }
        return fields;
    }
}
