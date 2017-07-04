package simpleChessGame;


import java.util.Collection;

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

    boolean isAlive(){
        return isAlive;
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

    abstract boolean moveTo(Field field);

    abstract Collection<Field> canMoveTo();

    abstract Collection<ChessPiece> isInDangerFrom();
}
