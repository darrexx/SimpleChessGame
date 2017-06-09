package simpleChessGame;


import java.util.Collection;

public class Board {

    private Collection<Field> fields;

    private Collection<Player> players;

    private Collection<ChessPiece> chessPieces;

    private boolean isGameOver;

    public Board(Collection<Field> fields, Collection<Player> players, Collection<ChessPiece> chessPieces){
        this.fields = fields;
        this.players = players;
        this.chessPieces = chessPieces;
    }

    public Collection<Field> getFields() {
        return fields;
    }

    public Collection<Player> getPlayers() {
        return players;
    }

    public Collection<ChessPiece> getChessPieces() {
        return chessPieces;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }
}
