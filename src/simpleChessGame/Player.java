package simpleChessGame;


import java.util.Collection;

public class Player {

    private String name;

    private Color color;

    private Collection<ChessPiece> chessPieces;

    public Player(Color color, Collection<ChessPiece> chessPieces){
        this(color.toString(), color, chessPieces);
    }

    public Player(String name, Color color, Collection<ChessPiece> chessPieces){
        this.name = name;
        this.color = color;
        this.chessPieces = chessPieces;
    }

    public Collection<ChessPiece> getAliveChessPieces(){
        return null;
    }

    public Collection<ChessPiece> getDeadChessPieces(){
        return null;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Collection<ChessPiece> getChessPieces() {
        return chessPieces;
    }
}
