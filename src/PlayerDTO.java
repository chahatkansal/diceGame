import java.util.Comparator;

public class PlayerDTO {
    private String name;

    private Integer rank;

    private Integer scoreAchieved;

    private Integer lastMove;

    private boolean skipNextMove;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getScoreAchieved() {
        return scoreAchieved;
    }

    public void setScoreAchieved(Integer scoreAchieved) {
        this.scoreAchieved = scoreAchieved;
    }

    public Integer getLastMove() {
        return lastMove;
    }

    public void setLastMove(Integer lastMove) {
        this.lastMove = lastMove;
    }

    public boolean isSkipNextMove() {
        return skipNextMove;
    }

    public void setSkipNextMove(boolean skipNextMove) {
        this.skipNextMove = skipNextMove;
    }

    public PlayerDTO(String name, Integer rank, Integer scoreAchieved, Integer lastMove, boolean skipNextMove) {
        this.name = name;
        this.rank = rank;
        this.scoreAchieved = scoreAchieved;
        this.lastMove = lastMove;
        this.skipNextMove = skipNextMove;
    }

    public PlayerDTO(String name,Integer scoreAchieved) {
        this.name = name;
        this.scoreAchieved = scoreAchieved;
    }
}
    class SortByScore implements Comparator <PlayerDTO>
    {
        @Override
        public int compare(PlayerDTO playerDTO, PlayerDTO t1) {
            return t1.getScoreAchieved()-playerDTO.getScoreAchieved();
        }
    }


