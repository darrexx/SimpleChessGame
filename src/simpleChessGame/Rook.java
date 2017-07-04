package simpleChessGame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class Rook extends ChessPiece {

    @Override
    public Collection<Field> canMoveTo() {
        List<Field> fields = new ArrayList<>();
        Board board = currentField.getBoard();
        short currentX = currentField.getX();
        short currentY = currentField.getY();
        for(int i = currentX+1; i<board.getFields().length; i++){
            if(board.getFields()[i][currentY].canPlace(getColor(), getEnemyColor())){
                fields.add(board.getFields()[i][currentY]);
            }
            if(board.getFields()[i][currentY].isInUse()){
               break;
            }
        }
        for(int i = currentX-1; i>=0; i--){
            if(board.getFields()[i][currentY].canPlace(getColor(), getEnemyColor())){
                fields.add(board.getFields()[i][currentY]);
            }
            if(board.getFields()[i][currentY].isInUse()){
                break;
            }
        }
        for(int i = currentY+1; i<board.getFields()[0].length; i++){
            if(board.getFields()[currentX][i].canPlace(getColor(), getEnemyColor())){
                fields.add(board.getFields()[currentX][i]);
            }
            if(board.getFields()[currentX][i].isInUse()){
                break;
            }
        }
        for(int i = currentY-1; i>=0; i--){
            if(board.getFields()[currentX][i].canPlace(getColor(), getEnemyColor())){
                fields.add(board.getFields()[currentX][i]);
            }
            if(board.getFields()[currentX][i].isInUse()){
                break;
            }
        }
        return fields;
    }
}
