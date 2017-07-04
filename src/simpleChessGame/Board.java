package simpleChessGame;


import java.util.Collection;

public class Board {

    private Field[][] fields;

    private Collection<Player> players;

    private Collection<ChessPiece> chessPieces;

    private boolean isGameOver;

    public Board(Field[][] fields, Collection<Player> players, Collection<ChessPiece> chessPieces){
        this.fields = fields;
        this.players = players;
        this.chessPieces = chessPieces;
    }

    public Field[][] getFields() {
        return fields;
    }

    public Collection<Player> getPlayers() {
        return players;
    }

    public Player getPlayer(Color color){
        for(Player player : players){
            if(player.getColor() == color){
                return player;
            }
        }
        return null;
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
