package simpleChessGame;


import java.util.Collection;
import java.util.stream.Collectors;

public class Field {

    private final int id;

    private final String name;

    private ChessPiece standingChessPiece;

    private boolean isInUse;

    private Board board;

    private final short x;

    private final short y;

    public Field(int id, short x, short y, String name, Board board) {
        this(id, x, y, name, board, null);
    }

    public Field(int id, short x, short y, String name, Board board, ChessPiece standingChessPiece){
        this.id = id;
        this.x = x;
        this.y = y;
        this.name = name;
        this.board = board;
        this.standingChessPiece = standingChessPiece;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ChessPiece getStandingChessPiece() {
        return standingChessPiece;
    }

    public Board getBoard(){
        return  board;
    }

    public void setStandingChessPiece(ChessPiece standingChessPiece) {
        this.standingChessPiece = standingChessPiece;
        if(standingChessPiece == null){
            setInUse(false);
        }
        else{
            setInUse(true);
        }
    }

    public boolean isInUse() {
        return isInUse;
    }

    public boolean isInUse(Color by){
        return isInUse() && getStandingChessPiece().getColor() == by;
    }

    public void setInUse(boolean inUse) {
        isInUse = inUse;
    }

    public short getX() {
        return x;
    }

    public short getY() {
        return y;
    }

    public boolean isEndangered(Color from) {
        Collection<ChessPiece> chessPieces = getBoard().getPlayer(from).getChessPieces();
        Collection<Field> enemiesCanMoveTo = chessPieces.stream()
                .flatMap(x -> x.canMoveTo().stream())
                .collect(Collectors.toSet());
        if(enemiesCanMoveTo.contains(this)){
            return true;
        }
        return false;
    }

    //Todo isEndangered only needed if King, otherwise it should be possible to move
    public boolean canPlace(Color ownColor, Color enemyColor){
        return isEndangered(enemyColor) && (getStandingChessPiece() == null || !isInUse(ownColor));
    }

    public String toString(){
        return "";
    }
}
