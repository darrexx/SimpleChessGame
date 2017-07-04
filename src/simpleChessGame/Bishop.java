package simpleChessGame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class Bishop extends ChessPiece {

    public Bishop(int id, String name, Field currentField, Color color){
        this(id, name, currentField, true, color);
    }

    public Bishop(int id, String name, Field currentField, boolean isAlive, Color color){
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

        boolean canMoveUp = true;
        boolean canMoveDown = true;
        for (int i = 1; i + currentX < board.getFields().length; i++) {
            if (currentY + i < board.getFields()[0].length && board.getFields()[currentX + i][currentY + i].canPlace(getColor(), getEnemyColor()) && canMoveUp) {
                fields.add(board.getFields()[currentX + i][currentY + i]);
            }
            if(board.getFields()[currentX + i][currentY + i].isInUse()){
                canMoveUp = false;
            }
            if (currentY - i >= 0 && board.getFields()[currentX + i][currentY - i].canPlace(getColor(), getEnemyColor()) && canMoveDown) {
                fields.add(board.getFields()[currentX + i][currentY - i]);
            }
            if(board.getFields()[currentX + i][currentY - i].isInUse()){
                canMoveDown = false;
            }
        }
        canMoveUp = true;
        canMoveDown = true;
        for (int i = -1; currentX + i >= 0; i--) {
            if (currentY + i < board.getFields()[0].length && board.getFields()[currentX + i][currentY + i].canPlace(getColor(), getEnemyColor()) && canMoveUp) {
                fields.add(board.getFields()[currentX + i][currentY + i]);
            }
            if(board.getFields()[currentX + i][currentY + i].isInUse()){
                canMoveUp = false;
            }
            if (currentY - i >= 0 && board.getFields()[currentX + i][currentY - i].canPlace(getColor(), getEnemyColor()) && canMoveDown) {
                fields.add(board.getFields()[currentX + i][currentY - i]);
            }
            if(board.getFields()[currentX + i][currentY - i].isInUse()){
                canMoveDown = false;
            }
        }
        return fields;
    }
}
