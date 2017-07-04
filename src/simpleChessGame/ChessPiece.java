package simpleChessGame;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public abstract class ChessPiece {

    int id;

    String name;

    Field currentField;

    boolean isAlive;

    Color color;

    int getID(){
        return id;
    }

    String getName(){
         return name;
    }

    Field getCurrentField(){
        return currentField;
    }

    void setCurrentField(Field newCurrentField){
        currentField = newCurrentField;
    }

    boolean isAlive(){
        return isAlive;
    }

    void setAlive(boolean alive){
        isAlive = alive;
    }

    Color getColor(){
        return color;
    }

    protected Color getEnemyColor(){
        if(color == Color.BLACK){
            return Color.WHITE;
        }else{
            return Color.BLACK;
        }
    }

    public boolean moveTo(Field field) {
        if(canMoveTo().contains(field) && field.isEndangered(getEnemyColor()) && !field.isInUse(getColor())){
            currentField.setInUse(false);
            currentField.setStandingChessPiece(null);
            setCurrentField(field);
            if(field.isInUse()) {
                field.getStandingChessPiece().setAlive(false);
                field.getStandingChessPiece().setCurrentField(null);
            }
            currentField.setStandingChessPiece(this);
            currentField.setInUse(true);
            return true;
        }
        return false;
    }

    abstract Collection<Field> canMoveTo();

    public Collection<ChessPiece> isInDangerFrom() {
        if(currentField.isEndangered(getEnemyColor())) {
            Player enemyPlayer = currentField.getBoard().getPlayer(getEnemyColor());
            List<ChessPiece> inDangerFrom = new ArrayList<>();
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

    public Collection<Field> canMoveToWithoutEndangered() {
        Collection<Field> canMoveTo = canMoveTo();
        return canMoveTo.stream().filter(x -> !x.isEndangered(getEnemyColor())).collect(Collectors.toSet());
    }
}
