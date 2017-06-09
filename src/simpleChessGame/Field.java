package simpleChessGame;


public class Field {

    private int id;

    private String name;

    private ChessPiece standingChessPiece;

    private boolean isInUse;

    public Field(int id, String name) {
        this(id, name, null);
    }

    public Field(int id, String name, ChessPiece standingChessPiece){
        this.id = id;
        this.name = name;
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

    public void setStandingChessPiece(ChessPiece standingChessPiece) {
        this.standingChessPiece = standingChessPiece;
    }

    public boolean isInUse() {
        return isInUse;
    }

    public void setInUse(boolean inUse) {
        isInUse = inUse;
    }
}
