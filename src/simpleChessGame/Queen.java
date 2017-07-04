package simpleChessGame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class Queen extends ChessPiece {

    @Override
    public boolean moveTo(Field field) {
        return false;
    }

    @Override
    public Collection<Field> canMoveTo() {
        List<Field> fields = new ArrayList<>();
        Board board = currentField.getBoard();
        short currentX = currentField.getX();
        short currentY = currentField.getY();
        for(int i = currentX+1; i<board.getFields().length; i++){
            if(!board.getFields()[i][currentY].isInUse() && board.getFields()[i][currentY].isEndangered(color)){
                fields.add(board.getFields()[i][currentY]);
            }
        }
        for(int i = currentX-1; i>=0; i--){
            if(!board.getFields()[i][currentY].isInUse()){
                fields.add(board.getFields()[i][currentY]);
            }
        }
        for(int i = currentY+1; i<board.getFields()[0].length; i++){
            if(!board.getFields()[currentX][i].isInUse()){
                fields.add(board.getFields()[currentX][i]);
            }
        }
        for(int i = currentY-1; i>=0; i--){
            if(!board.getFields()[currentX][i].isInUse()){
                fields.add(board.getFields()[currentX][i]);
            }
        }
        for(int i = 1; i+currentX<board.getFields().length;i++){
            if(currentY+i<board.getFields()[0].length && !board.getFields()[currentX+i][currentY+i].isInUse()){
                fields.add(board.getFields()[currentX+i][currentY+i]);
            }
            if(currentY-i>=0 && !board.getFields()[currentX+i][currentY-i].isInUse()){
                fields.add(board.getFields()[currentX+i][currentY-i]);
            }
        }
        for(int i = -1; i>=0;i--){
            if(currentY+i<board.getFields()[0].length && !board.getFields()[currentX+i][currentY+i].isInUse()){
                fields.add(board.getFields()[currentX+i][currentY+i]);
            }
            if(currentY-i>=0 && !board.getFields()[currentX+i][currentY-i].isInUse()){
                fields.add(board.getFields()[currentX+i][currentY-i]);
            }
        }
        return  fields;
    }

    public Collection<Field> canMoveToWithoutEndangered() {
        Collection<Field> canMoveTo = canMoveTo();
        return canMoveTo.stream().filter(x -> !x.isEndangered(getEnemyColor())).collect(Collectors.toSet());
    }

    @Override
    public Collection<ChessPiece> isInDangerFrom() {
        if(currentField.isEndangered(getEnemyColor())) {
            Player enemyPlayer = currentField.getBoard().getPlayer(getEnemyColor());
            List inDangerFrom = new ArrayList<ChessPiece>();
            for (ChessPiece chessPiece : enemyPlayer.getChessPieces()) {
                if (chessPiece.canMoveTo().contains(currentField)) {
                    inDangerFrom.add(chessPiece);
                }
            }
            return inDangerFrom;
        }
        else{
            return null;
        }
    }
}
