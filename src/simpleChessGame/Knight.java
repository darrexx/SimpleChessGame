package simpleChessGame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class Knight extends ChessPiece {

    public Knight(int id, String name, Field currentField, Color color){
        this(id, name, currentField, true, color);
    }

    public Knight(int id, String name, Field currentField, boolean isAlive, Color color){
        this.id = id;
        this.name = name;
        this.currentField = currentField;
        this.isAlive = isAlive;
        this.color = color;
    }

    @Override
    public Collection<Field> canMoveTo() {
        List<Field> fields = new ArrayList<>();
        Board board = currentField.getBoard();
        short currentX = currentField.getX();
        short currentY = currentField.getY();

        if(currentX + 1 < board.getFields().length && currentY + 2 < board.getFields()[0].length && board.getFields()[currentX + 1][currentY + 2].canPlace(getColor(), getEnemyColor())){
            fields.add(board.getFields()[currentX + 1][currentY + 2]);
        }

        if(currentX + 2 < board.getFields().length && currentY + 1 < board.getFields()[0].length && board.getFields()[currentX + 2][currentY + 1].canPlace(getColor(), getEnemyColor())){
            fields.add(board.getFields()[currentX + 2][currentY + 1]);
        }

        if(currentX + 2 < board.getFields().length && currentY - 1 >= 0 && board.getFields()[currentX + 2][currentY - 1].canPlace(getColor(), getEnemyColor())){
            fields.add(board.getFields()[currentX + 2][currentY - 1]);
        }

        if(currentX + 1 < board.getFields().length && currentY - 2 >= 0 && board.getFields()[currentX + 1][currentY - 2].canPlace(getColor(), getEnemyColor())){
            fields.add(board.getFields()[currentX + 1][currentY - 2]);
        }

        if(currentX - 1 >= 0 && currentY - 2 >= 0 && board.getFields()[currentX - 1][currentY - 2].canPlace(getColor(), getEnemyColor())){
            fields.add(board.getFields()[currentX - 1][currentY - 2]);
        }

        if(currentX - 2 >= 0 && currentY - 1 >= 0 && board.getFields()[currentX - 2][currentY - 1].canPlace(getColor(), getEnemyColor())){
            fields.add(board.getFields()[currentX - 2][currentY - 1]);
        }

        if(currentX - 2 >= 0 && currentY + 1 < board.getFields()[0].length && board.getFields()[currentX - 2][currentY + 1].canPlace(getColor(), getEnemyColor())){
            fields.add(board.getFields()[currentX - 2][currentY + 1]);
        }

        if(currentX - 1 >= 0 && currentY + 2 < board.getFields()[0].length && board.getFields()[currentX - 1][currentY + 2].canPlace(getColor(), getEnemyColor())){
            fields.add(board.getFields()[currentX - 1][currentY + 2]);
        }

        return fields;
    }
}
