package simpleChessGame;


import java.util.Collection;
import java.util.stream.Collectors;

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
        return getChessPieces().stream().filter(x -> x.isAlive()).collect(Collectors.toList());
    }

    public Collection<ChessPiece> getDeadChessPieces(){
        return getChessPieces().stream().filter(x -> !x.isAlive()).collect(Collectors.toList());
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
