import java.util.List;

public class DiceGame {
    private int totalPlayers;

    private int minimumPoints;

    private List <PlayerDTO> playersList;

    public int getTotalPlayers() {
        return totalPlayers;
    }

    public int getMinimumPoints() {
        return minimumPoints;
    }

    public void setTotalPlayers(int totalPlayers) {
        this.totalPlayers = totalPlayers;
    }

    public void setMinimumPoints(int minimumPoints) {
        this.minimumPoints = minimumPoints;
    }

    public List <PlayerDTO> getPlayersList() {
        return playersList;
    }


    public void setPlayersList(List <PlayerDTO> playersList) {
        this.playersList = playersList;
    }
}


